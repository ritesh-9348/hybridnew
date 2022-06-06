package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.SignUp;
import Utilities.StartBrowser;

public class Test1 extends StartBrowser{

@Test
public void test() throws IOException {
	SignUp sign=new SignUp();
	sign.Login();
}
	
}
