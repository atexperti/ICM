/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.icm.jaxb.util;

/**
 *
 * @author spatkari
 */
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class JaxbUnMarshaller {

    public static void main(String args[]) {
        try {
            JAXBContext jContext =
                    JAXBContext.newInstance(Layout.class);
            System.out.println("context ok");

            Unmarshaller unmarshaller = jContext.createUnmarshaller();
            System.out.println("unmarshaller ok");

            WebApplicationContext appContext = new XmlWebApplicationContext();
            Resource resource = appContext.getResource("classpath:layout.xml");
            
            Layout layout = (Layout) unmarshaller.unmarshal(resource.getInputStream());

            System.out.println("LHS1:"+layout.getLeftside().getLs1());
            System.out.println("LHS2:"+layout.getLeftside().getLs2());
            System.out.println("LHS3:"+layout.getLeftside().getLs3());
            System.out.println("RHS1:"+layout.getRightside().getRs1());
            System.out.println("RHS2:"+layout.getRightside().getRs2());
            System.out.println("RHS2:"+layout.getRightside().getRs3());
            




        } catch (Exception e1) {
            System.out.println("" + e1);
        }

    }
}
