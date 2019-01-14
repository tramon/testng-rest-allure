package packages.scenarios;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import packages.steps.LoginSteps;

import static packages.utils.TestGroups.REGRESSION;
import static packages.utils.TestGroups.SMOKE;

public class LoginTest extends TestBase {

    @Test(groups = {REGRESSION})
    @Description("Regression that fails")
    @Severity(SeverityLevel.MINOR)
    public void verifyLoginIsFineFailingRegression() {
        softly = new SoftAssertions();
        softly.assertThat(true).as("verify 1 ").isEqualTo(true);
        softly.assertThat(true).as("verify 2 ").isEqualTo(false);
        softly.assertThat(true).as("verify 3 ").isEqualTo(true);
        softly.assertAll();
    }

    @Test(groups = {SMOKE})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Smoke that passes")
    public void verifyLoginIsFineSmoke() {

        new LoginSteps().foo();
        softly = new SoftAssertions();
        softly.assertThat(true).isEqualTo(true);
        softly.assertThat(true).isEqualTo(true);
        softly.assertAll();
    }
}