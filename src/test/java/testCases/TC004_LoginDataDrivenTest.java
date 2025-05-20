/*
 * package testCases;
 * 
 * import org.testng.Assert; import org.testng.annotations.Test;
 * 
 * import pageObjects.LoginPage; import testBase.BaseClass; import
 * utilities.DataProviders;
 * 
 * public class TC004_LoginDataDrivenTest extends BaseClass {
 * 
 * 
 * @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven") //
 * getting data provider from different class public void verifyLogin(String
 * email, String password, String expectedResult) {
 * 
 * logger.info("******Starting TC004_LoginDataDrivenTest*****");
 * 
 * try{
 * 
 * LoginPage lp = new LoginPage(driver); lp.setEmail(email);
 *lp.setPassword(password); lp.clickLogin(); //lp.clickProfileElement();
 * //lp.clickLabel();
 * 
 * //boolean userIsLoggedIn = lp.isUserLoggedIn();
 * //Assert.assertEquals(userIsLoggedIn, true);
 * 
 * 
 * TC003_LogoutTest tc003 = new TC003_LogoutTest();
 * 
 * 
 * if(expectedResult.equalsIgnoreCase("Valid")) { if(userIsLoggedIn == true) {
 * 
 * tc003.logout(); Assert.assertTrue(true);
 * 
 * }else { Assert.assertTrue(false); } }
 * 
 * 
 * 
 * if(expectedResult.equalsIgnoreCase("Invalid")) { if(userIsLoggedIn == true) {
 * 
 * tc003.logout(); Assert.assertTrue(false);
 * 
 * }else {
 * 
 * Assert.assertTrue(true);
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * 
 * }catch(Exception e) { Assert.fail();
 * 
 * } logger.info("******Finished TC004_LoginDataDrivenTest********");
 * 
 * } }
 */