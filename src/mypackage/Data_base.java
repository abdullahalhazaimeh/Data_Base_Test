package mypackage;



import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Data_base extends parameters {
	
		@BeforeTest
		public void mySetup() throws SQLException {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "Abed");
			driver.get(website);
		}
		
		@Test(priority = 1, enabled = false)
	
		public void AddNewCustomer() throws SQLException {

			//String myQuery = "insert into customers (customerNumber,customerName, contactLastName, contactFirstName, phone, addressLine1, city, country) values ("+ randomIndex + ",'TechCorp', 'soso', 'w hay roro', '+1-555-1234567', '123 Tech Ave', 'Silicon Valley', 'USA')";

			stmt = con.createStatement();
			//stmt.execute(myQuery);
			int effectedRow = stmt.executeUpdate(QueryToAdd);
			//stmt.executeUpdate(myQuery);
			System.out.println(effectedRow);
			

		}

		@Test(priority = 2, enabled = false)

		public void UpdateCustomerInfo() throws SQLException {
			
			//String myQuery = "update customers set contactFirstName ='soso' where customerNumber =6186;";

			stmt = con.createStatement();
			int effectedRow = stmt.executeUpdate(QueryToUpdate);

			System.out.println(effectedRow);

		}

		@Test(priority = 3 , enabled = true)

		public void ReadTheUpdatedData() throws SQLException, InterruptedException, IOException {

			String myQuery  = "select * from customers where customerNumber = 893";

			stmt = con.createStatement();

			rs = stmt.executeQuery(myQuery);

			while (rs.next()) {

				String contactFirstNmae = rs.getString("contactFirstName");
				
				int contactId = Integer.parseInt(rs.getString("customerNumber"));
				String CityOfThecustomer = rs.getString("city");
				String  custuomer_nmber = rs.getString("customerNumber");

				System.out.println(contactFirstNmae + " " + contactId + " " + contactId + "   " + custuomer_nmber );
//				System.out.println(contactId);
//				System.out.println(CityOfThecustomer);
				
				driver.findElement(By.id("name")).sendKeys(contactFirstNmae);
				Thread.sleep(2000);
				driver.findElement(By.id("confirmbtn")).click();
				driver.switchTo().alert().accept();
				TakeScreenShot();
			}
			

		}

		@Test(priority = 4, enabled = false)

		public void DeleteCustomer() throws SQLException {

			//String myQuery = "delete from customers where customerNumber = 6186";

			stmt = con.createStatement();
			int effectedRow = stmt.executeUpdate(DeleteQuery);

			System.out.println(effectedRow);

		}
		
		


		
		
			
			
		
}
