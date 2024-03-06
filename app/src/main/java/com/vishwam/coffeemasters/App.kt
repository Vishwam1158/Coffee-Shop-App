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
    Scaffold(
        topBar = {
            TopAppBar(title = { AppTitle() })

        },
        bottomBar = {
            Text(text = "Bottom bar")
        }
    ) {
        OffersPage()
    }
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
