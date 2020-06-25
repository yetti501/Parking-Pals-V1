import jdk.nashorn.internal.runtime.ECMAException;

import java.sql.*;

public class JDBC{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //                            jdbc:mysql://localhost:3306/ParkingPalConnection
    static final String DB_URL = "jdbc:mysql://localhost:3306/ParkingPalConnection";
            //"jdbc:mysql://localhost:3306/ParkingPalConnection?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";


    // Test to make sure that I am connected.
    public static String connectDB() {
        Connection conn = null;
        Statement stmt = null;
        try{
            if (conn == null){
                //STEP 2: Register JDBC driver
                Class.forName(JDBC_DRIVER);
                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                //STEP 4: Execute a query
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM parkingpal.ticketdata;");
                String name = "";
                while (rs.next()){
                    name = rs.getString("ticketNumber");
                    System.out.println(name);
                }
                return name;
                //System.out.println("Database created successfully...");

            }

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
//        finally{
//            //finally block used to close resources
//            try{
//                if(stmt!=null)
//                    stmt.close();
//            }catch(SQLException se2){
//            }// nothing we can do
//            try{
//                if(conn!=null)
//                    conn.close();
//            }catch(SQLException se){
//                se.printStackTrace();
//            }//end finally try
//        }//end try
        System.out.println("Goodbye!");
        return "BAD";
    }

    public static Connection openDB() throws ClassNotFoundException, SQLException {
        try {

            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            return DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception ex) {
            return null;
        }
    }

    public static String executeQuery(String incoming) throws SQLException {
        Connection var;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            var = openDB();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "The database did not load correctly.";
        }

        try {
            try {
                stmt = var.createStatement();
                try {
                    rs = stmt.executeQuery(incoming);
                    if (stmt.execute(incoming)) {
                        rs = stmt.getResultSet();
                    }
                    String name = "";
                    while (rs.next()) {
                        name = rs.getString("ticketNumber");
                    }
                    //            closeDB(var);
                    return name;
                } catch (Exception e){
                    e.printStackTrace();
                    return "problem in stmt.executeQuery(incoming);";
                }
            } catch (Exception e){
                e.printStackTrace();
                return "problem in var.createStatement(); STILL PROBLEM???";
            }
        } catch (Exception e){

            e.printStackTrace();
            return "The statement didn't execute correctly.";
        }


    }

    public static String closeDB(Connection conn) throws SQLException {
        if(conn != null) {
            conn.close();
            return "DB connection closed";
        } else {
            return "DB connection not closed";
        }
    }

    //end main
}//end JDBCExample