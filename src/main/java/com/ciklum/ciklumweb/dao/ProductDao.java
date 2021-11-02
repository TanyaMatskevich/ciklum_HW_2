package com.ciklum.ciklumweb.dao;

import com.ciklum.ciklumweb.domain.Product;
import com.ciklum.ciklumweb.util.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private final Connection connection;

    public ProductDao() {
        connection = DataBaseConnection.getConnection();
    }

    public void addProduct(Product product) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into products(name,price,status) values (?, ?, ?)");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setString(3, product.getStatus());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from products where id=?");
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from products");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setStatus(rs.getString("status"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int productId) {
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from products where id=?");
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                product.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}
