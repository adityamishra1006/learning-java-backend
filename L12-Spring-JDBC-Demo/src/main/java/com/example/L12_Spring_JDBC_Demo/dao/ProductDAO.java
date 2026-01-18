package com.example.L12_Spring_JDBC_Demo.dao;


import com.example.L12_Spring_JDBC_Demo.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.util.UrlPathHelper;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductDAO {

    private final UrlPathHelper urlPathHelper;
    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    private Map<Long, Product> dataStore = new HashMap<>();
    private AtomicLong nextId = new AtomicLong(1L);

    public ProductDAO(UrlPathHelper urlPathHelper) {
        this.urlPathHelper = urlPathHelper;
    }

    public Product getProductById(Long id){
        Product product = null;
        String query = "select * from product where id ="+id;
        try(Connection con = DriverManager.getConnection(dbUrl, username, password)) {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                product = new Product(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getDouble("cost"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;
        return product;
    }

//    public Product create(Product product){
//        try(Connection con = DriverManager.getConnection(dbUrl, username, password)) {
//            String sqlInsert = "insert into product values(null,'"+product.getName()+"',"+product.getCost()+")";
//            Statement statement = con.createStatement();
//            int affectedRow = statement.executeUpdate(sqlInsert, Statement.RETURN_GENERATED_KEYS);
//            if(affectedRow == 0){
//                throw new SQLException("Creating product failed, no rows affected.");
//            }
//            ResultSet generatedKeys = statement.getGeneratedKeys();
//            if(generatedKeys.next()){
//                product.setId(generatedKeys.getLong(1));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } ;
//        return product;
//    }


    public Product create(Product product){
        Connection con = null;
        boolean autoCommit = false;
        try{
            con = DriverManager.getConnection(dbUrl, username, password);
            autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);
            String sqlInsert = "insert into product values (null, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getCost());

            int affectedRow = preparedStatement.executeUpdate();
            if(affectedRow == 0){
                throw new SQLException("Creating product failed, no rows affected.");
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                product.setId(generatedKeys.getLong(1));
            }
            con.commit();
        } catch (SQLException e) {
            try{
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        finally {
            if(con != null){
                try{
                    con.setAutoCommit(autoCommit);
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return product;
    }

    public Product update(Long id, Product product){
        Product existingProduct = dataStore.get(id);
        if(existingProduct == null){
            return null;
        } else {
            existingProduct.setName(product.getName());
            existingProduct.setCost(product.getCost());
            dataStore.put(id, existingProduct);
            return existingProduct;
        }
    }

    public Product delete(Long id){
        Product existingProduct = dataStore.get(id);
        if(existingProduct == null){
            return null;
        } else {
            dataStore.remove(id);
            return existingProduct;
        }
    }
}
