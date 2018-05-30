
package com.example.android.sunshine;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.sunshine.models.DetailActivityModel;
import com.example.android.sunshine.models.MainModel;
import com.example.android.sunshine.models.SettingsPageModel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)

public class SunshineTestCases {

    private MainModel mainPage = new MainModel();
    private SettingsPageModel settingPage = new SettingsPageModel();
    private DetailActivityModel detailPage = new DetailActivityModel();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void verifyTitle() {
        mainPage.verifyTitle();
    }

    @Test
    public void validateRefreshButton() {
        mainPage.verifyRefreshButton();
    }

    @Test
    public void verifyDetailNavigation() {
        detailPage.clickNextDay();
        detailPage.verifyDetailText();
        detailPage.verifyNextdayText();
    }

    @Test
    public void verifyBackButtonAndNavigate() {
        detailPage.clickNextDay();
        detailPage.verifyDetailText();
        detailPage.verifyNextdayText();
        detailPage.clickBackButton();
        mainPage.verifyTitle();
    }

    @Test
    public void verifyScrollAndNavigateToPage() {
        mainPage.swipeScreen();
        mainPage.clickLastIndex();
    }

    @Test
    public void navigateToSettings() {
        mainPage.clickOptions();
        settingPage.clickSetting();
        settingPage.verifyTempAndUnitText();
    }

    @Test
    public void verifyCancelButton() {
        mainPage.clickOptions();
        settingPage.clickSetting();
        settingPage.verifyTempAndUnitText();
        settingPage.clickTempUnits();
        settingPage.clickCancel();
        settingPage.verifyTempAndUnitText();

    }

    @Test
    public void verifyTemperatureUnits() {
        mainPage.clickOptions();
        settingPage.clickSetting();
        settingPage.verifyTempAndUnitText();
        settingPage.clickTempUnits();
        settingPage.clickImperialUnits();
        settingPage.verifyTempUnits();
        settingPage.verifyImperialUnits();
        settingPage.clickTempUnits();
        settingPage.clickMetricUnits();
        settingPage.verifyTempUnits();
        settingPage.verifyMetricUnits();
    }
}