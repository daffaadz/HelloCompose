package com.example.hellocompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellocompose.ui.theme.HelloComposeTheme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.clip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloToastScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HelloToastScreen(){
    val ctx = LocalContext.current
    var count by rememberSaveable { mutableStateOf(0) }
     Column (
         modifier = Modifier
             .fillMaxSize()
             .padding(
                 start = 16.dp,
                 top = 55.dp,    // Margin top khusus
                 end = 16.dp,
                 bottom = 16.dp
             ),
         horizontalAlignment = Alignment.CenterHorizontally
     ){
         // Toast
         Button(
             onClick = { Toast.makeText(ctx, "Count $count",
                 Toast.LENGTH_SHORT).show()},
             modifier = Modifier.fillMaxWidth()
                 .padding(bottom = 20.dp),

             // mengganti warna botton toast
             colors = ButtonDefaults.buttonColors(
                 containerColor = colorResource(id = R.color.purple_500)
             )
         ) {
             Text(text = stringResource(id = R.string.toast))
         }

         // yellow box
         Box(
                 modifier = Modifier
                     .fillMaxWidth()
                     .weight(1f)
                     .clip(RoundedCornerShape(7.dp))
                     .background(color = colorResource(id = R.color.yellow)),
                contentAlignment = Alignment.Center
         ){
             Text(
                 text = count.toString(),
                 fontSize = 64.sp,
                 color = Color.Black,
                 textAlign = TextAlign.Center
             )

         }
         Row(
             modifier = Modifier.fillMaxWidth()
                 .padding(top = 20.dp)
         ) {
             // Button Kiri (Plus)
             Button(
                 onClick = { count++ },
                 modifier = Modifier.weight(1f) // Membagi lebar sama rata
             ) {
                 Text(text = stringResource(id = R.string.plus))
             }

             Spacer(modifier = Modifier.width(10.dp)) // Jarak antara button

             // Button Kanan (Minus)
             Button(
                 onClick = {
                     count --
                 },
                 modifier = Modifier.weight(1f) // Membagi lebar sama rata
             ) {
                 Text(text = stringResource(id = R.string.minus))
             }
         }

     }
}