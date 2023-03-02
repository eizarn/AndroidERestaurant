package fr.isen.izarn.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.isen.izarn.androiderestaurant.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.`activity_home`)
    }

    public fun on_button_entrees_click(v: View) {
        Toast.makeText(this, "sandvich !", Toast.LENGTH_LONG).show()
        openMenu(v)
    }

    public fun on_button_plats_click(v: View) {
        Toast.makeText(this, "borgar !", Toast.LENGTH_LONG).show()
        openMenu(v)
    }

    public fun on_button_desserts_click(v: View) {
        Toast.makeText(this, "ils sont fous ces romains !", Toast.LENGTH_LONG).show()
        openMenu(v)
    }

    private fun openMenu(v: View) {
        val intent = Intent(v.context, ProduitsActivity::class.java)
        intent.putExtra("dish_type", (v as Button).text.toString())
        v.context.startActivity(intent)
    }
}