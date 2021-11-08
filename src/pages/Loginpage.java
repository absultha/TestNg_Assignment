package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Baseclass;

public class Loginpage {


WebDriver driver= Baseclass.driver;
ExtentTest test = Baseclass.test;

@FindBy(id="user-name")
WebElement username;

@FindBy(id="password")
WebElement password;

@FindBy(id="login-button")
WebElement login;

@FindBy(xpath="//button[@class='error-button']")
WebElement Error;
public Loginpage() {
PageFactory.initElements(driver, this);
}



public void Login(String UserName,String Password) {

	WebDriverWait wait=new  WebDriverWait(driver,30);
    //wait.until(ExpectedConditions.visibilityOf(LoginLink));

username.sendKeys(UserName);
test.log(LogStatus.PASS,"Enter username"+UserName,"Successfully enter the name");
password.sendKeys(Password);
test.log(LogStatus.PASS,"Enter password"+Password,"Successfully enter the password");
login.click();
test.log(LogStatus.PASS,"click login button","Successfully clicked the button");

}

public void ErrorCheck() {


String Actualmsg = Error.getText();
String Expmsg = "Epic sadface: Username and password do not match any user in this service";

//Assert.assertEquals(Actualmsg, Expmsg);
SoftAssert soft = new SoftAssert();
soft.assertEquals(Actualmsg, Expmsg);
//soft.assertAll();
}

}