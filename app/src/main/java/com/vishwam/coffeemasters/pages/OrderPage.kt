package com.vishwam.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.vishwam.coffeemasters.DataManager
import com.vishwam.coffeemasters.ItemInCart
import com.vishwam.coffeemasters.Product
import com.vishwam.coffeemasters.ui.theme.Primary

@Composable
fun OrderPage(dataManager: DataManager) {
    LazyColumn() {
        if (dataManager.cart.count()==0) {
            item {
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(text = "You haven't Order anything yet",
                        style = MaterialTheme.typography.headlineMedium)
                }
            }
        }
        items(dataManager.cart) {
            CartItem(it = it, onDelete = {
                dataManager.cartRemove(it)
            })
        }
    }
}


@Composable
fun CartItem(it: ItemInCart, onDelete: (Product)->Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()

    ) {
        Text("${it.quantity}x")
        Text(it.product.name,
            modifier = Modifier.width(150.dp)
        )
        Text("$${(it.quantity*it.product.price).format(2)}",
            modifier = Modifier.width(50.dp)
        )
        Image(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            colorFilter = ColorFilter.tint(Primary),
            modifier = Modifier.clickable {
                onDelete(it.product)
            }
        )
    }
}
