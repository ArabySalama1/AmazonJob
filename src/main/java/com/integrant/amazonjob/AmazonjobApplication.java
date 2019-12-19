package com.integrant.amazonjob;

import com.integrant.amazonjob.bl.AmazonBl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AmazonjobApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(AmazonjobApplication .class, args);
        AmazonBl amazonBl=app.getBean(AmazonBl.class);
        amazonBl.addCustomers();
        amazonBl.addOrders();
        amazonBl.addItems();
        amazonBl.addPrices();




    }






}
