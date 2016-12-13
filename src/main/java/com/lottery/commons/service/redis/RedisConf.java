package com.lottery.commons.service.redis;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * redis 配置
 * <p/>
 * User: ryanshi@tcl.com
 * Date: 2016-08-17
 * Time: 16:06
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class RedisConf {

    @XmlElement(name = "mode", required = false)
    private String mode;
    @XmlElement(name = "path", required = false)
    private String path;
    @XmlElementWrapper(name = "servers")
    @XmlElement(name = "server", required = true)
    private List<ServerElement> servers = Lists.newArrayList();
    @XmlElementWrapper(name = "groups")
    @XmlElement(name = "group", required = true)
    private List<GroupElement> groups = Lists.newArrayList();

    public String getMode() {
        return mode;
    }

    public String getPath() {
        return path;
    }

    public Map<String, ServerElement> getServers() {
        ImmutableMap.Builder<String, ServerElement> builder = ImmutableMap.builder();
        if (servers != null) {
            for (ServerElement element : servers) {
                builder.put(element.getName(), element);
            }
        }
        return builder.build();
    }

    public Map<String, GroupElement> getGroups() {
        ImmutableMap.Builder<String, GroupElement> builder = ImmutableMap.builder();
        if (groups != null) {
            for (GroupElement element : groups) {
                builder.put(element.getName(), element);
            }
        }
        return builder.build();
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "servers")
    public static class ServerElement {
        @XmlAttribute(name = "name", required = true)
        private String name;
        @XmlAttribute(name = "host", required = true)
        private String host;
        @XmlAttribute(name = "port", required = true)
        private int port = 6379;
        @XmlAttribute(name = "auth", required = false)
        private String auth;
        @XmlAttribute(name = "dbIndex", required = false)
        private int dbIndex = 0;

        public String getName() {
            return name;
        }

        public String getHost() {
            return host;
        }

        public int getPort() {
            return port;
        }

        public String getAuth() {
            return auth;
        }

        public int getDbIndex() {
            return dbIndex;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "groups")
    public static class GroupElement {
        @XmlAttribute(name = "name", required = true)
        private String name;
        @XmlElementWrapper(name = "servers")
        @XmlElement(name = "server", required = true)
        private List<GroupServerElement> servers = Lists.newArrayList();
        @XmlElementWrapper(name = "properties")
        @XmlElement(name = "property", required = true)
        private List<PropertyElement> properties = Lists.newArrayList();

        public String getName() {
            return name;
        }

        public List<GroupServerElement> getServers() {
            return servers;
        }

        public List<PropertyElement> getProperties() {
            return properties;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "servers")
    public static class GroupServerElement {
        @XmlAttribute(name = "name", required = true)
        private String name;
        @XmlAttribute(name = "weight", required = false)
        private int weight = 1;

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "properties")
    public static class PropertyElement {
        @XmlAttribute(name = "name", required = true)
        private String name;
        @XmlValue
        private String value;

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

}
