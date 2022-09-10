package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.example.utils.DriverManager;
import org.example.utils.PropertyManager;
import org.example.utils.ServerManager;
import org.example.utils.TestUtils;
import org.testng.annotations.*;

import java.util.Properties;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.example.stepDefinitions",
        plugin = {"pretty", "html:target/cucumber/cucumber.html"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public static void initialize() throws Exception {
        TestUtils utils = new TestUtils();
        utils.log().info("Entering before class");
        Properties props = new PropertyManager().getProps();

        ThreadContext.put("ROUTINGKEY", props.getProperty("platformName"));

        new ServerManager().startServer();
        new DriverManager().initializeDriver();
    }

    @AfterMethod
    public static void quit(){
        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }
    }
}
