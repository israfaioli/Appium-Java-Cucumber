package com.test.screen;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class ToolbarScreen extends BaseScreen {

    String texto;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    @iOSFindBy(accessibility = "???")
    private RemoteWebElement botaoMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FORMS\"]")
    @iOSFindBy(accessibility = "???")
    private RemoteWebElement botaoForms;

    public void clicarMenuApp() {
        botaoMenu.isDisplayed();
        botaoMenu.click();
    }

    public void selecionarMenuForms() {
        botaoForms.isDisplayed();
        botaoForms.click();

    }
}
