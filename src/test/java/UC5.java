import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class UC5 {
    public void JDBCConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/Employeepayroll3";
        String user = "root";
        String pwd = "  ";
//Step 2: Establish the connection (path)
        Connection con = DriverManager.getConnection(url, user, pwd);

// Step3: Create a statement object
        Statement st = con.createStatement();
        // String sql="  USE Employeepayroll3";
        // String sql=" CREATE TABLE payroll(emp_id INT(15), name VARCHAR(30),contact INT(25), address VARCHAR(35))";
        //String sql="  ALTER TABLE payroll ADD salary INT(40)";
        // String sql = " ALTER TABLE payroll ADD start_date VARCHAR(30)";
        // String sql ="  INSERT INTO payroll VALUES('rohan',79384038,'mumbai',05,200000,2020-01-21)";
        //String sql="  SELECT * FROM payroll";
        String sql = " SELECT salary FROM payroll WHERE name='shyam'";
        ResultSet rs = st.executeQuery(sql);

// Step 5: Iterate
        while (rs.next()) {
            System.out.println("Name: " + rs.getString(1) +
                    " contact: " + rs.getString(2) +
                    " Address:" + rs.getString(3) +
                    " Emp id: " + rs.getString(4) +
                    "salary:" +rs.getString(5)+
                    "start_date :" +rs.getString(6)

            );
        }
        con.close();
    }

    public static void main(String[] args) throws Exception {
// step 1: load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        UC5 epr = new UC5();
        epr.JDBCConnection();

    }

}
