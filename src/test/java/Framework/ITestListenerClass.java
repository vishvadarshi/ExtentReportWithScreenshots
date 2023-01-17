package Framework;

import Tests.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseTest implements ITestListener{

    public static ExtentReports report;
    public static ExtentTest test;

    @Override
    public void onStart(ITestContext contextStart) {

        System.out.println(this);
        report = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReportResults.html",true);
        //test = report.startTest("ExtentDemo");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String className = result.getTestClass().getName();
        test = report.startTest(className);
        test.log(LogStatus.PASS, "Test Case PASSED is ", result.getName());

    }
    @Override
    public void onTestFailure(ITestResult result) {

        String className = result.getTestClass().getName();
        test = report.startTest(className);
        test.log(LogStatus.FAIL, "Test Case Failed is ", result.getName());
        test.log(LogStatus.FAIL, "Test Case Failed is ", result.getThrowable());

        //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
        String screenshotPath = null;
        try {
            screenshotPath = ScreenShots.getScreenShot(driver, result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //To add path in the extent report using "logger.addScreenCapture" method.
        test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));

    }

    @Override
    public void onFinish(ITestContext contextFinish) {
        report.endTest(test);
        report.flush();

    }
}
