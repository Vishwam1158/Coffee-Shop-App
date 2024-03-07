package com.vishwam.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.vishwam.coffeemasters.ui.theme.CoffeeMastersTheme


//for applying our own theme on preview
@Preview
@Composable
fun App_Preview() {
    CoffeeMastersTheme {
        App()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun App() {
    val selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }// for rendering the app when user is changing the current selection

    Scaffold(
        topBar = {
            TopAppBar(title = { AppTitle() })

        },
        content = {
            when(selectedRoute.value) {
                Routes.MenuPage.route -> Text(text = "It's a Menu")
                Routes.OffersPage.route -> OffersPage()
                Routes.OrderPage.route -> Text(text = "It's a Order Page")
                Routes.InfoPage.route -> Text(text = "It's a Info page")
            }
        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = { // here it is route of the screen that user wants
                    selectedRoute.value = it
                }
            )
        }
    )
}


@Preview
@Composable
fun AppTitle() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Coffee logo")
    }

}
