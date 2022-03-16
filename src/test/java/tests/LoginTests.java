package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccessNew(){

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("arielle@gmail.com","Arielle1234$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());
    }





}
