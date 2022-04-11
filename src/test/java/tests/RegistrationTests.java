package tests;

import models.User;
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
        logger.info("The test runs with email \"robi\"+index+\"@mail.ru\" and password \"Robi1234$\"");

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("robi"+index+"@mail.ru", "Robi1234$");
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());
    }
    @Test
    public void positiveRegistrationModel(){
        int index = (int) (System.currentTimeMillis()/1000)%3600;
        logger.info("The test runs with email \"robi\"+index+\"@mail.ru\" and password \"Robi1234$\"");
        User user = new User().withEmail("robi"+index+"@mail.ru").withPassword("Robi1234$");

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegFormUser(user);
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());
    }
}

