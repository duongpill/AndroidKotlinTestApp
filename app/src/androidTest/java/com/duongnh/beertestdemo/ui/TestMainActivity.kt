package com.duongnh.beertestdemo.ui

import android.content.Intent
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.rule.ActivityTestRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule

@HiltAndroidTest
class TestMainActivity {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var mainActivityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    private var mIdlingResource: IdlingResource? = null

    @Before
    fun setup(){
        hiltRule.inject()
        mainActivityTestRule.launchActivity(Intent())
    }

    @After
    fun unregisterIdlingResource(){
        if(mIdlingResource != null) IdlingRegistry.getInstance().unregister()
    }
}