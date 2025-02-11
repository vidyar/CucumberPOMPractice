package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.SharedSD.getDriver;

public class SearchResultPage extends Base {
    By hotelListElements=By.xpath("//div[@data-testid=\"title\"]");

   public ArrayList<String> getHotelList()
    {
      return getElementTextList(hotelListElements);
    }

    By rawPriceListElement= By.xpath("//span[@data-testid=\"price-and-discounted-price\"]");
  public ArrayList<Integer> getPriceList()
  {
   ArrayList<Integer> priceList= new ArrayList<>();

   ArrayList<String> rawPriceList= getElementTextList(rawPriceListElement);
   for (String rawPrice : rawPriceList)
   {
       String rawPriceWithoutR = rawPrice.substring(2); // Rs(symbol)2,0655 - second index onwards
       String priceStr= rawPriceWithoutR.replace(",", "");
       int price =Integer.parseInt(priceStr);
       priceList.add(price);

   }
return priceList;

    }

public void clickRating(String star)
{
    By rating=By.xpath("//div[@data-filters-group=\"class\"]//input[@name='class="+star+"']");
  //  clickOn(rating);
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript("arguments[0].click()",webAction(rating));


}
By ratingElement=By.xpath("//div[contains(@aria-label,'out of 5')]");
public ArrayList<Integer> getRatingList()
{
      List<WebElement> starElementList= getDriver().findElements(ratingElement);
     ArrayList<Integer> starList= new ArrayList<>();
      for(WebElement wb:starElementList)
      {
         String attributeValue= wb.getDomAttribute("aria-label");
         String ratingStr=attributeValue.charAt(0)+" ";
         int rating=Integer.parseInt(ratingStr);
         starList.add(rating);

     }
      return starList;
}

}
