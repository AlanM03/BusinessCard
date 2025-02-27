package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card(
                        name = "Patrick BATEMAN",
                        role = "Vice President",
                        location = "358 Exchange Place New York, N.Y. 10099 Fax 212 555 6390 Telex 10 4534",
                        number = "212-555-6342",
                        business = "Pierce & Pierce"
                    )
                }
            }
        }
    }
}


@Composable
fun Card(name: String, role: String, location: String, number: String, business: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bateman)
    Box( modifier = modifier.fillMaxSize() ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.3F,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = number,
                fontSize = 32.sp,
            )
            Text(
                text = business,
                fontSize = 22.sp,
            )
            Spacer(modifier = Modifier.height(300.dp))
            Text(
                text = name,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = role,
                color = Color.Black,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(300.dp))
            Text(
                text = location,
                color = Color.Black,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    BusinessCardTheme {
        Card(name = "Patrick BATEMAN", role = "Vice President", location = "358 Exchange Place New York, N.Y. 10099 Fax 212 555 6390 Telex 10 4534", number = "212-555-6342", business = "Pierce & Pierce")
    }
}