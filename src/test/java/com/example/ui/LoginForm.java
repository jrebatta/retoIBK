package com.example.ui;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginForm {
    public static final Target USERNAME_FIELD = Target.the("username field")
            .located(By.xpath("//*[@id=\"loginform\"]/input[1]"));
    public static final Target PASSWORD_FIELD = Target.the("password field")
            .located(By.xpath("//*[@id=\"loginform\"]/input[2]"));
    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.xpath("//*[@id=\"loginform\"]/button"));
}
