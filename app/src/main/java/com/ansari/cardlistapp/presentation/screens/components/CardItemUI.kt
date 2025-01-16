package com.ansari.cardlistapp.presentation.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ansari.cardlistapp.data.model.CardItem

@Composable
fun CardItemUI(item: CardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Text("Card Type: ${item.type}", fontSize = 14.sp, fontWeight = FontWeight.W500, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))

            Text("Card Number: ${item.number}", fontSize = 14.sp, fontWeight = FontWeight.W500, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))

            Text("Card Exp.: ${item.expiration}", fontSize = 14.sp, fontWeight = FontWeight.W500, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))

            Text("Owner Name: ${item.owner}", fontSize = 14.sp, fontWeight = FontWeight.W500, color = Color.Black)
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}