package com.integrant.amazonjob.bl;

import com.integrant.amazonjob.dao.AmazonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmazonBl {

    @Autowired
    private AmazonDao amazonDao;

    public void addCustomers(){
        amazonDao.addCustomers();
    }

    public void addOrders(){
        amazonDao.addOrders();
    }

    public void addItems(){
        amazonDao.addItems();
    }

    public void addPrices(){
        amazonDao.addPrices();
    }
}
