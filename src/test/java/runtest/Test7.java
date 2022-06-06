package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.About;
import Utilities.StartBrowser;

public class Test7 extends StartBrowser{
@Test
public void test() throws IOException {
	About a=new About();
	a.about();
}
}
