package com.ansari.cardlistapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ansari.cardlistapp.presentation.screens.components.CardItemUI
import com.ansari.cardlistapp.presentation.viewmodel.CardListVewModel

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CardListingScreen(viewModel: CardListVewModel = hiltViewModel()) {

    // val viewModel: CardListVewModel = hiltViewModel()
    val result = viewModel.cardList.value

    if (result.isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        }
    }
    result.data?.cardItems?.let {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                "Credit Card List", fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            LazyColumn {
                items(it) { item ->
                    CardItemUI(item = item)
                }
            }
        }
    }

    if (result.error.isNotEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = result.error)
        }
    }
}