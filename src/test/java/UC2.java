import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class UC2 {
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
        String sql = " ALTER TABLE payroll ADD start_date VARCHAR(30)";
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
        UC2 epr = new UC2();
        epr.JDBCConnection();

    }
}
