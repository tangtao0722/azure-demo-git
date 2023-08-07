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
        return "azure-demo-git::0807::2253";
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

//        dataSource.setMSIClientId("");
        try{
            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUSER_SNAME()");
            if (rs.next()) {
                result = "demoMSI::You have successfully logged on as: " + rs.getString(1);
                System.out.println(result);
            }
        }catch (Exception e){
            result="连接异常："+e.getMessage();

        }
        return result;
    }

    @GetMapping("/demoMSI1")
    @ResponseBody
    public String demoMSI1(){
        String result = "";
        SQLServerDataSource dataSource = new SQLServerDataSource();
        // Replace with your server name
        //demo-rg-sqldb-server.database.windows.net
//        dataSource.setServerName("demo-rg-sqldb-server.database.windows.net");
        // Replace with your database name
//        dataSource.setDatabaseName("demo-re-sqldb");
//        dataSource.setAuthentication("ActiveDirectoryManagedIdentity");
        dataSource.setURL("jdbc:sqlserver://demo-rg-sqldb-server.database.windows.net:1433;database=demo-re-sqldb;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;Authentication=ActiveDirectoryIntegrated");
        try{
            Connection connection = dataSource.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUSER_SNAME()");
            if (rs.next()) {
                result = "demoMSI1::You have successfully logged on as: " + rs.getString(1);
                System.out.println(result);
            }
        }catch (Exception e){
            result="连接异常："+e.getMessage();

        }
        return result;
    }
}


