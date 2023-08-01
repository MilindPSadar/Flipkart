package com.amazon.qa.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	
	@DataProvider(name="TestData1")
	public static String[][] dataForTest()
	{
		String [][]data= {{"UserName1","Pass1"},{"UserName2","Pass2"}};
		return data;
	}

}
