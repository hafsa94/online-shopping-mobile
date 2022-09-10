package org.example.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FurnitureListsPage extends BasePage {

    @AndroidFindBy(xpath = "(//*[@content-desc='txtCurency'])[1]")
    private MobileElement firstFurnitureProductPrice;

    @AndroidFindBy(xpath = "(//*[@content-desc='txtPrice'])[1]")
    private MobileElement firstFurnitureProductCurrency;

    @AndroidFindBy(xpath = "(//*[@content-desc='imgundefined'])[1]")
    private MobileElement firstFurnitureProductLink;

    public boolean openFirstFurnitureProduct() {
        return clickOnElement(firstFurnitureProductLink);
    }

    public String getFirstFurnitureProductPrice() {
        return getTextOfElement(firstFurnitureProductCurrency) + getTextOfElement(firstFurnitureProductPrice);
    }
}
