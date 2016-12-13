package com.lottery.mybatis.juice;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.PrivateModule;
import com.google.inject.util.Providers;
import com.lottery.guice.GuiceKeys;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.mybatis.guice.mappers.MapperProvider;
import org.mybatis.guice.session.SqlSessionManagerProvider;

import java.io.Reader;
import java.util.Collection;
import java.util.Map;

/**
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-09-05
 * Time: 18:11
 */
public class MultiXMLMybatisModule extends AbstractModule {

    private ArgEntry[] argEntries;

    public MultiXMLMybatisModule(ArgEntry... argEntries) {
        this.argEntries = argEntries;
        Preconditions.checkArgument(ArrayUtils.isNotEmpty(argEntries), "argEntries is empty");
    }

    @Override
    protected void configure() {
        // 注册多个SqlSessionManager组成Map结构,用于事务拦截器构建,由于在PrivateModule则利用对象引用特性外部定义
        bind(GuiceKeys.getSimpleKey(Map.class, String.class, SqlSessionManager.class)).toInstance(Maps
                .<String, SqlSessionManager>newConcurrentMap());
        for (final ArgEntry argEntry : argEntries) {
            install(new PrivateModule() {
                @Override
                protected void configure() {
                    bind(SqlSessionManager.class).toProvider(SqlSessionManagerProvider.class)
                            .asEagerSingleton();
                    bind(SqlSession.class).to(SqlSessionManager.class).asEagerSingleton();

                    Reader reader = null;
                    try {
                        // 根据xml构建SqlSessionFactory
                        reader = Resources.getResourceAsReader(argEntry.getXmlPath());
                        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,
                                argEntry.getEnvironmentId());
                        bind(SqlSessionFactory.class).toInstance(sqlSessionFactory);

                        Configuration configuration = sqlSessionFactory.getConfiguration();
                        // 绑定mapper
                        Collection<Class<?>> mapperClass = configuration.getMapperRegistry().getMappers();
                        for (Class mapper : mapperClass) {
                            bindMapper(binder(), mapper);
                            expose(mapper);
                        }
                    } catch (Exception e) {
                        addError("Impossible to read classpath resource '%s', see nested exceptions: %s", argEntry.getXmlPath(), e.getMessage());
                        addError(e);
                    } finally {
                        IOUtils.closeQuietly(reader);
                    }
                }
            });
        }
    }

    /**
     * 绑定mapper
     * @param binder
     * @param mapperType
     * @param <T>
     */
    private <T> void bindMapper(Binder binder, Class<T> mapperType) {
        binder.bind(mapperType).toProvider(Providers.guicify(new MapperProvider(mapperType)))
                .asEagerSingleton();
    }

    public static class ArgEntry {
        private String environmentId;
        private String xmlPath;

        public ArgEntry(String environmentId, String xmlPath) {
            this.environmentId = environmentId;
            this.xmlPath = xmlPath;
        }

        public String getEnvironmentId() {
            return environmentId;
        }

        public String getXmlPath() {
            return xmlPath;
        }
    }
}
