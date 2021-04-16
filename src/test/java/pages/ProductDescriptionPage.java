package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage extends BasePage{
    WebDriver driver;

    @FindBy(id = "work_title_en")
    WebElement titleBox;

    @FindBy(id = "work_tag_field_en")
    WebElement tagBox;

    @FindBy(id = "work_description_en")
    WebElement descriptionBox;

    @FindBy(id = "work_safe_for_work_true")
    WebElement notMatureContent;

    @FindBy(id = "rightsDeclaration")
    WebElement agreeBtn;

    @FindBy(id = "submit-work")
    WebElement submitBtn;


    public ProductDescriptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputDetails(String title,String tag, String description){
        sendKeysToElement(driver,titleBox,title);
        sendKeysToElement(driver,tagBox,tag);
        sendKeysToElement(driver,descriptionBox,description);
        clickElement(driver,notMatureContent);
        clickElement(driver,agreeBtn);
        clickElement(driver,submitBtn);
    }

}
