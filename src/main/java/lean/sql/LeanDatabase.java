package lean.sql;

import java.sql.*;

public class LeanDatabase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/employees?useSSL=false";
    static final String USER = "julian";
    static final String PASS = "julian123";

    public static void testSql() {
        Connection conn = null;
        Statement stmt = null;
        try{
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT emp_no, first_name, last_name from employees limit 6";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id  = rs.getInt("emp_no");
                String name = rs.getString("first_name") + " " + rs.getString("last_name");
                System.out.print("id: " + id);
                System.out.print("name: " + name);
                System.out.print("\n");
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Done");
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null && !stmt.isClosed()) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null && !conn.isClosed()) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}