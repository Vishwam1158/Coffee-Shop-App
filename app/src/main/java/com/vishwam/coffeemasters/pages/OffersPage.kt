package com.vishwam.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishwam.coffeemasters.R
import com.vishwam.coffeemasters.ui.theme.Alternative2


@Preview(showBackground = true)
@Composable
fun OffersPage() {
    Column (
        Modifier.verticalScroll(rememberScrollState()) // by using this function it's enable scrolling
    ) {
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
    }

}

@Composable
fun Offer(title: String, description: String) {
    Spacer(modifier = Modifier.width(64.dp))
    // Box is similar to Div in the HTML, usually use to layer over the other
    Box ( // we put this background image in the box so it don't clash with title and description and stay remaining in the background.
    modifier = Modifier.padding(16.dp) // gives padding to all side (if you give 4 parameter it's star with left side)
    ){
    Image(painter = painterResource(R.drawable.background_pattern),
        contentDescription = "Background Pattern" , //This is like a alt in img tag in html
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth() // by using this it's align center second offer
    ) {
        Text(text = title,
//            style = MaterialTheme.typography.headlineMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
//                .padding(16.dp)
                .background(Alternative2)
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = description,// style = MaterialTheme.typography.h6,
            modifier = Modifier
                .background(Alternative2)
                .padding(16.dp)
        )
    }
    }
}

