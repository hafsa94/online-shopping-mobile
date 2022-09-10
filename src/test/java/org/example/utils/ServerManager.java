package org.example.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ServerManager {

    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer() throws IOException {
        utils.log().info("starting appium server");
        Properties props = new PropertyManager().getProps();
        AppiumDriverLocalService server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        // Used just to launch emulator from appium, --avd option deprecated
                        .withArgument(new ServerArgument(){
                            public String getArgument() {
                                return "--avd";
                            }
                        }, props.getProperty("androidDeviceName"))
                .withLogFile(new File(props.getProperty("platformName") + File.separator + "Server.log")));
        server.start();
        if(server == null || !server.isRunning()){
            utils.log().fatal("Appium server not started. ABORT!!!");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        this.server.set(server);
        utils.log().info("Appium server started");
    }
}
