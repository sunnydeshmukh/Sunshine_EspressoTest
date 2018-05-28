
package com.example.android.sunshine;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageButton;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;
//import static android.despresso_samples.recyclerview.TestUtils.withRecyclerView;

@RunWith(AndroidJUnit4.class)

public class SunshineTestCases {


    private String navigateDate = "Tomorrow";
    private String settings = "Settings";
    private String title = "Sunshine";
    private String detail = "Details";
    private String options = "More options";
    private String location = "Location";
    private String temp_Units = "Temperature Units";
    private String cancel_Button = "Cancel";
    private String metric_Units = "Metric";
    private String imperial_Units = "Imperial";


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void verifyTitle() {

        onView(withText(title)).check(matches(isDisplayed()));  // verify the title of the project

    }

    @Test
    public void validateRefreshButton() {

        onView(withId(R.id.action_refresh))
                .check(matches(isDisplayed()))
                .perform(click())
                .check(matches(isClickable()));        // Validate if refresh link is clickable
    }


    @Test
    public void verifyDetailNavigation() {

        // Navigating till Detail Page and Verifying

        onView(allOf(withId(R.id.tv_weather_data), withText(containsString(navigateDate))))  // Will Navigate to detail page of specific date
                .perform(click());
        onView(withText(detail))
                .check(matches(isDisplayed()));

        onView(withText(containsString(navigateDate)))
                .check(matches(isDisplayed()));               // Confirm if it is navigating to same page by verifying the same text

    }

    @Test
    public void verifyBackButtonAndNavigate() throws InterruptedException {


        verifyDetailNavigation();  // Method called for Navigating

        onView(ViewMatchers.isAssignableFrom(ImageButton.class)) // Click on back link and validating if user is able to navigate again
                .perform(click());
        onView(withText(title))
                .check(matches(isDisplayed()));


    }

    @Test
    public void verifyScrollAndNavigateToPage() throws InterruptedException {


        onView(ViewMatchers.isAssignableFrom(android.support.v7.widget.RecyclerView.class))
                .perform(ViewActions.swipeUp())
                .check(matches(isDisplayed()))

                .perform(RecyclerViewActions.actionOnItemAtPosition(7, click())); // RecylerViewActions to click on 7th position


    }

    @Test
    public void navigateToSettings() throws InterruptedException {


        onView(withContentDescription(options))
                .perform(click());
        onView(allOf(withId(R.id.title), withText(containsString(settings))))
                .perform(click());
        onView((withText(location)))
                .check(matches(isDisplayed()));
        onView((withText(temp_Units)))
                .check(matches(isDisplayed()));


    }

    @Test
    public void verifyCancelButton() throws InterruptedException {

        navigateToSettings();
        onView((withText(temp_Units)))
                .perform(click());
        onView(withText(cancel_Button)).perform(click());
        onView((withText(location)))
                .check(matches(isDisplayed()));
        onView((withText(temp_Units)))
                .check(matches(isDisplayed()));

    }

    @Test
    public void verifyTemperatureUnits() throws InterruptedException {

        navigateToSettings();          //Calling the above method to Navigate to Settings
        onView((withText(temp_Units)))
                .perform(click());
        onView(withText(imperial_Units))
                .perform(click());
        onView((withText(temp_Units)));

        onView(withText(imperial_Units)).check(matches(isDisplayed()));  // Validate if selected Unit is selected

        onView((withText(temp_Units)))
                .perform(click());
        onView(withText(metric_Units))
                .perform(click());
        onView((withText(temp_Units)));

        onView(withText(metric_Units)).check(matches(isDisplayed()));  // Validate if selected Unit is selected
    }
}


