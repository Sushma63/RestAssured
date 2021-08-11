

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.File;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        //plugin = { "pretty", "html:target/cucumber-reports.html" }
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" },
        monochrome = true

        /* plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
         monochrome = true*/
)
public class  runnerfile
{
    /*@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    }
     */
}