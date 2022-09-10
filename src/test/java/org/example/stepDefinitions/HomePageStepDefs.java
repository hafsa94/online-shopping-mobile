package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pageObjects.CountryPage;
import org.example.pageObjects.HomePage;
import org.testng.Assert;

public class HomePageStepDefs {

    private final HomePage homePage;
    private final CountryPage countryPage;

    public HomePageStepDefs() {
        homePage = new HomePage();
        countryPage = new CountryPage();
    }

    @Given("user goes to the home page")
    public void userGoesToTheHomePage() {
        if(countryPage.isCountryOptionVisible()) {
            Assert.assertTrue(countryPage.selectFirstCountry());
            Assert.assertTrue(countryPage.clickCountryContinueButton());
            Assert.assertTrue(countryPage.clickSkipShareLaterLink());
            Assert.assertTrue(homePage.clickHomeCategoryLink());
        }
    }

    @And("user clicks the category button")
    public void userClicksTheCategoryButton() {
        Assert.assertTrue(homePage.clickFooterMenuCategoryButton());
    }

    @When("user selects the furniture category option")
    public void userSelectsTheFurnitureCategoryOption() {
        Assert.assertTrue(homePage.clickFurnitureCategoryButton());
    }
}
