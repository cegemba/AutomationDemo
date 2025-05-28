package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager  implements ITestListener{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	String reportName;
	
	public void onStart(ITestContext testContext) {
		
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new Date());
		reportName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter("./reports/" + reportName);
		sparkReporter.config().setDocumentTitle("KSL Automation Demo");
		sparkReporter.config().setReportName("Regression Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "KSL.com");
		extent.setSystemInfo("", "");
		extent.setSystemInfo("", "");
		extent.setSystemInfo("User Name", System.getProperty("user.key"));
		extent.setSystemInfo("Enviroment", "Live");
		
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups", includedGroups.toString());
			
		}
			
	
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+ "got successfully executed");
		
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+ "got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+ "got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"/reports/" + reportName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
		/*
		 * try {
		 * 
		 * URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\" +
		 * reportName);
		 * 
		 * //Create the email message ImageHtmlEmail email = new ImageHtmlEmail();
		 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
		 * email.setHostName("smtp.googlemail.com"); email.setSmtpPort(465);
		 * email.setAuthenticator(new
		 * DefaultAuthenticator("cegemba+ubphv@deseretdigital.com", "VjJWart233"));
		 * email.setSSLOnConnect(true);
		 * email.setFrom("cegemba+ubphv@deseretdigital.com");//Sender
		 * email.setSubject("Test Result"); email.setMsg("Please find attached report");
		 * email.addTo("cegemba+ubphv@deseretdigital.com"); //Receiver email.attach(url,
		 * "extent report", "please check report..."); email.send();
		 * 
		 * 
		 * }catch(Exception e) { e.printStackTrace();; }
		 */
		
	}
	
	
	
	
	
	

}
