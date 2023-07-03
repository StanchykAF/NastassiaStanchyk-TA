package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseTest;
import com.epam.tc.hw2.models.User;
import com.epam.tc.hw2.pages.IndexPage;
import java.util.List;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IndexPageTest extends BaseTest {

    @Test(description = "Test Index Page elements")
    public void testIndexPageElements() {
        IndexPage indexPage = new IndexPage(driver);
        // 1. Open test site by URL
        indexPage.openPage();
        SoftAssert softAssert = new SoftAssert();
        // 2. Assert Browser title
        softAssert.assertEquals(indexPage.getPageTitle(), "Home Page");
        // 3. Perform login
        indexPage.login(new User("Roman", "Jdi1234"));
        // 4. Assert Username is logging
        softAssert.assertEquals(indexPage.getUserName(), "ROMAN IOVLEV");
        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        List<String> indexPageHeaderMenusNames = indexPage.getHeaderMenusNames();
        softAssert.assertEquals(indexPageHeaderMenusNames.size(), 4);
        softAssert.assertEquals(indexPageHeaderMenusNames, headersMenusNames);
        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(indexPage.getNumberOfImages(), 4);
        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        List<String> actualTexts = indexPage.getTextsUnderIcons();
        softAssert.assertEquals(actualTexts.size(), 4);
        softAssert.assertEquals(actualTexts, textsUnderIcons);
        // 8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(indexPage.isFrameExist());
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        indexPage.switchToFrame();
        softAssert.assertTrue(indexPage.isFrameButtonExist());
        // 10. Switch to original window back
        indexPage.switchToOriginalWindow();
        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> actualSidebarMenu = indexPage.getLeftSidebarMenuNames();
        softAssert.assertEquals(actualSidebarMenu.size(), 5);
        softAssert.assertEquals(actualSidebarMenu, leftSideBarMenu);

        softAssert.assertAll();
    }
}
