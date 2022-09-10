package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import org.example.pageObjects.FurnitureListsPage;
import org.example.pageObjects.HomePage;
import org.example.utils.CacheUtils;
import org.testng.Assert;

public class FurnitureListsStepDefs {
    private final FurnitureListsPage listsPage;
    private final HomePage homePage;

    public FurnitureListsStepDefs() {
        listsPage = new FurnitureListsPage();
        homePage = new HomePage();
    }

    @Then("user saves the first product name and price of the list page")
    public void userSavesTheProductNamePriceDetailTheListPage() {
        if (listsPage.getFirstFurnitureProductPrice().isEmpty()) {
            // This is to handle the case where app refreshes and goes back to home screen
            Assert.assertTrue(homePage.clickFooterMenuCategoryButton());
            Assert.assertTrue(homePage.clickFurnitureCategoryButton());
        }
        CacheUtils.put("ListProductPrice", listsPage.getFirstFurnitureProductPrice());
    }

    @Then("user click the first product of the list page")
    public void userClicksTheFirstProductOfTheListPage() {
        if (! listsPage.openFirstFurnitureProduct()) {
            // This is to handle the case where app refreshes and goes back to home screen
            Assert.assertTrue(homePage.clickFooterMenuCategoryButton());
            Assert.assertTrue(homePage.clickFurnitureCategoryButton());
            Assert.assertTrue(listsPage.openFirstFurnitureProduct());
        }
    }
}

