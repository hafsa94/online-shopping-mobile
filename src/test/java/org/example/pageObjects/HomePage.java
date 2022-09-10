package org.example.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='iScaledImage2'])[1]")
    private MobileElement homeCategoryLink;

    @AndroidFindBy(accessibility = "lblnew-shopIcon")
    private MobileElement footerMenuCategoryButton;

    @AndroidFindBy(accessibility = "lblnew-basketIcon")
    private MobileElement footerMenuBasketButton;

    @AndroidFindBy(accessibility = "iScaledImageText Furniture1")
    private MobileElement furnitureCategoryButton;

    public boolean clickHomeCategoryLink() {
        return clickOnElement(homeCategoryLink);
    }

    public boolean clickFooterMenuCategoryButton() {
        return clickOnElement(footerMenuCategoryButton);
    }

    public boolean clickFooterMenuBasketButton() {
        return clickOnElement(footerMenuBasketButton);
    }

    public boolean clickFurnitureCategoryButton() {
        return clickOnElement(furnitureCategoryButton);
    }
}
