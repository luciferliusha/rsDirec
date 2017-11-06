package com.zjcds.xa.common.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTool {

    public List getDataByJdbc(String db_url,String username,String password,String sqlstr){
        List<Map<String, Object>> datalist = new ArrayList<Map<String,Object>>();
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            //把Driver类装载进jvm
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 打开链接
            //System.out.println("连接数据库...");
            conn = (Connection) DriverManager.getConnection(db_url,username,password);

            // 执行查询
            System.out.println(" 实例化Statement对...");
            stmt = (Statement) conn.createStatement();
            String sql;
            sql =sqlstr;
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据
            int columnCount = md.getColumnCount();   //获得列数
            while (rs.next()) {
                Map<String,Object> rowData = new HashMap<String,Object>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                datalist.add(rowData);

            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        //System.out.println("Goodbye!");

        return datalist;
    }
}
