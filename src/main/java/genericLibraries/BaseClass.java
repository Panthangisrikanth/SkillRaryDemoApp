package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddNewCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUserPage;
import pomPages.AdminHomepage;
import pomPages.CategoryPage;
import pomPages.CourseListPage;
import pomPages.Loginpage;
import pomPages.usersPage;
import pomPages.welcomepage;

public class BaseClass {
	
//	@BeforeSuite
//	@BeforeTest
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	protected WebDriver driver;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	protected welcomepage  welcome;
	protected Loginpage login;
	protected AdminHomepage home;
	protected usersPage users;
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewUserPage addUser;
	protected AddNewCoursePage addCourse;
	protected AddNewCategoryPage addCategory;
	
	@BeforeClass
	public void classCongfig() {
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		jutil=new JavaUtility();
		webUtil =new WebDriverUtility();
		
		property.propertiesInitilization(IConstantPath.PROPERTIES_PATH);
		driver=webUtil.launchBrowser(property.readFromProperties("browser"));
		
		sdriver=driver;
		sjutil=jutil;
				
	}
	@BeforeMethod
	public void methodConfig() {
		excel.excelInitilization(IConstantPath.EXCEL_PATH);
		
		welcome=new welcomepage(driver);
		login =new Loginpage(driver);
		home=new AdminHomepageg(driver);
		users=new usersPage(driver);
		course=new CourseListPage(driver);
		category=new CategoryPage(driver);
		addUser=new AddNewUserPage(driver);
		addCourse=new AddNewCoursePage(driver);
		addCategory=new AddNewCategoryPage(driver);
		
		
		webUtil.navigateToApp(property.readFromProperties("url"));
		long time=Long.parseLong(property.readFromProperties("timeouts"));
		webUtil.waitTillElementFound(time);
		
		welcome.clickLoginButton();
		login.setEmail(property.readFromProperties("username"));
		login.setpassword(property.readFromProperties("password"));
		login.clickLogin();	
	}
	
	@AfterMethod
	public void mehtodTeardown() {
		excel.closeExcel();
		home.signOutofApp();
	}
	
	@AfterClass
	public void classTeardown() {
		webUtil.closeAllWindows();
		
	}
	
//	@AfterTest
//	@AfterSuite


}