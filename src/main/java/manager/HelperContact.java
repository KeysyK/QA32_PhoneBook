package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
    type(By.cssSelector("[placeholder='Name']"),contact.getName());
    type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
    type(By.cssSelector("[placeholder='Phone']"),contact.getPhone());
    type(By.cssSelector("[placeholder='email']"), contact.getEmail());
    type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
    type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void saveContact() {
        click(By.cssSelector(".add_form__2rsm2 button"));
        pause(2000);
        int index = (int) (System.currentTimeMillis()/1000)%3600;
        takeScreenShot("C:/Users/keysy/Desktop/QA-32/QA32_PhoneBook/src/test/screenshots/screenshot"+index+".png");
    }
    public boolean isContactByName(String name){
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list){
            if(el.getText().equals(name))
                return true;
        }
        return false;
    }
    public boolean isContactByPhone(String phone){
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for(WebElement el:list){
            if(el.getText().equals(phone))
                return true;
        }
        return false;
    }
}
