package UiStore;

import org.openqa.selenium.By;

public class BuilderUi {
public static By click=By.id("builderHomeTile");
public static By city=By.xpath("//div[@id='newprojectpopup']/div/div/div/descendant::div[@id='newid3']/div[7]/a");
public static By name=By.id("username");
public static By email=By.id("useremail");
public static By phone=By.id("userphone");
public static By area=By.id("area");
public static By selectarea=By.xpath("//select[@id='area']/option[3]");
public static By budget=By.id("price");
public static By price=By.xpath("//select[@id='price']/option[5]");
public static By submit=By.id("usubmit");
}
