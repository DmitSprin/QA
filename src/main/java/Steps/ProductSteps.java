package Steps;

import Browser.BrowserСhoice;
import Pages.ProductPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class ProductSteps extends ProductPage {

    private ProductPage productPage = new ProductPage();
    private Actions builder = new Actions(BrowserСhoice.getDriver());

    public void moveToSubMenu(String subProd) {
        List<WebElement> subCategories = productPage.getSubCategories();
        List<WebElement> subCategoriesSorted =
                subCategories.stream().filter(x -> x.getText().contains(subProd)).toList();
        subCategoriesSorted.stream().findFirst().get().click();
    }

    public void choiceСategory(String cat) {
        List<WebElement> allCategories = productPage.getCategories();
        allCategories.stream().filter(x -> x.getText().contains(cat))
                .forEach(x -> builder.moveToElement(x).build().perform());
    }

    public void choiceСategoryAndSubCategory(String cat, String sub) {
        List<WebElement> allCategories = productPage.getCategories();
        allCategories.stream().filter(x -> x.getText().contains(cat))
                .forEach(x -> builder.moveToElement(x).build().perform());
        moveToSubMenu(sub);
    }
}