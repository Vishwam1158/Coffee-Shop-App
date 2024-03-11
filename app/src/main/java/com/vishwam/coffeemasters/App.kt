package com.vishwam.coffeemasters

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.vishwam.coffeemasters.pages.InfoPage
import com.vishwam.coffeemasters.pages.MenuPage
import com.vishwam.coffeemasters.pages.OffersPage
import com.vishwam.coffeemasters.pages.OrderPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataManager: DataManager) {
    val selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }// for rendering the app when user is changing the current selection

    Scaffold(
        topBar = {
                TopAppBar(title = {
                    AppTitle()
                },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF43281C),
                )
                )
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = { route ->
                    selectedRoute.value = route
                })
        }

    ) {
        Column(modifier = Modifier.padding(it)) {
            when(selectedRoute.value) {
                Routes.MenuPage.route -> MenuPage(dataManager)
                Routes.OffersPage.route -> OffersPage()
                Routes.OrderPage.route -> OrderPage(dataManager)
                Routes.InfoPage.route -> InfoPage()
            }
        }
    }
}


@Preview
@Composable
private fun AppTitle() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee logo",)
    }
}
