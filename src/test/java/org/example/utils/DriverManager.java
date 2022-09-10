package org.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    private static ThreadLocal<AppiumDriver<MobileElement>> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriver<MobileElement> getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver<MobileElement> driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver<MobileElement> driver = null;
        Properties props = new PropertyManager().getProps();

        if(driver == null){
            try{
                utils.log().info("Initializing Appium driver");
                switch(props.getProperty("platformName")){
                    case "Android":
                        driver = new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                        break;
                    case "iOS":
                        driver = new IOSDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
                utils.log().info("Driver is initialized");
                DriverManager.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Driver initialization failure. ABORT !!!!" + e.toString());
                throw e;
            }
        }

    }

}
