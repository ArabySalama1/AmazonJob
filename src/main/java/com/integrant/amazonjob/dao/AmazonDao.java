package com.integrant.amazonjob.dao;


import com.integrant.amazonjob.util.ConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class AmazonDao {

    @Autowired
    private ConnectionUtil connectionUtil;

    private final String customersQuery = "insert into customers values(?,?,?,?)";
    private final String ordersQuery = "insert into orders values(?,?,?)";
    private final String itemsQuery = "insert into items values(?,?,?)";
    private final String pricesQuery = "insert into prices values(?,?,?,?,?)";

    public void addCustomers() {
        Connection connection = connectionUtil.getConnection();
        final int batchSize = 1000;
        PreparedStatement customerPstmt = null;
        try {
            customerPstmt = connection.prepareStatement(customersQuery);
            for (int i = 1; i < 500000; i++) {
                customerPstmt.setInt(1,  i);
                customerPstmt.setString(2, "customer_name" + i);
                customerPstmt.setString(3, "customer_address" + i);
                customerPstmt.setString(4, "phone_number" + i);
                customerPstmt.addBatch();
                if (i % batchSize == 0) {
                    customerPstmt.executeBatch();
                }
            }
            customerPstmt.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionUtil.closeConnection(connection, customerPstmt);
        }
    }

    public void addOrders() {
        Connection connection = connectionUtil.getConnection();
        final int batchSize = 1000;
        PreparedStatement ordersPstmt = null;
        try {
            ordersPstmt = connection.prepareStatement(ordersQuery);
            for (int i = 1; i < 500000; i++) {
                ordersPstmt.setInt(1,  i);
                ordersPstmt.setString(2, "order_number" + i);
                ordersPstmt.setInt(3,   i);
                ordersPstmt.addBatch();
                if (i % batchSize == 0) {
                    ordersPstmt.executeBatch();
                }
            }
            ordersPstmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionUtil.closeConnection(connection, ordersPstmt);
        }
    }


    public void addItems() {
        Connection connection = connectionUtil.getConnection();
        final int batchSize = 1000;
        PreparedStatement itemsPstmt = null;
        try {
            itemsPstmt = connection.prepareStatement(itemsQuery);
            for (int i = 1; i < 500000; i++) {
                itemsPstmt.setInt(1,  i);
                itemsPstmt.setString(2, "item_name" + i);
                itemsPstmt.setInt(3,   i);
                itemsPstmt.addBatch();
                if (i % batchSize == 0) {
                    itemsPstmt.executeBatch();
                }
            }
            itemsPstmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionUtil.closeConnection(connection, itemsPstmt);
        }
    }


    public void addPrices() {
        Connection connection = connectionUtil.getConnection();
        final int batchSize = 1000;
        PreparedStatement pricePstmt = null;
        try {
            pricePstmt = connection.prepareStatement(pricesQuery);
            for (int i = 1; i < 500000; i++) {
                pricePstmt.setInt(1,  i);
                pricePstmt.setFloat(2, i);
                Date start=new Date(ThreadLocalRandom.current().nextInt() * 1000L);
                Date end=new Date(ThreadLocalRandom.current().nextInt() * 1000L);

                if(!end.after(start)){
                   end=start;
                }
                pricePstmt.setDate(3,start);
                pricePstmt.setDate(4,end);
                pricePstmt.setInt(5,   i);
                pricePstmt.addBatch();
                if (i % batchSize == 0) {
                    pricePstmt.executeBatch();
                }
            }
            pricePstmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionUtil.closeConnection(connection, pricePstmt);
        }
    }


}
