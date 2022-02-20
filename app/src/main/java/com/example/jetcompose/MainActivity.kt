package com.example.jetcompose

import android.os.Bundle
import android.provider.Telephony
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcompose.myText
import com.example.jetcompose.ui.theme.JetComposeTheme

private val messages: List<MyMessage> = listOf(
        MyMessage("Item 1"),
        MyMessage("Item 2"),
        MyMessage("Item 3"),
        MyMessage("Item 4"),
        MyMessage("Item 5"),
        MyMessage("Item 6"),
        MyMessage("Item 7"),
        MyMessage("Item 8"),
        MyMessage("Item 9"),
        MyMessage("Item 10"))

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeTheme() {
                myMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String)

@Composable
fun myMessages(messages: List<MyMessage>){
    LazyColumn {
        items(messages) {message ->
            myComponent(message)
        }
    }
}

@Composable
fun myComponent(message: MyMessage){
    Row() {
        Column(modifier = Modifier
            .padding(start = 26.dp)
            .padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                myImage()
                myTexts(message)
        }
        Column(modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                myImage()
                myTexts(message)
        }
    }
}

@Composable
fun myImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Imagen de prueba",
        modifier = Modifier
            .background(Color.Gray)
            .size(164.dp)
    )
}
@Composable
fun myTexts(message: MyMessage) {
    Column(modifier = Modifier.padding(start= 8.dp)) {
        message.title
    }
}

@Composable
fun myText(text: String) {
    Text(text)
}

@Preview(showSystemUi = true)
@Composable
fun previewComponent() {

    JetComposeTheme {
        val scrollState= rememberScrollState()

            Column(modifier = Modifier.verticalScroll(scrollState)) {
                for (i in 1..10)
                    myMessages(messages)

            }
    }



}