package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountregistrationTest extends BaseClass
{
	
	
	
	@Test(groups= {"regression", "master"})
	public void verify_account_registration()
	{
		
		logger.info("*****   starting TC_001_AccountregistrationTest  ****");
		
		logger.debug("application logs..........");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on My account link");
		
		hp.clickRegister();
		logger.info("clicked on register link");
		
		
		logger.info("Entering customer details");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("clicked on continue");
		
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("validating expected message");
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("test passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("test failed");
			Assert.fail(); 
		}
		
		
		
		}
		catch(Exception e)
		{
			
			logger.error("test failed");
			logger.debug("debug logs");
			Assert.fail();
		}
		
		logger.debug("application logs end..........");
	    logger.info("***** finished  TC_001_AccountregistrationTest  **** ");
	
	}	
	
	
	
	
		
	}
	
	
	
	
	
	
