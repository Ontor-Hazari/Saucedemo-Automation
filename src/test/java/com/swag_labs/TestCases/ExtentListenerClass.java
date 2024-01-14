package com.swag_labs.TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExtentListenerClass implements ITestListener {



    WebDriver driver; // Creating reference of WebDriver
    ExtentSparkReporter htmlReporer;
    ExtentReports reports;
    ExtentTest test;


    @BeforeTest
    public void startReport()
    {
        htmlReporer = new ExtentSparkReporter("E:\\Selenium\\Sauce_Demo\\Html_Report\\Test_Cases_For_A_Login_Page_Report.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporer);

        reports.setSystemInfo("Machine","windwos");


        htmlReporer.config().setDocumentTitle("Html Report");
        htmlReporer.config().setReportName("Ontor");
        htmlReporer.config().setTheme(Theme.STANDARD);


    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
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
            String directoryPath = "E:\\Selenium\\Real_Life_Project\\ScreenShots";

            // Create the directory if it doesn't exist
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            int i=1;
            // Specify the file path within the directory to save the screenshot
            File file = new File(directory, i+"screenshot.png");
            i++;

            // Save the screenshot as a PNG file
            ImageIO.write(image, "png", file);

            System.out.println("Screenshot saved to: " + file.getAbsolutePath());
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
    }



}
