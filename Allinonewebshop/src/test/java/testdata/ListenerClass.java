package testdata;



import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import baseclass.baseclass;
import utilities.ExtentManager;


	public class ListenerClass extends ExtentManager implements ITestListener {

		@Override
		public void onTestStart(ITestResult result) {
			test = extent.createTest(result.getName());
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			if (result.getStatus() == ITestResult.SUCCESS) {
				   test.log(Status.PASS, "Pass Test case is: " + result.getName());
			}
		}

		@Override
		public void onTestFailure(ITestResult result) {
			if (result.getStatus() == ITestResult.FAILURE) {
				   test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				   test.log(Status.FAIL,
				     MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

				   String pathString = baseclass.screenShot(baseclass.driver, result.getName());
				   try {
				    test.addScreenCaptureFromPath(pathString);
				   } catch (IOException e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
				   }
				  }
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			if (result.getStatus() == ITestResult.SKIP) {
				   test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
				  }
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailedWithTimeout(result);
		}

		
		

	
	

}
