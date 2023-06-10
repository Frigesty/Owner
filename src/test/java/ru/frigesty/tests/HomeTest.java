package ru.frigesty.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.frigesty.pages.RegistrationPage;

import static io.qameta.allure.Allure.step;
import static ru.frigesty.tests.TestData.*;
import static ru.frigesty.utils.RandomUtils.*;

@Owner("Frigesty")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "Тестируемый сайт", url = "https://demoqa.com/automation-practice-form")
@DisplayName("Домашняя работа")
public class HomeTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Tag("simple")
    @Test
    @DisplayName("Проверка тестовой формы")
    void practiceFormTest() {

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
               userEmail = faker.internet().emailAddress(),
              userGender = getRandomItemFromArray(TestData.gender),
              userNumber = 89 + faker.phoneNumber().subscriberNumber(8),
              dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthOfBirth = getRandomItemFromArray(months),
             yearOfBirth = String.valueOf(getRandomInt(1901,2023)),
                 subject = getRandomItemFromArray(subjects),
                 hobbies = getRandomItemFromArray(hobbiess),
          currentAddress = faker.address().streetAddress(),
             randomState = getRandomItemFromArray(states),
              randomCity = getRandomCity(randomState);

        step("Открываем страницу", () -> {
            registrationPage.openPage();
        });
        step("Закрываем банер и футер", () -> {
            registrationPage.removeFooter();
        });
        step("Вводим имя и фамилию", () -> {
            registrationPage.setFirstName(firstName);
            registrationPage.setLastName(lastName);
        });
        step("Вводим email", () -> {
            registrationPage.userEmailName(userEmail);
        });
        step("Выбираем гендер", () -> {
            registrationPage.chooseGender(userGender);
        });
        step("Вводим номер телефона", () -> {
            registrationPage.userMobileNumber(userNumber);
        });
        step("Вводим дату рождения", () -> {
            registrationPage.chooseBirthDate(dayOfBirth, monthOfBirth, yearOfBirth);
        });
        step("Выбираем предметы", () -> {
            registrationPage.writeAndChooseSubject(subject);
        });
        step("Выбираем хобби", () -> {
            registrationPage.chooseHobbies(hobbies);
        });
        step("Загружаем картинку", () -> {
            registrationPage.uploadPicture("duck.jpg");
        });
        step("Вводим адрес", () -> {
            registrationPage.setAddressName(currentAddress);
        });
        step("Выбираем штат и город", () -> {
            registrationPage.chooseStateAndCity(randomState, randomCity);
        });
        step("Кликаем на кнопку Submit", () -> {
            registrationPage.clickSubmit();
        });
        step("Проверяем результат", () -> {
            registrationPage.verifyRegistrationResultsModalAppears()
                            .verifyResult("Student Name", firstName + " " + lastName)
                            .verifyResult("Student Email", userEmail)
                            .verifyResult("Gender", userGender)
                            .verifyResult("Mobile", userNumber)
                            .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                            .verifyResult("Subjects", subject)
                            .verifyResult("Hobbies", hobbies)
                            .verifyResult("Picture", "duck.jpg")
                            .verifyResult("Address", currentAddress)
                            .verifyResult("State and City", randomState + " " + randomCity);
        });
    }
}