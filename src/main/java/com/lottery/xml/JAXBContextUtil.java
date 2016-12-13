package com.lottery.xml;


import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.InputStream;

/**
 * xml解析的工具类
 * <p>
 * User: ryanshi@tcl.com
 * Date: 2016-11-24
 * Time: 15:40
 */
public final class JAXBContextUtil {

    public JAXBContextUtil() {};

    public static <T> T unmarshal(Class<T> clazz, String xmlPath) {
        InputStream in = null;
        try {
            in = clazz.getClassLoader().getResourceAsStream(xmlPath);
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            return (T) jaxbContext.createUnmarshaller().unmarshal(in);
        } catch (JAXBException e) {
            throw new RuntimeException("failed to unmarshal object for class:" + clazz + " xml:" + xmlPath, e);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

}
