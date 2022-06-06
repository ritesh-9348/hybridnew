package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.PayRent;
import Utilities.StartBrowser;

public class Test2 extends StartBrowser{
@Test
public void test() throws IOException {
	PayRent p=new PayRent();
	p.rent();
}
}
