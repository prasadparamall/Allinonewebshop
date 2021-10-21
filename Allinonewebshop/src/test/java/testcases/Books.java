package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseclass.baseclass;

public class Books extends baseclass {
	
	@Test
	public void SelectBooksAddtocart() throws InterruptedException {
		
		driver.findElement(By.xpath(pro.getProperty("books2"))).click();
		log.info("Click on books.....");
		
		driver.findElement(By.xpath(pro.getProperty("ciaddtocart"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(pro.getProperty("fictionaddtocart"))).click();
		Thread.sleep(2000);
		log.info("AddToCart Books....");
	}

}

class GoToCart extends baseclass {
	
	@Test(priority = 1)
	public void MoveToShippingCartAndClick() throws InterruptedException {
		
		WebElement txtUsername = driver.findElement(By.xpath(pro.getProperty("movetoshippingcartlink")));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(txtUsername).build();
		seriesOfActions.perform() ;
		Thread.sleep(2000);
		log.info("Move to the shippingcart.....");
		
		driver.findElement(By.xpath(pro.getProperty("gotocartbtn"))).click();
		log.info("Click on gotocart button.....");
	}
}

class CheckoutBillingAddress extends baseclass {
	
	@Test(priority = 1)
	public void checkout() throws InterruptedException {
		 
		driver.findElement(By.xpath(pro.getProperty("checkbox"))).click();
		driver.findElement(By.xpath(pro.getProperty("checkout"))).click();
		Thread.sleep(2000);
		log.info("Click on Radio button and Checkout button....");
	}
	
	@Test(priority = 2)
	public void BillingAddressdropdown() {
		
		Select new1 = new Select(driver.findElement(By.xpath(pro.getProperty("dropdownclick"))));
		new1.selectByVisibleText(pro.getProperty("newaddress"));
		log.info("Select dropdown and Select NewAddress....1");

}	
}
class Checkout extends baseclass {
	
	@Test(priority = 1)
	public void BillingAddress() {
		
		Select new1 = new Select(driver.findElement(By.xpath(pro.getProperty("dropdownclick"))));
		new1.selectByVisibleText(pro.getProperty("newaddress"));
		log.info("Select dropdown and Select NewAddress....");

        }
	
		@Test(dataProvider = "LoginData1")
		public void excelR(String fname,String lname,String email,String city,String address1,String address2,String zipcode,String phoneno) throws InterruptedException {
			
			try {
				
			WebElement ftxt=driver.findElement(By.xpath(pro.getProperty("firstname")));
			ftxt.clear();
			ftxt.sendKeys(fname);
			
			
			WebElement ltxt=driver.findElement(By.xpath(pro.getProperty("lastname")));
			ltxt.clear();
			ltxt.sendKeys(lname);
			
			WebElement post=	driver.findElement(By.xpath(pro.getProperty("emailbildingadd")));
			post.clear();
			post.sendKeys(email);
			
			Select Country = new Select(driver.findElement(By.xpath(pro.getProperty("countrydrop"))));
			Country.selectByVisibleText(pro.getProperty("ind"));
			
			
			WebElement city1 = driver.findElement(By.xpath(pro.getProperty("city")));
			city1.sendKeys(city);
			WebElement add1 = driver.findElement(By.xpath(pro.getProperty("address1")));
			add1.sendKeys(address1);
			WebElement add2 = driver.findElement(By.xpath(pro.getProperty("address2")));
			add2.sendKeys(address2);
			WebElement	zip = driver.findElement(By.xpath(pro.getProperty("zipcode")));
			zip.sendKeys(zipcode);
			WebElement phone = driver.findElement(By.xpath(pro.getProperty("phonenumber")));
			phone.sendKeys(phoneno);
			
			driver.findElement(By.xpath(pro.getProperty("bacontinue"))).click();
			}catch(Exception e) {
				e.printStackTrace();
			}	
			log.info("Enter Excel data .....");
		}		
}

class ShippingAddress extends baseclass {

	    @Test(priority = 1)
        public void shippingAddress() {
		
		Select new1 = new Select(driver.findElement(By.xpath(pro.getProperty("drop1"))));
		new1.selectByVisibleText("prasad1 test1, door no:12345, andhrapradesh 123456, India");
		log.info("Selelct Billing Address as same as Shipping Address....");
        }
	    
        @Test(priority = 2)
    	public void shippingaddress() {
            driver.findElement(By.xpath(pro.getProperty("sacontinue"))).click();  
            
    	}
}

class ShippingMethod extends baseclass{
	
	@Test
	public void ShippingMethodNextDayAir() {
		
		driver.findElement(By.xpath(pro.getProperty("nextdayair"))).click();
		log.info("Select NextDayAir.............");
		driver.findElement(By.xpath(pro.getProperty("smcontine"))).click();
		
	}
}

class PaymentMethod extends baseclass{
	
	@Test
	public void paymentmethod() {
		
		driver.findElement(By.xpath(pro.getProperty("cod"))).click();
		log.info("select COD option............");
		driver.findElement(By.xpath(pro.getProperty("pmcontinue"))).click();	
		
	}
}

class PaymentInfo extends baseclass {
	@Test
	public void paymentinfo() {
		
		driver.findElement(By.xpath(pro.getProperty("picontinue"))).click();	
		log.info("Show Payment infomation........");
		
		
	}
}

class ConfrmOrder extends baseclass {
	@Test
	public void confirmorder() throws InterruptedException {
		
		driver.findElement(By.xpath(pro.getProperty("cocontinue"))).click();
		log.info("Confirm Order..........");
		Thread.sleep(2000);
	} 
}

class SuccessfullyProcessed extends baseclass {
	@Test
	public void successfullprocessed() {
		
	System.out.println(driver.findElement(By.xpath(pro.getProperty("orderno"))).getText());
	log.info("Get text for order number.......");
		
	System.out.println(driver.findElement(By.xpath(pro.getProperty("success"))).getText());
	log.info("Get text for successfully ............");
		
		driver.findElement(By.xpath(pro.getProperty("tycontinue"))).click();
		
		
	} 

}

