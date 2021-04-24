import java.sql.*;   // Needed for JDBC classes

/**
  This program creates a Customer
  table in the CoffeeDB database.
*/

public class CreateCustomerTable
{
   public static void main(String[] args)
   {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby:CoffeeDB";

      try
      {
         // Create a connection to the database.
         Connection conn = DriverManager.getConnection(DB_URL);

         // Get a Statement object.
         Statement stmt = conn.createStatement();

         // Make an SQL statement to create the table.
         String sql = "CREATE TABLE Customer" +
            "( CustomerNumber CHAR(10) NOT NULL PRIMARY KEY, " +
            "  Name CHAR(25),"    +
            "  Address CHAR(25)," +
            "  City CHAR(12),"    +
            "  State CHAR(10),"    +
            "  Zip CHAR(10) )";

         // Execute the statement.
         stmt.execute(sql);

         // Add some rows to the new table.
         sql = "INSERT INTO Customer VALUES" +
               "('101', 'Three Fools Coffee', 'Kiosk 2, Grand Parade'," +
               " 'Cork', 'Cork', 'T12 X967')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Customer VALUES" +
               "('102', 'Cork Coffee Roasters', '2 French Church St'," +
               " 'Cork', 'Cork', 'T12 E94K')";
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Customer VALUES" +
               "('103', 'Soma Coffee Company', '23 Tuckey St'," +
               " 'Cork', 'Cork', 'T12 WD38')";
         stmt.executeUpdate(sql);

         // Close the connection.
         conn.close();
      }
      catch (Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
}
