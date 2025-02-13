package testng;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {
    
    String name = "MuhammadAsharul M";

    @BeforeClass
    public void setUpClass(){
        System.out.println("set up Class");
        // scenarion login
        // set api
        // set url

    }

    @Test
    public void checkoutBrang(){
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
    @Test
    public void scenarioTest2(){
        Assert.assertEquals(name, "MuhammadAsharul M");
        System.out.println("Test 2");
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
        System.out.println("End Class");
    }

}
