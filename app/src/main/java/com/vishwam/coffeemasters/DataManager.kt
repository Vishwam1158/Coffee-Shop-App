package com.vishwam.coffeemasters

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//here we use superclass AndroidViewModel to convert DataManager to viewModel
class DataManager(app: Application): AndroidViewModel(app) {
    var menu: List<Category> by mutableStateOf(listOf())  // here we create a normal list if we create a mutable list then jetpack compose never realise if add or remove item so it must always immutable
    var cart: List<ItemInCart> by mutableStateOf(listOf())

    init{
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            menu = API.menuService.fetchMenu()
        }
    }
    fun cartAdd(product: Product){
        var found = false
        cart.forEach{
            if (product.id == it.product.id){
                it.quantity++
                found = true
            }
        }
        if (!found) {
            // if there is no item io cart so we have to add but problem is we cannot add it because it's a list not a immutable list.
            // so here we create a copy of current cart and current product that user want to add in cart and store it in the cart.
            cart = listOf(*cart.toTypedArray(), ItemInCart(product, 1))  // here we clone list by using a *cart.toTypedArray()
        }
    }

    fun cartClear() {
        cart = listOf()
    }

    fun cartRemove(product: Product){
        // same as adding list is mutable so we cannot remove it so we follow this.
        val aux = cart.toMutableList() //auxiliary list
        aux.removeAll { it.product.id == product.id }
        cart = listOf(*aux.toTypedArray())

    }
}