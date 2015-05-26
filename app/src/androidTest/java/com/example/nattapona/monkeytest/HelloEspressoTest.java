package com.example.nattapona.monkeytest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest

public class HelloEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activitiTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test public void
    convert_temperator_from_0_celsius_should_32_fahrenheit(){
        onView(withId(R.id.celTextField)).perform(typeText("0"));
        onView(withId(R.id.fahTextField)).check(matches(withText("32.0")));
    }
}
