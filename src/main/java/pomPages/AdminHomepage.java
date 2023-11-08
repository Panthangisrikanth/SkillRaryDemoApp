package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomepage {
//declaration
	@FindBy(xpath = "//span[text()='SkillRary Admin']")
	private WebElement adminIcon;

	@FindBy(xpath = "//span[text()='Users']")
	private WebElement usersTab;

	@FindBy(xpath = "//span[text()='Courses']")
	private WebElement coursesTab;

	@FindBy(xpath = "//a[text()='Courses List']")
	private WebElement coursesListLink;

	@FindBy(xpath = "//a[text()='category']")
	private WebElement categoryLink;

	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signoutLink;


	// intilaization
	public void AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getAdminIcon() {
		return adminIcon.getText();
	}

	public void clickUsersTab() {
		usersTab.click();
	}

	public void clickCoursesTab() {
		coursesTab.click();
	}

	public void clickCoursesListLink() {
		coursesListLink.click();

	}

	public void clickCategoryLink() {
		categoryLink.click();
	}

	public void signOutofApp() {
		adminIcon.click();
		signoutLink.click();
	}

}