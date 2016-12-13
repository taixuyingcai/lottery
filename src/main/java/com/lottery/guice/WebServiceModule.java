package com.lottery.guice;

import com.lottery.mybatis.juice.MultiXMLMybatisModule;
import com.lottery.service.admin.AdminServiceModule;
import com.lottery.service.bill.BillServiceModule;

/**
 * 业务注入服务
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-26
 * Time: 18:28
 */
public class WebServiceModule extends ServiceModule {
    @Override
    protected void configure() {
        install(new MultiXMLMybatisModule(new MultiXMLMybatisModule.ArgEntry("development", "sqlMapConfig.xml")));
        install(new AdminServiceModule());
        install(new BillServiceModule());
    }
}
