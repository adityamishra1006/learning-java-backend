package com.example.L12_Spring_JDBC_Demo.dao;


import com.example.L12_Spring_JDBC_Demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductSpringJDBCDao {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private ProductMapper productMapper;

    @Value("${product.query.find.by.id}")
    private String findById;

    public Product getById(Long id){

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("id", id);
//        String selectQuery = "SELECT * FROM product where id = :id";
        List<Product> products = namedParameterJdbcTemplate.query(findById, parameters, productMapper);
        if(!products.isEmpty()){
            return products.get(0);
        }
        else return null;
    }

    public Product create(Product product){
        String insertquery = "INSERT INTO product (name, cost) VALUES (:name, :cost)";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("name", product.getName());
        parameters.addValue("cost", product.getCost());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(insertquery, parameters, keyHolder);
        product.setId(keyHolder.getKey().longValue());
        return product;
    }

    public Product update(Long id, Product product){
        String updateQuery = "update product set name = :name, cost = :cost where id = :id";
        MapSqlParameterSource paremeter = new MapSqlParameterSource();
        paremeter.addValue("name", product.getName());
        paremeter.addValue("cost", product.getCost());
        paremeter.addValue("id", id);
        int affectedRow = namedParameterJdbcTemplate.update(updateQuery, paremeter);
        if(affectedRow == 0){
            return null;
        }
        product.setId(id);
        return product;
    }

    public Product delete(Long id){
        Product existingProduct = getById(id);
        if(existingProduct == null){
            return null;
        }

        String deleteQuery = "delete from product where id = :id";
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);
        int affectedRow = namedParameterJdbcTemplate.update(deleteQuery, parameter);

        return existingProduct;
    }
}
