package packages.scenarios;


import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import static packages.utils.TestGroups.SMOKE;

public class AcceptanceTest extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Feature("AC-CM-100-01")
    @Story("Test ID - 215")
    @Link(name = "CM-100", type = "JIRA")
    @Link(type = "CONFLUENCE_AC_ANCHOR", value = "Forgot_password")
    @Test
    public void verifyTrue() {
        softly = new SoftAssertions();
        softly.assertThat(true).isEqualTo(true);
        softly.assertThat(true).isEqualTo(true);
        softly.assertAll();
    }

    @Test(groups = {SMOKE})
    public void verifyFailingTest() {
        softly = new SoftAssertions();
        softly.assertThat(true).as("verify 1 ").isEqualTo(true);
        softly.assertThat(true).as("verify 2 ").isEqualTo(true);
        softly.assertAll();
    }
}