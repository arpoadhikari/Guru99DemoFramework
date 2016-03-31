package com.guru99.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestNG_Listener implements ITestListener, IAnnotationTransformer{
	
	// ITestListener Methods ---
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		Log.info("[TestNG_Listener.java] Test "+arg0.getName()+" has FAILED");
		try {
			Utilities.setTestResult(arg0.getName(), "FAILED");
			Utilities.setTimeStamp(arg0.getName());
		} catch (Exception e) {
			Log.error("[TestNG_Listener.java] Failed to write test result, time in excel file");
			e.printStackTrace();
		}	
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		Log.info("[TestNG_Listener.java] Test "+arg0.getName()+" has SKIPPED as RUN_MODE is not equal to Y");
		try {
			Utilities.setTestResult(arg0.getName(), "SKIPPED");
			Utilities.setTimeStamp(arg0.getName());
		} catch (Exception e) {
			Log.error("[TestNG_Listener.java] Failed to write test result, time in excel file");
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		Log.info("[TestNG_Listener.java] Test "+arg0.getName()+" has PASSED");
		try {
			Utilities.setTestResult(arg0.getName(), "PASSED");
			Utilities.setTimeStamp(arg0.getName());
		} catch (Exception e) {
			Log.error("[TestNG_Listener.java] Failed to write test result, time in excel file");
			e.printStackTrace();
		}
	}
	// -------------------------
	
	// IAnnotationTransformer Methods ---
	@Override
	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {
		try {
			if (Utilities.getRunmode(arg3.getName()) == false) {
				arg0.setEnabled(false);
			}
		} catch (Exception e) {
			Log.error("[TestNG_Listener.java] Failed to get test RunMode from excel file");
			e.printStackTrace();
		}
	}
	// ----------------------------------
}
