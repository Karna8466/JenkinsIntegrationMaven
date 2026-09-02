package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                        "target/ExtentReports/ExtentReport.html"
                    );

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                "Tester",
                "Karna"
            );

            extent.setSystemInfo(
                "Browser",
                "Chrome"
            );

            extent.setSystemInfo(
                "Environment",
                "QA"
            );
        }

        return extent;
    }
}