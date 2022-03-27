package ru.sergeysemenov.spring_test.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthoritiesService {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getAllRoles() {
        List<String> allRoles = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement prStatement = connection.prepareStatement("SELECT DISTINCT authority FROM authorities");
            ResultSet rSet = prStatement.executeQuery();
            while (rSet.next()) {
                allRoles.add(rSet.getString("authority"));
            }
            rSet.close();
            prStatement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allRoles;
    }

}
