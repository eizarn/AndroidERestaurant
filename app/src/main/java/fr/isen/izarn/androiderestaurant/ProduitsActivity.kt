package fr.isen.izarn.androiderestaurant

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.izarn.androiderestaurant.databinding.ActivityProduitsBinding

class ProduitsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProduitsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProduitsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dishes = resources.getStringArray(R.array.dishes).toList()
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this) //les éléments vont s'ordonnancer de manière linéaire
        binding.categoryRecyclerView.adapter = CategoryAdapter(dishes as ArrayList<String>) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}