package com.swag_labs.TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListenerClass implements ITestListener {

    WebDriver driver; // Creating reference of WebDriver
    static ExtentHtmlReporter htmlReporter;
    static ExtentReports reports;
    static ExtentTest test;

    static {
        htmlReporter = new ExtentHtmlReporter("E:\\Selenium\\Real_Life_Project\\Report\\SauceDemoAutomationReport.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine", "windows");

        htmlReporter.config().setDocumentTitle("Html Report");
        htmlReporter.config().setReportName("Ontor");
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    @BeforeSuite
    public void startReport() {
        // No need to initialize here; it's done in the static block
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
        test = reports.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed: " + result.getName());


        try {
            // Create an instance of Robot class
            Robot robot = new Robot();

            // Get the default screen size
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            // Capture the screen image
            BufferedImage image = robot.createScreenCapture(screenRect);

            // Specify the directory path to save the screenshot
            String directoryPath = "E:\\Selenium\\Real_Life_Project\\ScreenShort";

            // Create the directory if it doesn't exist
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            int i=1;
            // Specify the file path within the directory to save the screenshot
            File file = new File(directory, result.getName()+"screenshot.png");
            i++;

            // Save the screenshot as a PNG file
            ImageIO.write(image, "png", file);

            System.out.println("Screenshot saved to: " + file.getAbsolutePath());
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIP", ExtentColor.RED));
            test.log(Status.FAIL, "Failure Details: " + result.getThrowable());
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIP", ExtentColor.YELLOW));
        test.skip(result.getThrowable());
    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    @AfterSuite
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
        reports.flush();
    }
}
