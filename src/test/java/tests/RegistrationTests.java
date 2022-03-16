package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{


    @Test
    public void positiveRegistration(){
        int index = (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println(index);

        app.getHelperUser().openLoginRegForm();
        app.getHelperUser().fillLoginRegForm("robi"+index+"@mail.ru", "Robi1234$");
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isLoginRegSuccess());


    }
}

