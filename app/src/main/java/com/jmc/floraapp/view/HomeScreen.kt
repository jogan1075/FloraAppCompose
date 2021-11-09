package com.jmc.floraapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.jmc.floraapp.R
import com.jmc.floraapp.component.PageIndicator
import com.jmc.floraapp.navigation.Screen
import com.jmc.floraapp.ui.theme.black
import com.jmc.floraapp.ui.theme.colorPrimary
import com.jmc.floraapp.ui.theme.ghost_white
import com.jmc.floraapp.ui.theme.white

@SuppressLint("StaticFieldLeak")
lateinit var navControllerLocal: NavController

@Composable
fun HomeScreen(navController: NavController) {
    navControllerLocal = navController
    viewHome()
}


@Preview(showBackground = true)
@Composable
fun viewHome() {

    var pageCount by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout {
            val (logoimageref, loginformref) = createRefs()

            Box(contentAlignment = Alignment.Center, modifier = Modifier
                .height(100.dp)
                .constrainAs(logoimageref) {
                    top.linkTo(loginformref.top)
                    bottom.linkTo(loginformref.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                HeaderHome()
            }

            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp)
                    .constrainAs(loginformref) {
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

                    SlidingBannerView()
                    Spacer(modifier = Modifier.padding(10.dp))
                    val modifier = Modifier.fillMaxWidth()
                    PageIndicator(pageCount, modifier)
                    Spacer(modifier = Modifier.padding(10.dp))
                    CategoryView()
                    Spacer(modifier = Modifier.padding(10.dp))
                    PopularItemSection(navControllerLocal)

                }
            }
        }
    }

}

@Composable
fun PopularItemSection(navControllerLocal: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Popular Items", style = MaterialTheme.typography.h6)
        TextButton(onClick = { navControllerLocal.navigate(Screen.ListScreen.route) }) {
            Text(text = "View All", color = colorPrimary)

        }
    }

    Spacer(modifier = Modifier.padding(10.dp))
    PopularItems(navControllerLocal)
}

@Composable
fun PopularItems(navControllerLocal: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(0.5f)
            .wrapContentHeight()
            .clip(
                RoundedCornerShape(16.dp)
            )
            .background(white)
            .clickable { navControllerLocal.navigate(Screen.DetailScreen.route) }) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.ic_red_rose_bouquet),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.wrapContentHeight()) {
                        Text(
                            text = "Angle",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )

                        Text(
                            text = "$500.000",
                            fontSize = 12.sp,
                            color = black
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(colorPrimary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = white,
                            modifier = Modifier.size(32.dp, 32.dp)
                        )
                    }
                }
            }

        }

        Spacer(modifier = Modifier.width(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .background(white)
                .clickable { navControllerLocal.navigate(Screen.DetailScreen.route) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_pink_rose_bouquet),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(modifier = Modifier.wrapContentHeight()) {
                        Text(
                            text = "Camila",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )
                        Text(
                            text = "$350.000",
                            fontSize = 12.sp,
                            color = colorPrimary
                        )

                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(colorPrimary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = white,
                            modifier = Modifier.size(32.dp, 32.dp)
                        )
                    }

                }

            }
        }


    }
}

@Composable
fun CategoryView() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        CategoryButton(
            icon = painterResource(id = R.drawable.ic_chinese_plum_flower),
            backgroundColor = Color(0xffFFFFFF)
        )
        CategoryButton(
            icon = painterResource(id = R.drawable.ic_flat_flower),
            backgroundColor = Color(0xffFFFFFF)
        )
        CategoryButton(
            icon = painterResource(id = R.drawable.ic_giftbox),
            backgroundColor = Color(0xffFFFFFF)
        )
        CategoryButton(
            icon = painterResource(id = R.drawable.ic_wedding_arch),
            backgroundColor = Color(0xffFFFFFF)
        )
    }
}

@Composable
fun CategoryButton(icon: Painter, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(18.dp))
            .padding(18.dp)
    ) {
        Image(painter = icon, contentDescription = "", modifier = Modifier.fillMaxSize())
    }
}


@Composable
fun SlidingBannerView() {

    Image(
        painter = painterResource(id = R.drawable.ic_sale_banner),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth()
    )

}

@Composable
fun HeaderHome() {
    Image(
        painter = painterResource(id = R.drawable.login_bg),
        contentDescription = "login_bg",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize()
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = "FloraGogo",
            color = white,
            fontSize = 24.sp,
            letterSpacing = 2.sp,
            modifier = Modifier.padding(horizontal = 100.dp)
        )

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = white,
                modifier = Modifier.size(32.dp, 32.dp)
            )
        }

    }
}
