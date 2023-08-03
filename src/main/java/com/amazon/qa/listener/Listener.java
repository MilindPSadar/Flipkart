package com.amazon.qa.listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.amazon.qa.util.Utility;


public class Listener extends Utility implements ITestListener {
	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		String fileName=result.getName();
		try {
			takeScreenshot(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("TC "+result.getName()+" is passed", true);


	}
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		Reporter.log("TC "+result.getName()+" is failed please try again", true);
		String fileName=result.getName();
		try {
			takeScreenshot(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
@Override
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	ITestListener.super.onTestSkipped(result);
	Reporter.log("TC "+result.getName()+" is skipped", true);

}
}