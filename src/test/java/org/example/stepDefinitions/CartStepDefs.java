package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.CartPage;
import org.example.utils.CacheUtils;
import org.testng.Assert;

import java.math.BigDecimal;
import java.util.Map;

public class CartStepDefs {

    private final CartPage cartPage;

    public CartStepDefs() {
        cartPage = new CartPage();
    }

    @When("user adds item to the cart of quantity {string}")
    public void userAddsItemToTheCartOfQuantity(String quantity) throws InterruptedException {
        CacheUtils.put("quantity", quantity);
        Assert.assertTrue(cartPage.openCartProductQuantityDropdown());
        Assert.assertTrue(cartPage.selectQuantityAtIndex(Integer.parseInt(quantity)-1));
        Thread.sleep(7000);
    }

    @Then("verify product details are same on the product detail and cart page")
    public void verifyProductDetailsAreSameOnTheProductDetailAndCartPage() {
        Map<String, String> cartProductDetail = cartPage.getCartProductTitlePrice();
        Assert.assertEquals(CacheUtils.getValue("productDetail"), cartProductDetail);
        // Calculate subtotal on the cart page
        String priceStr = cartProductDetail.get("price").replaceAll("\\D", "");
        String subtotalStr = cartPage.getCartProductSubtotal().replaceAll("\\D", "");
        BigDecimal price = new BigDecimal(priceStr);
        BigDecimal subtotal = new BigDecimal(subtotalStr);
        BigDecimal quantity = new BigDecimal(String.valueOf(CacheUtils.getValue("quantity")));
        Assert.assertEquals(subtotal, price.multiply(quantity));
    }

    @And("user clicks the remove item button")
    public void userClicksTheRemoveItemButton() {
        Assert.assertTrue(cartPage.clickRemoveItemButton());
    }

    @Then("user clicks the start shopping button")
    public void userClicksTheStartShoppingButton() {
        Assert.assertTrue(cartPage.clickStartShoppingButton());
    }
}
