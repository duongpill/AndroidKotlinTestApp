package com.duongnh.newtechnology2021demo.ui.beer

import androidx.lifecycle.ViewModelStore
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import androidx.test.rule.UiThreadTestRule
import com.duongnh.newtechnology2021demo.R
import com.duongnh.newtechnology2021demo.di.AppModule
import com.duongnh.newtechnology2021demo.ui.beer.adapter.BeerViewHolder
import com.duongnh.newtechnology2021demo.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@MediumTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
@UninstallModules(AppModule::class) // use to remove the bindings defined via the AppModule
class BeersFragmentTest {

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @get:Rule
    var uiThreadTestRule: UiThreadTestRule = UiThreadTestRule()

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
    }

    @Test
    fun whenDisplayed_newsListFromRepoIsDisplayed() {
        //region setup Nav and fragment
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.setViewModelStore(ViewModelStore())
        uiThreadTestRule.runOnUiThread {
            navController.setGraph(R.navigation.nav_main)
        }
        launchFragmentInHiltContainer<BeersFragment>(navHostController = navController)
        //endregion
        scrollAtAndCheckTestVisible(0, "Buzz")
        scrollAtAndCheckTestVisible(1, "Trashy Blonde")
    }

    fun scrollAtAndCheckTestVisible(position: Int, text: String) {
        onView(withId(R.id.recycleViewBeer)).perform(
            RecyclerViewActions.scrollToPosition<BeerViewHolder>(
                position
            )
        )
        onView(withText(text)).check(matches(isDisplayed()))
    }

}