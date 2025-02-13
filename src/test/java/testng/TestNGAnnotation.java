package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("🚀 [BeforeSuite] - Eksekusi sebelum seluruh suite test.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("✅ [AfterSuite] - Eksekusi setelah seluruh suite test selesai.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("📌 [BeforeTest] - Eksekusi sebelum test case dalam satu <test> di TestNG XML.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("📌 [AfterTest] - Eksekusi setelah test case dalam satu <test> di TestNG XML.");
    }

    @BeforeGroups("database")
    public void beforeGroups() {
        System.out.println("📂 [BeforeGroups] - Eksekusi sebelum group 'database' berjalan.");
    }

    @AfterGroups("database")
    public void afterGroups() {
        System.out.println("📂 [AfterGroups] - Eksekusi setelah group 'database' selesai.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("📘 [BeforeClass] - Eksekusi sebelum class ini dijalankan.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("📘 [AfterClass] - Eksekusi setelah class ini selesai.");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("🔄 [BeforeMethod] - Eksekusi sebelum setiap metode @Test.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("🔄 [AfterMethod] - Eksekusi setelah setiap metode @Test.");
    }


    
    @Test(groups = "database")
    public void testDatabaseConnection() {
        System.out.println("🛠 [Test] - Menjalankan pengujian koneksi database.");
    }

    @Test
    public void testLogin() {
        System.out.println("🔑 [Test] - Menjalankan pengujian login.");
    }

    @Test
    public void testRegistration() {
        System.out.println("📝 [Test] - Menjalankan pengujian registrasi.");
    }
}
