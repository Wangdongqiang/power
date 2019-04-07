package com.app.power;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PowerApplication.class })
public class BadgerDruidApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement = connection
                .prepareStatement("select * from t7 ");
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()) {
//            String cityName = resultSet.getString("name");
            System.out.println("ok");
        }
    }
}