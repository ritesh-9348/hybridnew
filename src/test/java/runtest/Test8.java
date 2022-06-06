package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.NRI;
import Utilities.StartBrowser;

public class Test8 extends StartBrowser{
@Test
public void test() throws IOException {
	NRI n=new NRI();
	n.nri();
}
}
