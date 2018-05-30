package com.example.android.sunshine.models;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.example.android.sunshine.R;
import com.example.android.sunshine.data.SunshineTestData;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.AllOf.allOf;

public class SettingsPageModel {

    public SettingsPageModel clickCancel() {
        onView(withText(SunshineTestData.cancel_Button))
                .perform(click());
        return this;
    }

    public SettingsPageModel clickSetting() {

        String myTextFromResources = getResourceString(R.string.action_settings);
        onView(allOf(allOf(withId(R.id.title), withText(containsString(myTextFromResources)))))
                .perform(click());
        return this;
    }

    public SettingsPageModel verifyTempAndUnitText() {
        onView((withText(R.string.pref_location_label)))
                .check(matches(isDisplayed()));
        onView((withText(R.string.pref_units_label)))
                .check(matches(isDisplayed()));
        return this;

    }

    public SettingsPageModel clickTempUnits() {
        onView((withText(R.string.pref_units_label)))
                .perform(click());
        return this;

    }

    public SettingsPageModel clickImperialUnits() {
        onView(withText(R.string.pref_units_label_imperial))
                .perform(click());
        return this;

    }

    public SettingsPageModel clickMetricUnits() {
        onView(withText(R.string.pref_units_label_metric))
                .perform(click());
        return this;
    }

    public SettingsPageModel verifyImperialUnits() {
        onView(withText(R.string.pref_units_label_imperial))
                .check(matches(isDisplayed()))
                .perform(click());
        return this;

    }

    public SettingsPageModel verifyMetricUnits() {
        onView(withText(R.string.pref_units_label_metric))
                .check(matches(isDisplayed()))
                .perform(click());
        return this;

    }

    public SettingsPageModel verifyTempUnits() {
        onView((withText(R.string.pref_units_label)));
        return this;
    }

    private String getResourceString(int id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id);
    }

}


