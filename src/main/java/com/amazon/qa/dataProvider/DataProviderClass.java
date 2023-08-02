package com.amazon.qa.dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.util.Utility;

public class DataProviderClass {
	
	@DataProvider(name="TestData1")
	public static String[] dataForTest() throws IOException
	{
		String []data= {"dell laptop","samsung mobile"};
		return data;
	}

}
