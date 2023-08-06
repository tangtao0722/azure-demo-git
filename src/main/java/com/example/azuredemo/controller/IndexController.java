package com.example.azuredemo.controller;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 默认控制器
 * @author 37152
 */
@RestController
public class IndexController {

    /**
     *
     * @return
     */
    @GetMapping
    public String index(){
        return "azure-demo-git::0806::0831";
    }

    @GetMapping("/demoMSI")
    @ResponseBody
    public String demoMSI(){
        String result = "";
        SQLServerDataSource dataSource = new SQLServerDataSource();
        // Replace with your server name
        //demo-rg-sqldb-server.database.windows.net
        dataSource.setServerName("demo-rg-sqldb-server.database.windows.net");
        // Replace with your database name
        dataSource.setDatabaseName("demo-re-sqldb");
        dataSource.setAuthentication("ActiveDirectoryManagedIdentity");
        try{
            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUSER_SNAME()");
            if (rs.next()) {
                result = "You have successfully logged on as: " + rs.getString(1);
                System.out.println(result);
            }
        }catch (Exception e){

        }
        return result;
    }
}


