import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Lcwuyeol {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lcwaikiki.com/");
        driver.manage().window().maximize();
        String expectedMessage = "Şifreniz harf ile rakam içermeli ve en az altı karakter olmalıdır.";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector(".user-wrapper .dropdown-label")).click();
        driver.findElement(By.cssSelector("form > .login-form__link")).click();
        driver.findElement(By.id("RegisterFormView_RegisterEmail")).sendKeys("yanlismail@mail.com");
        driver.findElement(By.id("RegisterFormView_Password")).sendKeys("1234");
        driver.findElement(By.id("RegisterPhoneNumberTR")).click();


        String message = driver.findElement(By.id("RegisterFormView_Password-error")).getText();
        if (expectedMessage.equalsIgnoreCase(message))
            System.out.println("True Message :"+message);
        else
            System.out.println("False Message:"+message);


         driver.quit();

    }

}
