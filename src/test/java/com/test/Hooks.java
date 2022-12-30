package com.test;

import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hooks {

    private static AppiumDriver<?> Driver;

    public static String local = "";
    public static String platform = "";

    @Rule
    public static TestName testName = new TestName();

    public static AppiumDriver<?> validardriver() {

        local = System.getProperty("local").toLowerCase();
        platform = System.getProperty("platform").toLowerCase();

        if (Driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();

                if (local.equals("devicefarm") && platform.equals("android")) {

                    // Set your access credentials
                    caps.setCapability("browserstack.user", "israelfaiolipint_OY3o57");
                    caps.setCapability("browserstack.key", "N5vYzsVZCrLx7xqNhmdi");

                    // Set URL of the application under test
                    caps.setCapability("app", "bs://93189d82be9f09e530b4c563f5b633fb2ebdae79");

                    // Specify device and os_version for testing
                    caps.setCapability("device", "Google Pixel 3");
                    caps.setCapability("os_version", "9.0");

                    // Set other BrowserStack capabilities
                    caps.setCapability("project", "First Java Project");
                    caps.setCapability("build", "browserstack-build-1");
                    caps.setCapability("name", "first_test");

                    // Initialise the remote Webdriver using BrowserStack remote URL
                    // and desired capabilities defined above
                    Driver = new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"), caps);

                    Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                } else if (local.equals("devicefarm") && platform.equals("ios")) {

                    // Set your access credentials
                    caps.setCapability("browserstack.user", "seuuser");
                    caps.setCapability("browserstack.key", "suakey");

                    // Set URL of the application under test
                    caps.setCapability("app", "bs://seu BS");

                    // Specify device and os_version for testing
                    caps.setCapability("device", "Google Pixel 3");
                    caps.setCapability("os_version", "9.0");

                    Driver = new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"), caps);
                    Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                } else if (local.equals("local") && platform.equals("android")) {
                    System.out.println("Pegou Local e Android");

                    caps.setCapability("app", new File("app/twp.apk"));
                    caps.setCapability("deviceName", "emulator-5524");
                    caps.setCapability("version", "9.0");
                    caps.setCapability("platformName", "Android");
                    Driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
                    Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                } else if (local.equals("local") && platform.equals("ios")) {
                    System.out.println("Pegou Local e IOS");

                    caps.setCapability("app", new File("app/twp.app"));
                    caps.setCapability("deviceName", "iPhone 13");
                    caps.setCapability("platformName", "iOS");
                    caps.setCapability("platformVersion", "15.0");
                    caps.setCapability("automationName", "XCUITest");
                    Driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), caps);
                    Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                } else {
                    System.out.println("Precisa passar o Platform e Local onde os testes vão executar");
                }
            } catch (IllegalArgumentException | MalformedURLException e) {
                System.out.println(" ==== Alguma coisa deu Errado nas capabilities ==== ");
                System.exit(1);
                return Driver;
            }
        }
        return Driver;
    }

    public static AppiumDriver<?> getDriver() {
        return Driver;
    }

    public static void quitDriver() {
        if (Driver != null) {
            Driver.quit();
        }
    }

    @Before
    public static void iniciarNovamente() {
        if (getDriver() != null) {
            getDriver().launchApp();
        } else {
            validardriver();
            esperarCarregamentoApp();
        }
    }

    @After
    public void fecharApp() {
        if (getDriver() != null) {
            getDriver().closeApp();
        }
    }

    public static void esperarCarregamentoApp() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
