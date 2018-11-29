package pageObjectsAP;

//import java.awt.Image;
//import java.awt.image.RenderedImage;
//import java.net.URL;
import java.util.List;

//import javax.imageio.ImageIO;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class RepositoryAP {
	
	public WebDriver driver;
	//JavascriptExecutor js= (JavascriptExecutor)driver;
	public RepositoryAP(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Categories objects
	//Journals
	@FindBy(linkText="Journals")
	public WebElement journals;
	
	//Bookmarks
	@FindBy(linkText="Bookmarks")
	public WebElement bookmarks;
	
	//Souvenirs
	@FindBy(linkText="Souvenirs")
	public WebElement souvenirs;
	
	//Stationery
	@FindBy(linkText="Stationery")
	public WebElement stationery;
	
	//Jewellery
	@FindBy(linkText="Jewellery")
	public WebElement jewellery;
	
	//Office
	@FindBy(linkText="Office")
	public WebElement office;
	
	//Décor
	@FindBy(linkText="Décor")
	public WebElement decor;
	
	//Stories
	@FindBy(linkText="Stories")
	public WebElement stories;
	
	//Diwali
	@FindBy(linkText="Diwali")
	public WebElement diwali;
	
	//New
	@FindBy(linkText="New")
	public WebElement newLink;
	
	/////////////////////////////////////////////////////////////
	//For Login of user
	@FindBy(linkText="LOGIN")
	public WebElement login;
	
	@FindBy(id="email")
	public WebElement eMail;
	
	@FindBy(id="pass")
	public WebElement passWord;
	
	@FindBy(id="send2")
	public WebElement loginButton;
	
	/////////////////////////////////////////////////////////////////
	//For Create account
	@FindBy(xpath="//a[contains(@title,'Create an Account')]")
	public WebElement createAccountButton;
	
	@FindBy(id="firstname")
	public WebElement firstName;
	
	@FindBy(id="lastname")
	public WebElement lastName;
	
	@FindBy(name="email")
	public WebElement fillEmail;
	
	@FindBy(name="password")
	public WebElement fillPassword;
	
	@FindBy(name="confirmation")
	public WebElement confirmPW;
	
	@FindBy(id="captcha_user_create")
	public WebElement captchFill;
	
	@FindBy(xpath="//div[2]/button")
	public WebElement registerUserButton;
	
	//div[2]/button
	
	//////////////////////////////////////////////////////////////////
	//For Search the page
	@FindBy(className="fa fa-search open_search_popup")
	public WebElement search;;
	
	///////////////////////////////
	//For Wishlist
	@FindBy(className="wishlist")
	public WebElement wishList;
	//Number of Products in wishlist
	@FindBy(className="wishlist_count")
	public WebElement wishListCount;
	
	////////////////////////////////
	//For Cart
	@FindBy(xpath="//a[@href=https://www.anandprakash.com/checkout/cart/]")
	public WebElement cart;
	//Number of products in cart
	@FindBy(className="count")
	public WebElement count;
	
	/////////////////////////////////////
	//Objects of Sub-category
	/////////////////////////////////////
	//Hardbound
	@FindBy(xpath="//a[@href='https://www.anandprakash.com/journals/hardbound.html']")
	public WebElement hardBound;
	
	//Softbound
	@FindBy(xpath="//a[@href='https://www.anandprakash.com/journals/softbound.html']")
	public WebElement softBound;
	
	//Lacquered
	@FindBy(xpath="//a[@href='https://www.anandprakash.com/bookmarks/lacquered-bookmark.html']")
	public WebElement lacquered;
	
	/////////////////////////////////////
	//For All Products
	@FindBys({@FindBy(tagName="ul") })
	public List<WebElement> allProducts;
	
	//For Product List
	/*
	@FindAll({@FindBy(xpath="//div[@class='category-products']/ul["+i+"]/li")})
	public List<WebElement> listProducts;
	*/
	public void moveMouse(){
		Actions action= new Actions(driver);
		//action.moveToElement(journals).perform();
		action.moveToElement(bookmarks).perform();
	}
	
	//page scroll down
	public void pageDown(){
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void pagedownCaptcha(){
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
	}
	public void listValues(){
		for(int i=1;i<=allProducts.size();i++){
			List<WebElement> listCategory= driver.findElements(By.xpath("//div[@class='category-products']/ul["+i+"]/li"));
			for(int j=1;j<=listCategory.size();j++){
				WebElement sku1= driver.findElement(By.xpath("//div[@class='category-products']/ul["+i+"]/li["+j+"]/script"));				
				String skuDetails= sku1.getAttribute("textContent");
				int getSku= skuDetails.indexOf("sku");
				int quotes= skuDetails.indexOf(",", getSku);
				System.out.println(skuDetails.substring(getSku-1, quotes));
				WebElement list=  driver.findElement(By.xpath("//div[@class='category-products']/ul["+i+"]/li["+j+"]/div[1]/a"));
				System.out.println("Product Title: "+list.getAttribute("title"));
				WebElement list2=  driver.findElement(By.xpath("//div[@class='category-products']/ul["+i+"]/li["+j+"]/div[2]/h2/a"));
				System.out.println("Product Link: "+list2.getAttribute("href"));
				WebElement list3= driver.findElement(By.xpath("//div[@class='category-products']/ul["+i+"]/li["+j+"]/div[2]/div/span"));
				System.out.println("Product Price: "+list3.getText());
				System.out.println("*************************************************");
					
			}
	
		}
	}
	/*public String captchaAuto(){
		String captchaUrl= driver.findElement(By.id("user-create")).getAttribute("src");
		URL url = new URL(captchaUrl);
		Image image = ImageIO.read(url);
		String s = new OCR().recognizeCharacters((RenderedImage) image);
		System.out.println("Text From Image : \n"+ s);
		System.out.println("Length of total text : \n"+ s.length());
		return s;
	}*/
	
}
