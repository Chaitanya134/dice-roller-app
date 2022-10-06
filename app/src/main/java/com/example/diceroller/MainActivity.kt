package com.example.diceroller

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceImageAndButton(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    );
}

@Composable
fun DiceImageAndButton(modifier: Modifier = Modifier) {

    var diceNumber by remember {
        mutableStateOf(1)
    }

    val diceImage = when (diceNumber) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.you_rolled),
            fontSize = 24.sp
        )

        Text(
            diceNumber.toString(),
            fontSize = 50.sp,
            color = colorResource(id = R.color.purple_500)
        )

        Image(
            painter = painterResource(id = diceImage),
            contentDescription = diceNumber.toString()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { diceNumber = (1..6).random() }) {
            Text(
                text = stringResource(id = R.string.roll),
                fontSize = 20.sp
            )
        }
    }
}