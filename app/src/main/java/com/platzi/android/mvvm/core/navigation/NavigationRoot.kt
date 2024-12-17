package com.platzi.android.mvvm.core.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.platzi.android.mvvm.app.presentation.onboarding.activity_level_screen.ActivityLevelScreen
import com.platzi.android.mvvm.app.presentation.onboarding.age_screen.AgeScreen
import com.platzi.android.mvvm.app.presentation.onboarding.gender_screen.GenderScreen
import com.platzi.android.mvvm.app.presentation.onboarding.goal_screen.GoalScreen
import com.platzi.android.mvvm.app.presentation.onboarding.height_screen.HeightScreen
import com.platzi.android.mvvm.app.presentation.onboarding.nutrient_screen.NutrientGoalScreen
import com.platzi.android.mvvm.app.presentation.onboarding.weight_screen.WeightScreen
import com.platzi.android.mvvm.app.presentation.onboarding.welcome.WelcomeScreen
import com.platzi.android.mvvm.app.presentation.tracker_overview.TrackerOverviewScreen

@Composable
fun NavigationRoot(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navHostController,
            startDestination = WelcomeScreenRoute
        ) {
            composable<WelcomeScreenRoute> {
                WelcomeScreen {
                    navHostController.navigate(GenderScreenRoute)
                }
            }
            composable<GenderScreenRoute> {
                GenderScreen {
                    navHostController.navigate(AgeScreenRoute)
                }
            }
            composable<AgeScreenRoute> {
                AgeScreen {
                    navHostController.navigate(HeightScreenRoute)
                }
            }
            composable<HeightScreenRoute> {
                HeightScreen {
                    navHostController.navigate(WeightScreenRoute)
                }
            }
            composable<WeightScreenRoute> {
                WeightScreen {
                    navHostController.navigate(ActivityLevelScreenRoute)
                }
            }
            composable<ActivityLevelScreenRoute> {
                ActivityLevelScreen {
                    navHostController.navigate(GoalScreenRoute)
                }
            }
            composable<GoalScreenRoute> {
                GoalScreen {
                    navHostController.navigate(NutrientGoalScreenRoute)
                }
            }
            composable<NutrientGoalScreenRoute> {
                NutrientGoalScreen {
                    navHostController.navigate(TrackerOverviewScreenRoute)
                }
            }
            composable<TrackerOverviewScreenRoute> {
                TrackerOverviewScreen()
            }
        }
    }
}