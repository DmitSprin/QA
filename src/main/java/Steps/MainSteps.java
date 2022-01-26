package Steps;

import Pages.MainPage;

public class MainSteps extends MainPage {

    MainPage mainPage = new MainPage();

    public LoginSteps goToLoginPage() {
        mainPage.clickOnLoginButton();
        return new LoginSteps();
    }

    public ProductSteps searchProductInTopSearch(String product) {
        mainPage.sendProductNameInTopSearch(product);
        return new ProductSteps();
    }

    public ProductSteps moveToCatalog() {
        mainPage.moveMouseToCatalogBar();
        return new ProductSteps();
    }
}