package org.example.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends BasePage {

    @AndroidFindBy(accessibility = "txtProductName")
    private MobileElement cartProductTitle;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='txtPrice'])[1]")
    private MobileElement cartProductPrice;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='txtValue'])[1]")
    private MobileElement cartProductSubtotal;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='viwPicker']/android.widget.Spinner")
    private MobileElement cartProductQuantityDropdown;

    @AndroidFindBy(id = "android:id/text1")
    private List<MobileElement> cartProductQuantityOption;

    @AndroidFindBy(accessibility = "ttlStartShopping")
    private MobileElement startShoppingButton;

    @AndroidFindBy(accessibility = "ttlRemoveButton")
    private MobileElement removeItemButton;

    public Map<String, String> getCartProductTitlePrice() {
        return new HashMap<String, String>() {
            {
                put("title", getTextOfElement(cartProductTitle));
                put("price", getTextOfElement(cartProductPrice));
            }
        };
    }

    public String getCartProductSubtotal() {
        return getTextOfElement(cartProductSubtotal);
    }

    public boolean openCartProductQuantityDropdown() {
        return clickOnElement(cartProductQuantityDropdown);
    }

    public boolean selectQuantityAtIndex(int index) {
        return clickOnElement(cartProductQuantityOption.get(index));
    }


    public boolean clickRemoveItemButton() {
        return clickOnElement(removeItemButton);
    }

    public boolean clickStartShoppingButton() {
        return clickOnElement(startShoppingButton);
    }
}
