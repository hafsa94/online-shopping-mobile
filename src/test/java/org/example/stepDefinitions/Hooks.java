package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.example.utils.DriverManager;
import org.example.utils.VideoManager;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        new VideoManager().startRecording();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
            String timestamp = sdf.format(now);
            String fileName = String.format("%1s%2s%3s-%4s.png",
                    System.getProperty("user.dir"),
                    "/src/test/resources/screenshots/",
                    scenario.getName().replaceAll(" ", "-"),
                    timestamp);
            File scrFile = new DriverManager().getDriver().getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(fileName));
        }
        new VideoManager().stopRecording(scenario.getName());
    }
}
