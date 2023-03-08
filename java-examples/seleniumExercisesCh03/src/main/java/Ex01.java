import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex01 {

    public static void main(String[] args) {

        //Instantiating chrome driver
        WebDriver driver = new ChromeDriver();

        //Opening web application
        driver.get("http://cn.bing.com/");

        //Locating the element
        String description = driver.findElement(By.name("description")).getAttribute("content");

        //Print the web page description
        System.out.println("The page is : " + description);

        //Close driver instance
        driver.quit();
    }

}