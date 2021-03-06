package tests;

import models.User;
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
        logger.info("The test runs with email \"arielle@gmail.com\" and password \"Arielle1234$\"");

        User user = new User().withEmail("arielle@gmail.com").withPassword("Arielle1234$");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegFormUser(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());
    }
    @Test
    public void loginSuccessNewModel(){
        logger.info("The test runs with email \"arielle@gmail.com\" and password \"Arielle1234$\"");

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("arielle@gmail.com","Arielle1234$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());
    }
    @Test
    public void loginNegativeTestWrongPassport(){
        logger.info("The test runs with email \"arielle@gmail.com\" and password \"Arielle\"");

        User user = new User().withEmail("arielle@gmail.com").withPassword("Arielle");
        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegFormUser(user);
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLoginRegSuccess());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
            }
}
