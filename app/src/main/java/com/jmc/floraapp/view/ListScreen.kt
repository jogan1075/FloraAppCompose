package com.jmc.floraapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.jmc.floraapp.R
import com.jmc.floraapp.navigation.Screen
import com.jmc.floraapp.ui.theme.black
import com.jmc.floraapp.ui.theme.colorPrimary
import com.jmc.floraapp.ui.theme.ghost_white
import com.jmc.floraapp.ui.theme.white

@SuppressLint("StaticFieldLeak")
lateinit var navControllerList: NavController

@Composable
fun ListScreen(navController: NavController) {
    navControllerList = navController
    ViewList()
}


@Preview(showBackground = true)
@Composable
fun ViewList() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout {
            val (topappbarbgref, popularitemsref) = createRefs()

            Box(modifier = Modifier
                .height(100.dp)
                .constrainAs(topappbarbgref) {
                    top.linkTo(topappbarbgref.top)
                    bottom.linkTo(topappbarbgref.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                HeaderHomeListItems()
            }

            Surface(
                color = ghost_white,
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ), modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp)
                    .constrainAs(popularitemsref) {
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

                    ListItemSection()
                    Spacer(modifier = Modifier.padding(10.dp))
                    ListItemSection()
                    Spacer(modifier = Modifier.padding(10.dp))
                    ListItemSection()
                    Spacer(modifier = Modifier.padding(10.dp))
                    ListItemSection()
                }

            }

        }
    }
}

@Composable
fun ListItemSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .wrapContentHeight()
                .clip(RoundedCornerShape(16.dp))
                .background(white)
                .clickable {
                    navControllerList.navigate(Screen.DetailScreen.route)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_red_rose_bouquet),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.wrapContentHeight()) {
                        Text(
                            text = "Angle",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )
                        Text(text = "$567.00", fontSize = 12.sp, color = colorPrimary)
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(colorPrimary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp)
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
                .clip(RoundedCornerShape(16.dp))
                .background(white)
                .clickable { navControllerList.navigate(Screen.DetailScreen.route) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_pink_rose_bouquet),
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(modifier = Modifier.wrapContentHeight()) {
                        Text(
                            text = "Jannien",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = black
                        )
                        Text(text = "$567.00", fontSize = 12.sp, color = colorPrimary)
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(colorPrimary)
                            .padding(4.dp)
                            .shadow(elevation = 8.dp)
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
fun HeaderHomeListItems() {
    Image(
        painter = painterResource(id = R.drawable.login_bg),
        contentDescription = "login_bg",
        contentScale = ContentScale.FillWidth, modifier = Modifier.fillMaxSize()
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navControllerList.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                tint = white
            )

        }

        Text(
            text = "Popular Items",
            color = white,
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )

        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "", tint = white)
        }

    }
}
