package com.example.jetcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.jetcompose.navigation.AppScreens


@Composable
fun FirstScreen(NavController: NavController){
    Scaffold {
        BodyContent(NavController)
    }
}


@Composable
fun BodyContent(NavController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Navegación")
        Button(onClick = {NavController.navigate(route = AppScreens.SecondScreen.route)}) {
            Text(text = "Navega")
        }
    }
}
