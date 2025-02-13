package testng;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ParallelTestNG {
    String name = "MuhammadAsharul M";

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("Set up Class");
        // scenarion login
        // set api
        // set url

    }

    @Test
    public void checkoutBarang(){
        // checkout barang

        // login
        // checkout
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }

    @Test
    public void scenarioTest1(){
        Assert.assertEquals(name, "MuhammadAsharul M");
        System.out.println("Test 1");
    }

    @BeforeGroups
    @Test
    public void scenarioTest2(){
        Assert.assertEquals(name, "MuhammadAsharul M");
        System.out.println("Test 4");
    }
    @Test
    public void scenarioTest3(){
        Assert.assertEquals(name, "MuhammadAsharul M");
        System.out.println("Test 3");
    }

    @AfterMethod
    public void afterUp(){
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }
}
