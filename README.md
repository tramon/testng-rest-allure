Sample Stub with the following technologies:
    Java 1.8
    TestNG
    REST-Assured
    Allure
    Slf4j
    Lombok

To run all tests:
  gradle clean test --tests packages.scenarios*

Run tests with specific amount of parallel threads:
    -DthreadCount=2

Run specific tests suites:
    -DincludeGroups=smoke
    -DincludeGroups=regression
    -DincludeGroups=api

To run Specific test class:
  gradle -Dtest.single=AcceptanceTest

Reports:
Generate report:
    gradle allureReport
Start web application test Report:
    gradle allureServe