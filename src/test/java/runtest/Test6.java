package runtest;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.PackerMover;
import Utilities.StartBrowser;

public class Test6 extends StartBrowser{
@Test
public void test() throws IOException {
	PackerMover my=new PackerMover();
	my.book();
}
}
