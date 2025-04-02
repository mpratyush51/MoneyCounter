package com.example.moneycounter


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneycounter.ui.theme.MoneyCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyCounterTheme {
                // A surface container using the 'background' color from the theme
            MyApp()
            }
        }
    }
}

@Preview
@Composable
fun MyApp(){
    var moneyCounter by remember {
        mutableStateOf(0)
    }
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.errorContainer) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "$$moneyCounter",
                    style = TextStyle(color = Color.Black,
                            fontSize = 50.sp),
                    fontWeight = FontWeight.ExtraBold
               )

                Spacer(modifier = Modifier.size(40.dp))
                CreateCircle(counter = moneyCounter){
                    inc -> moneyCounter =inc
                    // moneyCounter +=1
                    // moneycounter = it + 1
                }
            }
        }

}


@Composable
fun CreateCircle(counter : Int, updatemoneyCounter : (Int) ->(Unit)){


    Card(modifier = Modifier
        .size(150.dp)
        .padding(4.dp)
        .clickable {
                   updatemoneyCounter(counter + 1)
            //(counter) for mC += 1

//           moneyCounter += 1
//            Log.d("Count", "$moneyCounter  Times")
        },
        shape = CircleShape,
        colors = CardDefaults.cardColors(Color(0xFFADDFF7)),
        elevation = CardDefaults.cardElevation(8.dp),
        border = BorderStroke(0.5.dp, color = Color(0xFFB6B4B5)
        )
    ) {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            Text(text = "TAP",
                style = TextStyle(color = Color(0xFF2B66FC),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold)
            )

        }

    }
}

