package ru.frigesty.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {

    public void setDate(String day, String month, String year){
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__month-select").$(byText(month)).click();

        String dayPickerLocator = format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(dayPickerLocator).click();
    }
}
