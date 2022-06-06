package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.FlatSale;
import Utilities.StartBrowser;

public class Test4 extends StartBrowser{
@Test
public void test() throws IOException {
	FlatSale fs=new FlatSale();
	fs.sale();
}
}
