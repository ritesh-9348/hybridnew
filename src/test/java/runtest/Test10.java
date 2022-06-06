package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.Testiminols;
import Utilities.StartBrowser;

public class Test10 extends StartBrowser{
@Test
public void test() throws IOException {
	Testiminols t=new Testiminols();
	t.review();
}
}
