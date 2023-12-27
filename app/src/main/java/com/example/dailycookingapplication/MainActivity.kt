package com.example.dailycookingapplication

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dailycookingapplication.data.Resources
import com.example.dailycookingapplication.ui.theme.DailyCookingApplicationTheme
import androidx.compose.runtime.*
import androidx.compose.ui.draw.rotate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyCookingApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ImageList()
                }
            }
        }
    }
}


fun createListResources(recipe: String, recipeDescription: String, day: Int, imageResourceId: Int):Resources {
    return Resources(recipe, recipeDescription, day, imageResourceId)
}


@Composable
fun loadResources(): List<Resources> {
    return listOf<Resources> (
        createListResources("Spaghetti Bolognese","Brown ground beef in a pan. Add onions, garlic, tomato sauce, and Italian herbs. Simmer and serve over cooked spaghetti.",1, R.drawable.pexels_monica_turlui_7218637),
        createListResources("Margherita Pizza", "Top pizza dough with tomato sauce, fresh mozzarella, tomatoes, and basil. Bake until cheese melts.",2, R.drawable.amirali_mirhashemian_xtlpfib7oum_unsplash),
        createListResources("Chicken Caesar Wraps","Fill wraps with grilled chicken, romaine lettuce, parmesan, and Caesar dressing.", 3, R.drawable.raphael_nogueira_63mhpyeyjca_unsplash),
        createListResources("Vegetarian Stir-Fry", "Stir-fry tofu, vegetables, and soy sauce. Serve over rice.", 4, R.drawable.pexels_kleine_beyers_2181151),
        createListResources("Mushroom Risotto", "Saute mushrooms, onions, and garlic. Stir in Arborio rice and broth.", 5, R.drawable.pexels_jana_ohajdova_11190138),
        createListResources("Shrimp Scampi", "Sauté shrimp, garlic, and white wine. Toss with cooked linguine.", 6, R.drawable.pexels_farhad_ibrahimzade_8697539),
        createListResources("Beef Tacos", "Season ground beef, cook. Fill taco shells with beef and toppings.", 7, R.drawable.pexels_los_muertos_crew_7613568),
        createListResources("Teriyaki Chicken", "Marinate chicken in teriyaki sauce. Grill or bake until done.", 8,R.drawable.pexels_valeria_boltneva_19503821),
        createListResources("Caprese Salad", "Layer tomatoes, mozzarella, and basil. Drizzle with balsamic glaze.", 9, R.drawable.pexels_nadin_sh_11725599),
        createListResources("Spicy Thai Noodles", "Stir-fry noodles, tofu, and veggies in a spicy Thai sauce.", 10, R.drawable.pexels_momo_king_5409027),
        createListResources("Lemon Garlic Roast Chicken", "Rub chicken with lemon, garlic, and herbs. Roast until golden.", 11,R.drawable.pexels_tim_douglas_6210876),
        createListResources("Quinoa Salad", "Combine cooked quinoa, veggies, and vinaigrette. Chill before serving.", 12,R.drawable.pexels_karen_la_rk_boshoff_9893127 ),
        createListResources("Pesto Pasta", "Blend basil, pine nuts, garlic, and olive oil. Toss with cooked pasta.", 13,R.drawable.pexels_cassie_smith_2090921),
        createListResources("Greek Gyros", "Marinate and grill thinly sliced lamb. Serve in pita with tzatziki.", 14, R.drawable.pexels_alena_shekhovtcova_6941000),
        createListResources("Butter Chicken", "Cook chicken in a creamy tomato sauce with butter and spices.", 15, R.drawable.pexels_harry_dona_2338407),
        createListResources("Cajun Shrimp Pasta", "Sauté shrimp in Cajun seasoning. Toss with creamy pasta.", 16, R.drawable.pexels_polina_tankilevitch_4518844),
        createListResources("Eggplant Parmesan", "Bread and bake eggplant slices. Layer with marinara and cheese.", 17,R.drawable.pexels_nadin_sh_19295802),
        createListResources("Sushi Rolls", "Prepare sushi rice, roll with veggies, and your choice of fish.", 18, R.drawable.pexels_polina_tankilevitch_4725637),
        createListResources("Lentil Soup", "Simmer lentils, carrots, onions, and spices in vegetable broth.", 19, R.drawable.pexels_foodie_factor_539451),
        createListResources("Chimichurri Steak", "Marinate and grill steak, serve with chimichurri sauce.", 20, R.drawable.pexels_chevanon_photography_323682),
        createListResources("Crispy Brussels Sprouts", "Roast Brussels sprouts with olive oil, garlic, and balsamic glaze.", 21, R.drawable.pexels_ekaterina_bolovtsova_5662188),
        createListResources("Tomato Basil Bruschetta", "Top sliced baguette with diced tomatoes, basil, and balsamic glaze.", 22, R.drawable.pexels_shameel_mukkath_5639411),
        createListResources("Taco Tuesday", "Season ground beef with taco seasoning. Assemble tacos with lettuce, tomatoes, cheese, and salsa.", 23, R.drawable.spencer_davis_hs2076lrvkq_unsplash),
        createListResources("Spinach and Feta Stuffed Chicken", "Stuff chicken breasts with spinach and feta. Bake until golden. Serve with a side salad.", 24, R.drawable.pexels_kaboompics_com_5938),
        createListResources("Vegetable Quesadillas", "Saute mixed vegetables and black beans. Fill tortillas with the mixture and cheese.", 25, R.drawable.pexels_alleksana_6399990 ),
        createListResources("Classic Hamburger", "Form ground beef into patties. Grill or cook in a skillet until desired doneness. Place in a bun and add lettuce, tomato, onion, pickles, and condiments.", 26, R.drawable.haseeb_jamil_j9ld6fs6_cs_unsplash),
        createListResources("Italian Meatball Subs with Parmesan Fries", "Prepare meatballs with a blend of ground beef and pork. Bake until cooked through. Place in a sub roll with marinara sauce and melted cheese. Serve with oven-baked Parmesan fries.", 27, R.drawable.pexels_b_ra_yaman_8272555),
        createListResources("Chicken Noodle Soup", "Boil chicken with vegetables, add noodles, and simmer until cooked. Season with salt, pepper, and herbs.", 28, R.drawable.pexels_karolina_grabowska_4210846),
        createListResources("Tomato, Cheese, and Sausage Shashlik", "Thread cherry tomatoes, cheese cubes, and sausage onto skewers. Grill until tomatoes blister and cheese melts. Serve with your favorite dipping sauce.", 29, R.drawable.pexels_aidin_gheshlaghi_16716140),
        createListResources("Loaded Big Hot Dog", "Grill or steam a large hot dog. Place it in a bun and load it up with a variety of toppings such as sautéed onions, diced tomatoes, pickles, jalapeños, shredded lettuce, and a generous drizzle of ketchup, mustard, and mayonnaise.", 30, R.drawable.pexels_enesfilm_8946510)
    )
}

@Composable
fun ImageList(modifier: Modifier = Modifier){
    val resourceList = loadResources()
    LazyColumn(modifier = modifier) {
        items(resourceList) {
            item: Resources ->
            ImageCard(
                resource = item,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageCard(resource:Resources, modifier:Modifier = Modifier){
    var expandableState by remember { mutableStateOf(false) }
    Card(modifier = modifier,
        onClick = {expandableState = !expandableState}){
        Column(
            modifier = modifier
                .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,


        ) {
            Text(
                text = "Recipe of the Day: ${resource.day}",
                style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                    painter = painterResource(id = resource.imageResourceId),
                    contentDescription = resource.recipeDescription,
                    modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop,
                )

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = resource.recipe, color = MaterialTheme.colorScheme.onSurfaceVariant,style = MaterialTheme.typography.labelMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                if (expandableState){
                    Text(
                        modifier = modifier.weight(6f),
                        text = "Collapse recipe description",
                        style = MaterialTheme.typography.bodyMedium)
                }
                else{
                    Text(
                        modifier = modifier.weight(6f),
                        text = "Expand for recipe description",
                        style = MaterialTheme.typography.bodyMedium)
                }

                IconButton(
                    modifier = modifier
                        .weight(1f),
                    onClick = { expandableState = !expandableState},) {

                    Icon(
                        imageVector = if (expandableState) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Arrow",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }

            }
            if(expandableState){
                Text(
                    text = resource.recipeDescription,
                    modifier = Modifier
                        .padding(12.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }

    }

}