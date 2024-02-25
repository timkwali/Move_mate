package com.timkwali.shipmentapp.ui.features.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.timkwali.shipmentapp.R
import com.timkwali.shipmentapp.ui.theme.NavyBlue
import com.timkwali.shipmentapp.ui.theme.orange
import com.timkwali.shipmentapp.ui.utils.ContentAnimatedVisibility
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.timkwali.shipmentapp.ui.theme.DirtyWhite
import com.timkwali.shipmentapp.ui.theme.grey
import com.timkwali.shipmentapp.ui.theme.transparent

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = viewModel(),
    navController: NavController,
    containerState: ContainerState = ContainerState.HOME,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isContentVisible by remember { mutableStateOf(false) }
    val searchResults by viewModel.searchResults.collectAsStateWithLifecycle()
    var animateTopBar by remember { mutableStateOf(false) }

    LaunchedEffect("") {
        isContentVisible = true
        animateTopBar = true
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(DirtyWhite),
        topBar = {
            AppBar(
                searchQuery = viewModel.searchQuery,
                onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
                onClick = {
                    onBack()
                    navController.popBackStack()
                },
                animateTopBar = animateTopBar
            )
        },
    ) { paddingValues ->
        ContentAnimatedVisibility(visibility = isContentVisible) {
            SearchContent(searchResults, paddingValues)
        }
    }
}

@Composable
private fun AppBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onClick: () -> Unit,
    animateTopBar: Boolean
) {
    var animateAppBar by remember { mutableStateOf(false) }
    val appBarHeight: Dp by animateDpAsState(
        targetValue = if (animateAppBar) 55.dp else 120.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "appBarHeight"
    )
    val searchBarPosition by animateDpAsState(
        targetValue = if(animateAppBar) 0.dp else 60.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "searchBarPosition"
    )
    val searchBarPaddingStart by animateDpAsState(
        targetValue = if(animateAppBar) 50.dp else 20.dp,
        animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing), label = "paddingStart"
    )

    LaunchedEffect(key1 = "") {
        animateAppBar = true
    }
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(end = 12.dp, top = 16.dp, bottom = 20.dp)
                .height(appBarHeight),
            contentAlignment = Alignment.TopStart
        ) {
            androidx.compose.animation.AnimatedVisibility(
                visible = animateTopBar,
                enter = slideInHorizontally(
                    initialOffsetX = { w -> -w },
                    animationSpec = tween(durationMillis = 500)
                ) + fadeIn(
                    tween(500),
                ),
                exit = slideOutHorizontally(tween(durationMillis = 500)) + fadeOut(tween(500))
            ) {
                IconButton(onClick = onClick, modifier = Modifier.size(50.dp).padding(top = 10.dp)) {
                    Icon(Icons.Default.KeyboardArrowLeft, tint = Color.White, contentDescription = null)
                }
            }

            TextField(
                value = searchQuery, onValueChange = onSearchQueryChange,
                placeholder = {
                    Text(
                        text = "Enter the receipt number ...",
                        modifier = Modifier
//                            .weight(1f)
                            .background(color = transparent),
                        style = typography.titleMedium.copy(color = grey),
                        overflow = TextOverflow.Ellipsis
                    )
                },
                modifier = Modifier
                    .padding(end = 8.dp, start = searchBarPaddingStart)
                    .fillMaxWidth()
                    .height(56.dp)
                    .offset(y = searchBarPosition)
                    .clip(RoundedCornerShape(48.dp))
                    .focusRequester(remember { FocusRequester() })
                    .clickable { },
                leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = "Search") },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedPlaceholderColor = Color.Gray.copy(0.8f),
                    unfocusedPlaceholderColor = Color.Gray.copy(0.8f),
                    focusedTextColor = Color.Gray.copy(alpha = 0.8f),
                ),
                trailingIcon = {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(CircleShape)
                            .background(orange)
                            .size(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_flip),
                            contentDescription = "Scanner",
                            tint = Color.White,
                            modifier = Modifier
                                .size(20.dp)
                                .rotate(90f)
                        )
                    }
                }
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun SearchContent(
    searchResults: List<Item>,
    paddingValues: PaddingValues,
) {
    AnimatedContent(targetState = searchResults, label = "", transitionSpec = {
        ContentTransform(
            targetContentEnter = slideInVertically(
                initialOffsetY = { fullHeight -> fullHeight },
                animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
            ) + fadeIn(
                initialAlpha = 0f,
                animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
            ),
            initialContentExit = slideOutVertically(
                targetOffsetY = { h -> h },
                animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
            ) + fadeOut(
                targetAlpha = 0f,
                animationSpec = tween(durationMillis = 500, easing = LinearOutSlowInEasing)
            ),
        )
    }) { newList ->
        Surface(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .padding(vertical = 12.dp, horizontal = 16.dp)
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(12.dp))
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                items(
                    count = newList.size,
                    key = { index -> newList[index].name },
                    itemContent = { index ->
                        val item = newList[index]
                        ListItem(item = item)
                        if (index < newList.lastIndex) {
                            Spacer(modifier = Modifier.size(12.dp))
                            Divider(color = Color.Gray.copy(0.4f), thickness = 1.dp)
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ListItem(
    item: Item,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .size(35.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.box2),
                modifier = Modifier.size(20.dp),
                contentDescription = null,
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.size(12.dp))
        // Column with a text and a row with a text, a ball point and another text
        // forward arrow and another text
        Column {
            Text(text = item.name, color = NavyBlue, style = typography.titleLarge)
            Spacer(modifier = Modifier.size(4.dp))
            FlowRow(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top
            ) {
                Text(text = item.id, color = Color.Gray, style = typography.bodyLarge)
                // Ball point here
                Spacer(modifier = Modifier.size(6.dp))
                BallPoint(color = Color.Gray, modifier = Modifier.padding(top = 5.dp))
                Spacer(modifier = Modifier.size(6.dp))
                Text(text = item.origin, color = Color.Gray, style = typography.bodyLarge)
                Spacer(modifier = Modifier.size(6.dp))
                Icon(
                    Icons.Default.ArrowForward,
                    modifier = Modifier.size(12.dp),
                    tint = Color.Gray,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(text = item.destination, color = Color.Gray, style = typography.bodyLarge)
            }
        }
    }
}