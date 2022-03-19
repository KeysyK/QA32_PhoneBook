package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().signOut();
        }
    }

    @Test
    public void positiveRegistration(){
        int index = (int) (System.currentTimeMillis()/1000)%3600;

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("robi"+index+"@mail.ru", "Robi1234$");
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());
    }
}

