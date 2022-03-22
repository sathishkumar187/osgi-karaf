package com.shop.product.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Map;

/**
 * Rest activator.
 *
 * @author SathishKumarS
 */
@Component(immediate = true, name = "jdbc")
public class RestActivator {

    @Reference
    private ShopController shopController;
    private Server server;

    /**
     * To activate the rest service.
     */
    @Activate
    public void activate(Map<String, String> properties) {
        System.out.println("Activated");

         try {
             final JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();

             factoryBean.setAddress("/shop");
             factoryBean.setBus(BusFactory.getDefaultBus());
             factoryBean.setProvider(new JacksonJsonProvider());
             factoryBean.setServiceBean(shopController);

             server = factoryBean.create();
         } catch (Exception exception) {
             exception.printStackTrace();
         }
    }

    @Deactivate
    public void deactivate() {
        if (server != null) {
            server.destroy();
        }
    }
}
