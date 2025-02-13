package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    private static int attempt = 0;

    @Test(retryAnalyzer = RetryTest.class)
    public void testRetryMechanism() {
        attempt++;
        System.out.println("🛠 Running testRetryMechanism - Attempt #" + attempt);
        
        // Simulasi kegagalan pada dua percobaan pertama
        if (attempt < 4) {
            Assert.fail("❌ Test gagal, akan di-retry...");
        }

        System.out.println("✅ Test berhasil pada attempt #" + attempt);
    }
}
