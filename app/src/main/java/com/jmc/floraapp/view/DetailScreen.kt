package com.jmc.floraapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.jmc.floraapp.R
import com.jmc.floraapp.component.PageIndicator
import com.jmc.floraapp.component.TopAppBarWithBack
import com.jmc.floraapp.navigation.Screen
import com.jmc.floraapp.ui.theme.bgwhitelight
import com.jmc.floraapp.ui.theme.colorPrimary
import com.jmc.floraapp.ui.theme.colorprimarywhite
import com.jmc.floraapp.ui.theme.white


@SuppressLint("StaticFieldLeak")
lateinit var navControllerDetail: NavController

@Composable
fun DetailScreen(navController: NavController) {
    navControllerDetail = navController
    ViewScreen()
}


@Preview(showBackground = true)
@Composable
fun ViewScreen() {

    val pageCount by remember { mutableStateOf(0) }

    Scaffold(topBar = {
        TopAppBarWithBack(onBackClick = {navControllerDetail.popBackStack()})
    }, backgroundColor = bgwhitelight, content = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            ConstraintLayout {
                val (imagesliderref, addtocartref) = createRefs()

                Box(modifier = Modifier
                    .height(280.dp)
                    .constrainAs(imagesliderref) {
                        top.linkTo(imagesliderref.top)
                        bottom.linkTo(imagesliderref.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                    HeaderImagesSlider(pageCount)

                }

                Surface(
                    color = colorPrimary,
                    shape = RoundedCornerShape(40.dp).copy(
                        bottomStart = ZeroCornerSize,
                        bottomEnd = ZeroCornerSize
                    ), modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 350.dp)
                        .constrainAs(addtocartref) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                    ) {
                        TitleAndSubtitleDetail()
                        Spacer(modifier = Modifier.padding(10.dp))
                        AddToCartPrice()
                        Spacer(modifier = Modifier.padding(10.dp))
                        Divider(color = colorprimarywhite, thickness = 1.dp)
                        Spacer(modifier = Modifier.padding(20.dp))
                        About()
                        Spacer(modifier = Modifier.padding(20.dp))
                        AddToCartButton()

                    }
                }

            }

        }

    }
    )


}

@Composable
fun AddToCartButton() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = { navControllerDetail.navigate(Screen.CheckoutScreen.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = white),
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(text = "Add to Cart", color = colorPrimary, fontWeight = FontWeight.Bold)
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = colorPrimary,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(20.dp, 20.dp)
            )
        }

    }
}

@Composable
fun About() {
    Column(modifier = Modifier.fillMaxWidth())
    {
        Text(text = "About", style = MaterialTheme.typography.h6, color = white)
        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = "Lorem ipsum is simply dummy text of the printing and \n" +
                    "typesetting industry. Loremk ipsum has been the industy's \n" +
                    "standard dummy text ever since the 1500s.",
            style = MaterialTheme.typography.caption, color = white
        )
    }
}

@Composable
fun AddToCartPrice() {

    val counter = remember { mutableStateOf(1) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "$567.00", color = white, fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Box(
            modifier = Modifier
                .width(110.dp)
                .wrapContentHeight()
                .clip(RoundedCornerShape(10.dp))
                .background(colorprimarywhite)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_minimize_24),
                        contentDescription = "",
                        modifier = Modifier.padding(bottom = 15.dp),
                        tint = white
                    )
                }

                Text(
                    text = "${counter.value}",
                    color = white,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                IconButton(onClick = { counter.value++ }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "", tint = white)
                }
            }
        }
    }
}

@Composable
fun TitleAndSubtitleDetail() {
    Text(text = "Jannien Flower Bouquet", style = MaterialTheme.typography.h6, color = white)
    Text(
        text = "includes jannein flower, lily leaves",
        style = MaterialTheme.typography.caption,
        color = white
    )
}


@Composable
fun HeaderImagesSlider(pageCount: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 10.dp)
    ) {
        Box(modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(id = R.drawable.ic_pink_rose_bouquet),
                contentDescription = "",
                modifier = Modifier
                    .size(250.dp)
                    .padding(top = 20.dp)
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))

    }

    val modifier = Modifier.fillMaxWidth().padding(top = 250.dp)
    PageIndicator(pageCount,modifier)

}



