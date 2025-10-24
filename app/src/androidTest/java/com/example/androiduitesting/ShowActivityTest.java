package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ShowActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> scenario = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    // test 1 - see if activity correctly switched
    @Test
    public void testActivitySwitch() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        // click on Edmonton to switch to ShowActivity
        onView(withId(R.id.city_list)).perform(click());
        onView(withId(R.id.textView_cityName)).check(matches(isDisplayed()));
    }

    // test 2 - test if the city name is consistent
    @Test
    public void testCityNameConsistency() {
        String city = "Edmonton";
        // add a city name
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText(city));
        onView(withId(R.id.button_confirm)).perform(click());

        // click on Edmonton to switch to ShowActivity
        onView(withId(R.id.city_list)).perform(click());
        onView(withId(R.id.textView_cityName)).check(matches(withText(city)));
    }

    // test 3 - test the back button
    @Test
    public void testBackButton() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        // open showActivity
        onView(withId(R.id.city_list)).perform(click());

        // click the back button
        onView(withId(R.id.button_back)).perform(click());

        // confirm we are back in mainactivity (city list should be visible)
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }
}
