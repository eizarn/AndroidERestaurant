package fr.isen.izarn.androiderestaurant

data class DishInfo(
    private val _id: String,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String
) {
    val id: String get() = _id
}