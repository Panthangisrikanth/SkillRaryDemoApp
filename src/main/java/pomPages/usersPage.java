package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//this is method class
public class usersPage {
//Declaration
	@FindBy(xpath = "//h1[normalize-space(text())='Users']")
	private WebElement pageHeader;
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement pluseNewButton;

	@FindBy(xpath = "u1[@class='pagination']/li[last()-1]/a")
	private WebElement usersListLastPage;

	@FindBy(xpath = "//table/tbody/tr[last()]/td[3]")
	private WebElement lastuser;

	// Initialization

	public usersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public String getpageHeader() {
		return pageHeader.getText();

	}

	public void clickNewButton() {
		pluseNewButton.click();
	}

	public void clickUserListLastPage() {
		usersListLastPage.click();

	}

	public String getLastuserName() {
		return lastuser.getText();
	}
}
