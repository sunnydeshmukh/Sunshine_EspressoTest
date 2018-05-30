package com.example.android.sunshine.models;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.widget.ImageButton;

import com.example.android.sunshine.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringContains.containsString;

public class DetailActivityModel {


    public DetailActivityModel clickNextDay() {
        String myTextFromResources = getResourceString(R.string.tomorrow);
        onView(allOf(allOf(withId(R.id.tv_weather_data), withText(containsString(myTextFromResources)))))
                .perform(click());
        return this;

    }

    public DetailActivityModel verifyDetailText() {
        onView(withText(R.string.title_activity_detail))
                .check(matches(isDisplayed()));
        return this;
    }

    public DetailActivityModel verifyNextdayText() {
        String myTextFromResources = getResourceString(R.string.tomorrow);
        onView(withText(containsString(myTextFromResources)))
                .check(matches(isDisplayed()));
        return this;
    }

    public DetailActivityModel clickBackButton() {
        onView(isAssignableFrom(ImageButton.class))
                .perform(click());
        return this;
    }


    private String getResourceString(int id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id);
    }
}

