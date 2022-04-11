package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{


    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().login(new User().withEmail("arielle@gmail.com").withPassword("Arielle1234$"));
        }
    }

    @Test
    public void addNewContactSuccess(){
        logger.info("New contact data: \"John\"+index, \"Dow\", \"1234567\"+index, \"john\"+index+\"@mail.com\", \"Rehovot\", \"The best friend\"");
        int index = (int) (System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("John"+index)
                .lastName("Dow")
                .phone("1234567"+index)
                .email("john"+index+"@mail.com")
                .address("Rehovot")
                .description("The best friend").build();

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();
        logger.info("See screenshot in screenshot folder");

        Assert.assertTrue(app.contact().isContactByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactByPhone(contact.getPhone()));
    }

}