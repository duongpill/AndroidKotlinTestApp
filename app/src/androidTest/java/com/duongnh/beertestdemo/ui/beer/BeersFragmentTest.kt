package com.duongnh.beertestdemo.ui.beer

import android.content.ComponentName
import android.content.Intent
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import com.duongnh.beertestdemo.FragmentTestUtil
import com.duongnh.beertestdemo.HiltActivityForTest
import com.duongnh.beertestdemo.R
import com.duongnh.beertestdemo.di.AppModule
import com.duongnh.beertestdemo.ui.MainActivity
import com.duongnh.beertestdemo.ui.beer.adapter.BeerViewHolder
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class BeersFragmentTest{

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
    }

    @Test
    fun whenDisplayed_newsListFromRepoIsDisplayed(){
        val startActivityIntent = Intent.makeMainActivity(
            ComponentName(
                ApplicationProvider.getApplicationContext(),
                MainActivity::class.java
            )
        )

        ActivityScenario.launch<MainActivity>(startActivityIntent).onActivity { activity ->

        }
        // Create a TestNavHostController
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        val scenario = launchFragmentInContainer {
            BeersFragment().also { fragment ->
                // In addition to returning a new instance of our Fragment,
                // get a callback whenever the fragment’s view is created
                // or destroyed so that we can set the NavController
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        // The fragment’s view has just been created
                        navController.setGraph(R.navigation.nav_main)
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }
        scrollAtAndCheckTestVisible(0, "First Title")
        scrollAtAndCheckTestVisible(1, "Second Title")
        scrollAtAndCheckTestVisible(2, "Third Title")
    }

    fun scrollAtAndCheckTestVisible(position: Int, text: String) {
        onView(ViewMatchers.withId(R.id.recycleViewBeer))
            .perform(
                RecyclerViewActions
                .scrollToPosition<BeerViewHolder>(position))
        onView(withText(text)).check(matches(isDisplayed()))
    }

}