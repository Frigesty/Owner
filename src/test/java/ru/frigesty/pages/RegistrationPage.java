package ru.frigesty.pages;

import com.codeborne.selenide.SelenideElement;
import ru.frigesty.pages.components.CalendarComponent;
import ru.frigesty.pages.components.ResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();

    SelenideElement firstNameInput = $("#firstName"),
                     lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                     genderWrapper = $("#genterWrapper"),
                       numberInput = $("#userNumber"),
                         dateInput = $("#dateOfBirthInput"),
                     subjectsInput = $("#subjectsContainer input"),
                    hobbiesWrapper = $("#hobbiesWrapper"),
                     uploadPicture = $("#uploadPicture"),
                      addressInput = $("#currentAddress"),
                        stateInput = $("#state"),
                         cityInput = $("#city"),
                  stateCityWrapper = $("#stateCity-wrapper"),
                      submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage userEmailName(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage chooseGender(String value){
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage userMobileNumber(String value){
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage chooseBirthDate(String day, String month, String year){
        dateInput.click();
        calendarComponent.setDate(day,month,year);

        return this;
    }

    public RegistrationPage writeAndChooseSubject(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage chooseHobbies(String value){
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddressName(String value){
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage chooseStateAndCity(String state, String city){
        stateInput.click();
        stateCityWrapper.$(byText(state)).click();
        cityInput.click();
        stateCityWrapper.$(byText(city)).click();

        return this;
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public RegistrationPage verifyRegistrationResultsModalAppears(){
        resultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value){
        resultsModal.verifyResult(key, value);

        return this;
    }
}