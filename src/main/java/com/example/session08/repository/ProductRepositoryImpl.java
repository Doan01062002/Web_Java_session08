package com.example.session08.repository;

import com.example.session08.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/ss08_java_web?useSSL=false&serverTimezone=UTC";
    private final String USERNAME = "root";
    private final String PASSWORD = "01062002";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall("CALL sp_get_all_products()");
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setStock(resultSet.getInt("stock"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findById(int id) {
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL sp_get_product_by_id(?)}");
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setStock(resultSet.getInt("stock"));
                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Product p) {
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL sp_add_product(?,?,?,?)}");
            callableStatement.setString(1, p.getName());
            callableStatement.setString(2, p.getDescription());
            callableStatement.setDouble(3, p.getPrice());
            callableStatement.setInt(4, p.getStock());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product p) {
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL sp_update_product(?,?,?,?,?)}");
            callableStatement.setInt(1, p.getId());
            callableStatement.setString(2, p.getName());
            callableStatement.setString(3, p.getDescription());
            callableStatement.setDouble(4, p.getPrice());
            callableStatement.setInt(5, p.getStock());
            callableStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL sp_delete_product(?)}");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> searchName(String keyword) {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL sp_search_product_by_name(?)}");
            callableStatement.setString(1, keyword);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setStock(resultSet.getInt("stock"));
                list.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
