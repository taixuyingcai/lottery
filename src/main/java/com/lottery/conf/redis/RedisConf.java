package com.lottery.conf.redis;

import com.google.common.collect.Lists;
import com.lottery.enums.ModeEnum;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-24
 * Time: 16:01
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class RedisConf {

    @XmlElement(name = "mode", required = false)
    private String mode = ModeEnum.LOCAL.name();

    @XmlElement(name = "path", required = false)
    private String path;

    @XmlElementWrapper(name = "services")
    @XmlElement(name = "service", required = true)
    private List<ServiceElement> services = Lists.newArrayList();

    @XmlElementWrapper(name = "groups")
    @XmlElement(name = "group", required = true)
    private List<GroupElement> groups = Lists.newArrayList();

    public List<ServiceElement> getServices() {
        return services;
    }

    public List<GroupElement> getGroups() {
        return groups;
    }

    public String getMode() {
        return mode;
    }

    public String getPath() {
        return path;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "services")
    public static class ServiceElement {
        @XmlAttribute(name = "name", required = true)
        private String name;

        @XmlAttribute(name = "host", required = true)
        private String host;

        @XmlAttribute(name = "port", required = true)
        private int port = 65534;

        @XmlAttribute(name = "dbIndex", required = true)
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

        public int getDbIndex() {
            return dbIndex;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "groups")
    public static class GroupElement {

        @XmlElementWrapper(name = "services")
        @XmlElement(name = "service", required = true)
        private List<GroupServiceElement> groupServiceElements = Lists.newArrayList();

        @XmlElementWrapper(name = "properties")
        @XmlElement(name = "property", required = true)
        private List<PropertyElement> propertyElements = Lists.newArrayList();

        public List<GroupServiceElement> getGroupServiceElements() {
            return groupServiceElements;
        }

        public List<PropertyElement> getPropertyElements() {
            return propertyElements;
        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "services")
    public static class GroupServiceElement {
        @XmlAttribute(name = "name", required = true)
        private String name;

        @XmlAttribute(name = "weight", required = true)
        private int weight;

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
