package com.test.steps;

import com.test.screen.FormsScreen;
import com.test.screen.LoginScreen;
import com.test.screen.SplashScreen;
import com.test.screen.ToolbarScreen;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;

public class LoginSteps {
    LoginScreen loginScreen;
    SplashScreen splashScreen;
    ToolbarScreen toolbarScreen;
    FormsScreen formsScreen;

    public LoginSteps() {
        splashScreen = new SplashScreen();
        toolbarScreen = new ToolbarScreen();
        formsScreen = new FormsScreen();
        loginScreen = new LoginScreen();
    }

    @Dado("^que faça login utilizando: \"([^\"]*)\" Senha: \"([^\"]*)\"$")
    public void que_faça_login_utilizando_Senha(String email, String senha) {
        splashScreen.clicarBotaoComecar();
        toolbarScreen.clicarMenuApp();
        toolbarScreen.selecionarMenuForms();
        formsScreen.clicarBotaoLogin();
        loginScreen.logar(email, senha);

    }

    @Então("^estou logado no app$")
    public void estou_logado_no_app() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Isto é apenas uma demonstração ;)");
    }
}
