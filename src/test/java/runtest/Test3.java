package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.Agreement;
import Utilities.StartBrowser;

public class Test3 extends StartBrowser{

@Test
public void test3() throws IOException {
Agreement ag=new Agreement();
ag.rental();
}
}
