package ru.netology;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryCard {
    @Test
    void shouldDeliveryCartTest() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] [placeholder='Город']").setValue("Ростов-на-Дону");
        $("[class='input__box'] [placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[class='input__box'] [placeholder='Дата встречи'] ").setValue("15092023");
        $("[data-test-id=name] [type=text]").setValue("Петров Петр");
        $("[class='input__control'][name='phone']").setValue("+79280000000");
        $("[data-test-id=agreement]").click();
        $("[role=button] .button__content").click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
    }
}