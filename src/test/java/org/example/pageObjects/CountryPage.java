package org.example.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CountryPage extends BasePage{

    @AndroidFindBy(accessibility = "tCountryText_en_0")
    private MobileElement firstCountryLink;

    @AndroidFindBy(accessibility = "ttlContinue")
    private MobileElement countryContinueButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Skip and share later')]")
    private MobileElement skipShareLaterLink;

    public boolean isCountryOptionVisible() {
        return checkElementIsVisible(firstCountryLink);
    }

    public boolean selectFirstCountry() {
        return clickOnElement(firstCountryLink);
    }

    public boolean clickCountryContinueButton() {
        return clickOnElement(countryContinueButton);
    }

    public boolean clickSkipShareLaterLink() {
        return clickOnElement(skipShareLaterLink);
    }
}
