package com.example.android.sunshine.models;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.v7.widget.RecyclerView;

import com.example.android.sunshine.R;
import com.example.android.sunshine.data.SunshineTestData;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainModel {

    public MainModel clickOptions() {
        onView(withContentDescription(SunshineTestData.optionText))
                .perform(click());
        return this;
    }

    public MainModel verifyTitle() {
        onView(withText(R.string.app_name)).check(matches(isDisplayed()));
        return this;
    }

    public MainModel swipeScreen() {
        onView(isAssignableFrom(RecyclerView.class))
                .perform(ViewActions.swipeUp())
                .check(matches(isDisplayed()));
        return this;
    }

    public MainModel clickLastIndex() {
        onView(isAssignableFrom(RecyclerView.class))
                .perform(RecyclerViewActions.actionOnItemAtPosition(7, click()));
        return this;
    }

    public MainModel verifyRefreshButton() {

        onView(withId(R.id.action_refresh))
                .check(matches(isDisplayed()))
                .perform(click())
                .check(matches(isClickable()));
        return this;
    }

}


