package fr.isen.izarn.androiderestaurant

import android.media.MediaDrm.LogMessage
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.izarn.androiderestaurant.databinding.ActivityProduitsBinding
import org.json.JSONObject
import com.google.gson.Gson

class ProduitsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProduitsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProduitsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dish_type = intent.getStringExtra("dish_type")
        binding.produitTitle.text = dish_type ?: ""

        val dishes = (when (dish_type) {
            "starters"     -> resources.getStringArray(R.array.starters)
            "main courses" -> resources.getStringArray(R.array.main_courses)
            "desserts"     -> resources.getStringArray(R.array.desserts)
            else           -> emptyArray<String>()
        }).toList()
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this) // les éléments vont s'ordonner linéairement
        binding.categoryRecyclerView.adapter = CategoryAdapter(dishes as ArrayList<String>) { dishName ->
            Toast.makeText(this, dishName, Toast.LENGTH_LONG).show()
            intent.putExtra("dish", dishName)
        }

        getDishFromServer() // TODO: figure this out
    }

    private fun getDishFromServer() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val body = JSONObject()
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST, url, body,
            { response ->
                Log.d("ProduitActivity", "😎")
                val data = Gson().fromJson(response.toString(), DishInfo::class.java)
            },
            { error ->
                Log.e("ProduitActivity", error.toString())
            }
        )
    }
}