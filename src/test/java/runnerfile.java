

import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberOverviewChartsReport;
import com.github.mkolisnyk.cucumber.runner.runtime.ExtendedRuntimeOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

@RunWith(Cucumber.class)
/*@ExtendedCucumberOptions
        (jsonReport = "target/cucumber.json",
                overviewReport = true,
                outputFolder = "target")*/

@CucumberOptions(
        features = "src/test/resources/features/",
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        //plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json" },
        monochrome = true,
        publish = true

)

public class  runnerfile
{

}