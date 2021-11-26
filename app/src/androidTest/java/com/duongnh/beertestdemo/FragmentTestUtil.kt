package com.duongnh.beertestdemo

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.core.util.Preconditions
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.fragment.app.testing.withFragment
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.duongnh.beertestdemo.ui.beer.BeersFragment

object FragmentTestUtil {
    inline fun <reified T : Fragment> launchFragmentInHiltContainer(
        fragmentArgs: Bundle? = null,
        @StyleRes themeResId: Int = R.style.FragmentScenarioEmptyFragmentActivityTheme,
        crossinline action: Fragment.() -> Unit = {}
    ) {
        val startActivityIntent = Intent.makeMainActivity(
            ComponentName(
                ApplicationProvider.getApplicationContext(),
                HiltActivityForTest::class.java
            )
        )

        ActivityScenario.launch<HiltActivityForTest>(startActivityIntent).onActivity { activity ->

            // Create a TestNavHostController
            val navController = TestNavHostController(activity)

            // Create a graphical FragmentScenario for the TitleScreen
            val titleScenario = launchFragmentInContainer<T>()

            titleScenario.onFragment { fragment ->
                // Set the graph on the TestNavHostController
                navController.setGraph(R.navigation.nav_main)

                // Make the NavController available via the findNavController() APIs
                Navigation.setViewNavController(fragment.requireView(), navController)
            }
//            val fragment: Fragment = activity.supportFragmentManager.fragmentFactory.instantiate(
//                Preconditions.checkNotNull(T::class.java.classLoader),
//                T::class.java.name
//            )
//            fragment.arguments = fragmentArgs
//            activity.supportFragmentManager
//                .beginTransaction()
//                .add(android.R.id.content, fragment, "")
//                .commitNow()
//
//            fragment.action()
        }
    }
}