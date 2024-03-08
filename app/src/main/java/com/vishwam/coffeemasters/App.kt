package com.vishwam.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.vishwam.coffeemasters.pages.InfoPage
import com.vishwam.coffeemasters.pages.MenuPage
import com.vishwam.coffeemasters.pages.OffersPage
import com.vishwam.coffeemasters.pages.OrderPage
import com.vishwam.coffeemasters.ui.theme.Primary


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
            Column {
                TopAppBar(title = {
                    Box(
                        modifier = Modifier
                            .background(Primary)
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Coffee logo")
                    }
                })
            }

        },
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = { route ->
                    selectedRoute.value = route
                })
        }

    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            when(selectedRoute.value) {
                Routes.MenuPage.route -> MenuPage()
                Routes.OffersPage.route -> OffersPage()
                Routes.OrderPage.route -> OrderPage()
                Routes.InfoPage.route -> InfoPage()
            }
        }

    }
}

