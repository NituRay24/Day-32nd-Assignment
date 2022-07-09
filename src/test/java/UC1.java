import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class UC1 {
    public void JDBCConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/Employeepayroll3";
        String user = "root";
        String pwd = "  ";
//Step 2: Establish the connection (path)
        Connection con = DriverManager.getConnection(url,user,pwd);

// Step3: Create a statement object
        Statement st = con.createStatement();
        String sql="  USE Employeepayroll3";
        ResultSet rs = st.executeQuery(sql);

// Step 5: Iterate
        while(rs.next()){
            System.out.println( "Name: " + rs.getString(1)+
                    " contact: "+ rs.getString(2)+
                    " Address:"+rs.getString(3)+
                    " Emp id: "+ rs.getString(4)
            );
        }
        con.close();
    }

    public static void main(String[] args) throws Exception {
// step 1: load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        UC1 epr = new UC1();
        epr.JDBCConnection();
    }




}
