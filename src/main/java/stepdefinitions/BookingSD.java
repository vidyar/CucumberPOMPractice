package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchResultPage;

import java.util.ArrayList;

public class BookingSD {

    SearchResultPage searchResultPage = new SearchResultPage();

    @Given("I am on default locations search result screen" )
    public void i_am_on_default_locations_search_result_screen() {

    }

    @Then("I verify {string} is within the search result" )
    public void i_verify_is_within_the_search_result(String expectedHotel) {
        ArrayList<String> hotelList = searchResultPage.getHotelList();
        boolean result = false;
        for (String hotel : hotelList) {
            System.out.println(hotel);

            if (hotel.contains(expectedHotel)) {
                result = true;

            }
        }
        System.out.println("The searched hotel is " + expectedHotel);
       Assert.assertTrue("Given hotel not in search list", result);
    }

    @Then("I verify system displays all hotels within {string} amount" )
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String amountStr) {
    int  expectedAmount=Integer.parseInt(amountStr);
    ArrayList<Integer> priceList= searchResultPage.getPriceList();
    boolean result=true;
    ArrayList<Integer> greaterPriceList= new ArrayList<>();
    for (int price: priceList)
    {
        System.out.println(price);
        if (price>expectedAmount) {
            result = false;
            greaterPriceList.add(price);
        }
    }
    Assert.assertTrue("Some hotels are greater prices than expected" +expectedAmount + "\n Greater prices are:" +greaterPriceList,result);
    }

    @When("I select option for stars as {}" )
    public void iSelectOptionForStarsAsStars(String star) { //5 stars
        //star.substring(0,1);
       // star.split(" ")[0];
        searchResultPage.clickRating(""+star.charAt(0));
    }

    @Then("I verify system displays only {} hotels on search result" )
    public void iVerifySystemDisplaysOnlyStarsHotelsOnSearchResult(String star) {
        int expectedStarRating = Integer.parseInt(""+star.charAt(0));
    ArrayList<Integer>actualRatingList=searchResultPage.getRatingList();
    System.out.println(actualRatingList);
        ArrayList<Integer> expectedList = new ArrayList<>();
        int size = actualRatingList.size(); // 10
        for (int i=0;i<size;i++)
            expectedList.add(expectedStarRating);
        System.out.println("expected = " +expectedStarRating);
        System.out.println("actual = "+actualRatingList);
        Assert.assertEquals("some rating are not equal to:"+star,expectedList,actualRatingList);

    }
}