package com.example.android.project.category

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.project.database.CategoryDatabaseDao
import com.example.android.project.database.Category_item
import kotlinx.coroutines.*

class CategoryViewModel(
    dataSource: CategoryDatabaseDao,
    application: Application,
    id:Int
) : ViewModel() {

    val database = dataSource
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var categories_detected=database.get(id)
   var categories_items= listOf<Category_item>(
       Category_item(category_ids = 1,
           preparation_details = listOf(
               "4 Tomatoes",
           "1 Tablespoon of Olive Oil",
           "1 Onion",
           "250g Spaghetti",
           "Spices",
           "Cheese (optional)").joinToString(),
           ingredients = listOf(
               "Cut the tomatoes and the onion into small pieces.",
               "Boil some water - add salt to it once it boils.",
               "Put the spaghetti into the boiling water - they should be done in about 10 to 12 minutes.",
               "In the meantime heaten up some olive oil and add the cut onion.",
               "After 2 minutes add the tomato pieces, salt pepper and your other spices.",
               "The sauce will be done once the spaghetti are.",
               "Feel free to add some cheese on top of the finished dish.").joinToString(),
           title="Spagetti with Tomato sauce"),

       Category_item(category_ids = 2,
           preparation_details = listOf(
               "4 Tomatoes",
               "1 Tablespoon of Olive Oil",
               "1 Onion",
               "250g Spaghetti",
               "Spices",
               "Cheese (optional)").joinToString(),
           ingredients = listOf(
               "Cut the tomatoes and the onion into small pieces.",
               "Boil some water - add salt to it once it boils.",
               "Put the spaghetti into the boiling water - they should be done in about 10 to 12 minutes.",
               "In the meantime heaten up some olive oil and add the cut onion.",
               "After 2 minutes, add the tomato pieces and salt and pepper and your other spices.",
               "The sauce will be done once the spaghetti are.",
               "Feel free to add some cheese on top of the finished dish.").joinToString(),
           title="Spagetti with Tomato sauce"),

       Category_item(category_ids = 2,preparation_details = listOf(
           "1 Slice White Bread",
           "1 Slice Ham",
           "1 Slice Pineapple",
           "1-2 Slices of Cheese",
           "Butter").joinToString(),
           ingredients = listOf(
               "Butter one side of the white bread",
               "Layer ham, the pineapple and cheese on the white bread",
               "Bake the toast for round about 10 minutes in the oven at 200°C").joinToString(),
           title="Toast Hawaii"),
       Category_item(category_ids = 2,preparation_details = listOf(
           "300g Cattle Hack",
           "1 Tomato",
           "1 Cucumber",
           "1 Onion",
           "Ketchup",
           "2 Burger Buns").joinToString(),
           ingredients = listOf(
               "Form 2 patties",
               "Fry the patties for c. 4 minutes on each side",
               "Quickly fry the buns for c. 1 minute on each side",
               "Bruch buns with ketchup",
               "Serve burger with tomato and cucumber and onion").joinToString(),
           title="Classic Hamburger"),
       Category_item(category_ids = 2,preparation_details = listOf(
           "White and Green Asparagus",
           "30g Pine Nuts",
           "300g Cherry Tomatoes",
           "Salad",
           "Salt, Pepper and Olive Oil"

       ).joinToString(), ingredients = listOf(
           "Wash, peel and cut the asparagus",
           "Cook in salted water",
           "Salt and pepper the asparagus",
           "Roast the pine nuts",
           "Halve the tomatoes",
           "Mix with asparagus salad and dressing",
           "Serve with Baguette"

       ).joinToString(),
           title="Asparagus Salad with Cherry Tomatoes"),

       Category_item(category_ids = 3,preparation_details = listOf(
           "300g Cattle Hack",
           "1 Tomato",
           "1 Cucumber",
           "1 Onion",
           "Ketchup",
           "2 Burger Buns").joinToString(),
           ingredients = listOf(
               "Form 2 patties",
               "Fry the patties for c. 4 minutes on each side",
               "Quickly fry the buns for c. 1 minute on each side",
               "Bruch buns with ketchup",
               "Serve burger with tomato, cucumber and onion").joinToString(),
           title="Classic Hamburger"),

       Category_item(category_ids = 4,preparation_details = listOf(
           "8 Veal Cutlets",
           "4 Eggs",
           "200g Bread Crumbs",
           "100g Flour",
           "300ml Butter",
           "100g Vegetable Oil",
           "Salt",
           "Lemon Slices"

       ).joinToString(), ingredients = listOf(
           "Tenderize the veal to about 2–4mm and salt on both sides.",
           "On a flat plate  stir the eggs briefly with a fork.",
           "Lightly coat the cutlets in flour then dip into the egg, and finally coat in breadcrumbs.",
           "Heat the butter and oil in a large pan (allow the fat to get very hot) and fry the schnitzels until golden brown on both sides.",
           "Make sure to toss the pan regularly so that the schnitzels are surrounded by oil and the crumbing becomes ‘fluffy’.",
           "Remove and drain on kitchen paper. Fry the parsley in the remaining oil and drain.",
           "Place the schnitzels on awarmed plate and serve garnishedwith parsley and slices of lemon."

       ).joinToString(),
           title="Wiener Schnitzel"),

       Category_item(category_ids = 5,preparation_details = listOf(
           "White and Green Asparagus",
           "30g Pine Nuts",
           "300g Cherry Tomatoes",
           "Salad",
           "Salt, Pepper and Olive Oil"

       ).joinToString(), ingredients = listOf(
           "Wash, peel and cut the asparagus",
           "Cook in salted water",
           "Salt and pepper the asparagus",
           "Roast the pine nuts",
           "Halve the tomatoes",
           "Mix with asparagus salad and dressing",
           "Serve with Baguette"

       ).joinToString(),
           title="Asparagus Salad with Cherry Tomatoes"),

       Category_item(category_ids = 6,preparation_details = listOf(
           "4 Sheets of Gelatine",
           "150ml Orange Juice",
           "80g Sugar",
           "300g Yoghurt",
           "200g Cream",
           "Orange Peel"

           ).joinToString(), ingredients = listOf(

           "Dissolve gelatine in pot",
           "Add orange juice and sugar",
           "Take pot off the stove",
           "Add 2 tablespoons of yoghurt",
           "Stir gelatin under remaining yoghurt",
           "Cool everything down in the refrigerator",
           "Whip the cream and lift it under die orange mass",
           "Cool down again for at least 4 hours",
           "Serve with orange peel"

           ).joinToString(),
           title="Delicious Orange Mousse"),

       Category_item(category_ids = 7,preparation_details = listOf(
           "1 1/2 Cups all-purpose Flour",
           "3 1/2 Teaspoons Baking Powder",
           "1 Teaspoon Salt",
           "1 Tablespoon White Sugar",
           "1 1/4 cups Milk",
           "1 Egg",
           "3 Tablespoons Butter, melted"

           ).joinToString(), ingredients = listOf(
           "In a large bowl sift together the flour baking powder salt and sugar.",
           "Make a well in the center and pour in the milk egg and melted butter AND  mix until smooth.",
           "Heat a lightly oiled griddle or frying pan over medium high heat.",
           "Pour or scoop the batter onto the griddle  using approximately 1/4 cup for each pancake. Brown on both sides and serve hot."

       ).joinToString(),
           title="Pancakes"),

       Category_item(category_ids = 8,preparation_details = listOf(
           "4 Chicken Breasts",
           "1 Onion",
           "2 Cloves of Garlic",
           "1 Piece of Ginger",
           "4 Tablespoons Almonds",
           "1 Teaspoon Cayenne Pepper",
           "500ml Coconut Milk"

       ).joinToString(), ingredients = listOf(
           "Slice and fry the chicken breast",
           "Process onion AND garlic and ginger into paste and sauté everything",
           "Add spices and stir fry",
           "Add chicken breast WITH 250ml of water and cook everything for 10 minutes",
           "Add coconut milk",
           "Serve with rice"

       ).joinToString(),
           title="Creamy Indian Chicken Curry"),

       Category_item(category_ids = 9,preparation_details = listOf(
           "1 Teaspoon melted Butter",
           "2 Tablespoons white Sugar",
           "2 Ounces 70% dark Chocolate, broken into pieces",
           "1 Tablespoon Butter",
           "1 Tablespoon all-purpose Flour",
           "4 1/3 tablespoons cold Milk",
           "1 Pinch Salt",
           "1 Pinch Cayenne Pepper",
           "1 Large Egg Yolk",
           "2 Large Egg Whites",
           "1 Pinch Cream of Tartar",
           "1 Tablespoon white Sugar"

       ).joinToString(),
           ingredients = listOf(
               "Preheat oven to 190°C. Line a rimmed baking sheet with parchment paper.",
               "Brush bottom and sides of 2 ramekins lightly with 1 teaspoon melted butter; cover bottom and sides right up to the rim.",
               "Add 1 tablespoon white sugar to ramekins. Rotate ramekins until sugar coats all surfaces.",
               "Place chocolate pieces in a metal mixing bowl.",
               "Place bowl over a pan of about 3 cups hot water over low heat.",
               "Melt 1 tablespoon butter in a skillet over medium heat. Sprinkle in flour. Whisk until flour is incorporated into butter and mixture thickens.",
               "Whisk in cold milk until mixture becomes smooth and thickens. Transfer mixture to bowl with melted chocolate.",
               "Add salt and cayenne pepper. Mix together thoroughly. Add egg yolk and mix to combine.",
               "Leave bowl above the hot (not simmering) water to keep chocolate warm while you whip the egg whites.",
               "Place 2 egg whites in a mixing bowl; add cream of tartar. Whisk until mixture begins to thicken and a drizzle from the whisk stays on the surface about 1 second before disappearing into the mix.",
               "Add 1/3 of sugar and whisk in. Whisk in a bit more sugar about 15 seconds.",
               "whisk in the rest of the sugar. Continue whisking until mixture is about as thick as shaving cream and holds soft peaks 3 to 5 minutes.",
               "Transfer a little less than half of egg whites to chocolate",
               "Mix until egg whites are thoroughly incorporated into the chocolate.",
               "Add the rest of the egg whites; gently fold into the chocolate with a spatula lifting from the bottom and folding over.",
                "Stop mixing after the egg white disappears. Divide mixture between 2 prepared ramekins. Place ramekins on prepared baking sheet.",
               "Bake in preheated oven until scuffles are puffed and have risen above the top of the rims  12 to 15 minutes."

           ).joinToString(),
           title="Chocolate Souffle"),

       Category_item(category_ids = 10,preparation_details = listOf(
           "Arugula",
           "Lamb\'s Lettuce",
           "Parsley",
           "Fennel",
           "200g Smoked Salmon",
           "Mustard",
           "Balsamic Vinegar",
           "Olive Oil",
           "Salt and Pepper"

       ).joinToString(), ingredients = listOf(
           "Wash and cut salad and herbs",
           "Dice the salmon",
           "Process mustard  vinegar and olive oil into a dessing",
           "Prepare the salad",
           "Add salmon cubes and dressing"

       ).joinToString(),
           title="Salad with Smoked Salman"),

       Category_item(category_ids = 10,preparation_details = listOf(
           "4 Sheets of Gelatine",
           "150ml Orange Juice",
           "80g Sugar",
           "300g Yoghurt",
           "200g Cream",
           "Orange Peel"

       ).joinToString(), ingredients = listOf(

           "Dissolve gelatine in pot",
           "Add orange juice and sugar",
           "Take pot off the stove",
           "Add 2 tablespoons of yoghurt",
           "Stir gelatin under remaining yoghurt",
           "Cool everything down in the refrigerator",
           "Whip the cream and lift it under die orange mass",
           "Cool down again for at least 4 hours",
           "Serve with orange peel"

       ).joinToString(),
           title="Delicious Orange Mousse"),
       Category_item(category_ids = 10,preparation_details = listOf(
           "White and Green Asparagus",
           "30g Pine Nuts",
           "300g Cherry Tomatoes",
           "Salad",
           "Salt, Pepper and Olive Oil"

       ).joinToString(), ingredients = listOf(
           "Wash, peel and cut the asparagus",
           "Cook in salted water",
           "Salt and pepper the asparagus",
           "Roast the pine nuts",
           "Halve the tomatoes",
           "Mix with asparagus, salad and dressing",
           "Serve with Baguette"

       ).joinToString(),
           title="Asparagus Salad with Cherry Tomatoes")
   )

    private val _navigateToCategory = MutableLiveData<Int>()
    val navigateToCategory: LiveData<Int>
        get() = _navigateToCategory

    fun doneNavigating() {
        _navigateToCategory.value = null
    }
    fun onCategoryListClicked(id:Int){
        _navigateToCategory.value=id
    }
    init {

            clear()
            initializedatabase()
    }
    private fun clear() {
        uiScope.launch {
            fromclear()
        }
    }

    private suspend fun fromclear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }
    private fun initializedatabase() {
        uiScope.launch {

           for (item in categories_items){
               insert(item)
           }
        }
    }

    private suspend fun insert(night: Category_item) {
        withContext(Dispatchers.IO) {
            database.insert(night)
        }
    }
  /*
    private suspend fun update(night: SleepNight) {
        withContext(Dispatchers.IO) {
            database.update(night)
        }
    }*/


  /*
    fun onStart() {
        uiScope.launch {
            // Create a new night, which captures the current time,
            // and insert it into the database.
            val newNight = SleepNight()

            insert(newNight)

            tonight.value = getTonightFromDatabase()
        }
    }

    /**
     * Executes when the STOP button is clicked.
     */
    fun onStop() {
        uiScope.launch {
            // In Kotlin, the return@label syntax is used for specifying which function among
            // several nested ones this statement returns from.
            // In this case, we are specifying to return from launch().
            val oldNight = tonight.value ?: return@launch

            // Update the night in the database to add the end time.
            oldNight.endTimeMilli = System.currentTimeMillis()

            update(oldNight)

            // Set state to navigate to the SleepQualityFragment.
            _navigateToSleepQuality.value = oldNight
        }
    }

    /**
     * Executes when the CLEAR button is clicked.
     */
    fun onClear() {
        uiScope.launch {
            // Clear the database table.
            clear()

            // And clear tonight since it's no longer in the database
            tonight.value = null

            // Show a snackbar message, because it's friendly.
            _showSnackbarEvent.value = true
        }
    }
*/
    /**
     * Called when the ViewModel is dismantled.
     * At this point, we want to cancel all coroutines;
     * otherwise we end up with processes that have nowhere to return to
     * using memory and resources.
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}