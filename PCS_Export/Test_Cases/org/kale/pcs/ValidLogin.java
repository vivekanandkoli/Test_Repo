package org.kale.pcs;

import org.kale.pcs.pages.LoginPage;
import org.kale.pcs.sdk.BaseClass;
import org.kale.pcs.testdataReaders.TestDataCollection;
import org.kale.pcs.testdataReaders.TestDataReader;
import org.kale.pcs.testdataReaders.TestDataReaderFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidLogin extends BaseClass
{

	String username;
	String password;
	String entity;
	
	@BeforeClass
	public void readData() 
	{
		TestDataReader tdr =
				TestDataReaderFactory.getInstance().open("test_data\\user-accounts.yml");
		TestDataCollection tdc = tdr.getCollection("login1");
		entity=tdc.getString("entity");
		username =tdc.getString("email");
		password = tdc.getString("password");
		
	}	
	
	@Test
	public void loginToRediff()
	{
		LoginPage lp = new LoginPage(driver);
		lp.login(entity,username, password);
	}
}
