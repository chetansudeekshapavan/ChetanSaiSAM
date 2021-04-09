package com.sudeeksha.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sudeeksha.Pageobjects.Loginpage;

public class LoginDDT extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void Login(String sai,String sudeeksha)
	{
		Loginpage lp=new Loginpage(driver);
		lp.setUsername(sai);
		lp.setPassword(sudeeksha);
		lp.btnclick();
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
	
		String path="/ChetanSaiSAM/src/test/java/com/sudeeksha/TestData/TestData.xlsx";
		
		int rownum=com.sudeeksha.TestUtilities.XLUtils.getRowCount(path, "sheet1");
		int colcount=com.sudeeksha.TestUtilities.XLUtils.getCellCount(path, "sheet1",1);
		
		String[][] logindata=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=com.sudeeksha.TestUtilities.XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		
		return logindata;
		
	}

}
