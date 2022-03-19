package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().signOut();
            }
        }

    @Test
    public void loginSuccessNew(){

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("arielle@gmail.com","Arielle1234$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());
    }
}
