package com.jmc.floraapp.view

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jmc.floraapp.R
import com.jmc.floraapp.ui.theme.colorPrimary

@Composable
fun Dashboard(navController: NavController) {
    val sectionState = remember { mutableStateOf(DashboardSection.Home) }
    val navItems = DashboardSection.values().toList()

    Scaffold(bottomBar = {
        BottomBar(
            items = navItems,
            currentSection = sectionState.value,
            onSectionSelected = { sectionState.value = it })
    }) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(modifier = modifier, targetState = sectionState.value) { section ->
            when (section) {
                DashboardSection.Home -> HomeScreen(navController = navController)
            }

        }

    }
}

@Composable
private fun BottomBar(
    items: List<DashboardSection>,
    currentSection: DashboardSection,
    onSectionSelected: (DashboardSection) -> Unit
) {

    BottomNavigation(
        modifier = Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = contentColorFor(
            backgroundColor = MaterialTheme.colors.background
        )
    ) {
        items.forEach { section ->
            val selected = section == currentSection
            val iconRes = if (selected) section.selectIcon else section.icon

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = "Bottom nav icons",
                        modifier = Modifier.size(24.dp)
                    )
                },
                selected = selected,
                unselectedContentColor = Color.Gray,
                selectedContentColor = colorPrimary,
                onClick = { onSectionSelected(section) },
                alwaysShowLabel = false
            )
        }

    }
}


private enum class DashboardSection(
    val icon: Int, val selectIcon: Int
) {
    Home(R.drawable.ic_home, R.drawable.ic_home),
    List(R.drawable.ic_location, R.drawable.ic_location),
    ShoppingCart(R.drawable.ic_cart, R.drawable.ic_cart),
    Profile(R.drawable.ic_profile, R.drawable.ic_profile)
}