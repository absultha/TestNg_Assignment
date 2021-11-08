package test;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pages.Loginpage;
public class LoginTest extends Baseclass{
 

@Parameters({"UserName","Password"})
        @Test
	     public void NegativeLogin(String UserNameVal,String PasswordVal) {
	     
test=report.startTest("Negative Login Test");
	Loginpage login= new Loginpage();
	
	 login.Login(UserNameVal,PasswordVal);
		login.ErrorCheck();
		report.endTest(test);
      
       
       }

@Parameters({"UserName","CorrectPassword"})
@Test
 public void PositiveLogin(String UserNameVal,String PasswordVal)
     {
test=report.startTest("positive Login Test");

	Loginpage login=new Loginpage();
     login.Login(UserNameVal,PasswordVal);
     
  report.endTest(test);

     }

}



