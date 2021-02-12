package io.github.eroshenkoam.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {
    private final static int ISSUE_NUMBER = 68;


    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий ${name}")
    public void searchForRepository(final String name) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(name);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий ${name}")
    public void goToRepository(final String name) {
        $(By.linkText(name)).click();
    }

    @Step("Переходим в раздел Issues")
    public void goToIssues() {
        $(withText("Issues")).click();
    }

    @Step("Проверяем наличие Issue с номером ${number}")
    public void shouldSeeIssueWithNumber(final int number) {
        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    }

}
