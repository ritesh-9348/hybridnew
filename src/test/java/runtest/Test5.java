package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.Menu;
import Utilities.StartBrowser;

public class Test5 extends StartBrowser{
@Test
public void test() throws IOException {
	Menu m=new Menu();
	m.menu();
}
}
