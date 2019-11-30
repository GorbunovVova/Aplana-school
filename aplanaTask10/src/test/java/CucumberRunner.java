
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"ru.ozon.autotests"},
        plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "pretty"})
public class CucumberRunner {
}

