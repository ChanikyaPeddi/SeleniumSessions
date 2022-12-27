package testNgsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class TestNgAnnotations {
    @BeforeSuite
    public void DBConnection(){
        System.out.println("AS -DB Connection");
    }
    @BeforeTest
    public void createUser(){
        System.out.println("user creation");
    }
    @BeforeClass
    public void launchBrowser(){
        System.out.println("launch browser");
    }

    @BeforeMethod
    public void loginApp(){
        System.out.println("login");
    }
    @Test
    public void getPageTitleTest(){
        System.out.println("page title ");
    }
    @Test
    public void searchTest(){
        System.out.println("Search content");
    }

    @AfterMethod
    public void logout(){
        System.out.println("logout");
    }
    @AfterClass
    public void closeBrowser(){
        System.out.println("closed browser");
    }
    @AfterTest
    public void deleteUser(){
        System.out.println("user deleted");
    }
    @AfterSuite
    public void disconnectDB(){
        System.out.println("disconnected DB");
    }
}
