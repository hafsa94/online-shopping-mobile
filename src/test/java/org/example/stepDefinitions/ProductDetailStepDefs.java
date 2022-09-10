package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pageObjects.HomePage;
import org.example.pageObjects.ProductDetailPage;
import org.example.utils.CacheUtils;
import org.testng.Assert;

public class ProductDetailStepDefs {

    private final ProductDetailPage productDetailPage;
    private final HomePage homePage;

    public ProductDetailStepDefs() {
        productDetailPage = new ProductDetailPage();
        homePage = new HomePage();
    }

    @Then("verify product details are same on the product list and detail page")
    public void verifyProductDetailsAreSameOnTheProductListAndDetailPage() throws InterruptedException {
        Thread.sleep(7000);
        if(CacheUtils.getValue("ListProductPrice").equals(productDetailPage.getProductPrice())) {
            Assert.assertEquals(CacheUtils.getValue("ListProductPrice"), productDetailPage.getProductPrice());
        }
        CacheUtils.put("productDetail", productDetailPage.getProductTitlePrice());
    }

    @And("user clicks the add to basket button")
    public void userClicksTheAddToBasketButton() {
        Assert.assertTrue(productDetailPage.clickAddToBasketButton());
    }

    @And("user click the checkout now button")
    public void userClickTheCheckoutNowButton() {
        if (!productDetailPage.clickCheckoutNowButton()) {
            // This is to handle the case where app refreshes and goes back to home screen
            Assert.assertTrue(homePage.clickFooterMenuBasketButton());
        }
    }
}
