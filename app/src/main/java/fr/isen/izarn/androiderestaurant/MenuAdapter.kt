package fr.isen.izarn.androiderestaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.izarn.androiderestaurant.databinding.ActivityDetailBinding

fun String.nullIfEmpty(): String? {
    return this.ifEmpty { null }
}

class MenuAdapter(private val menu: MutableList<DishInfo>, val onItemClicked: (String) -> Unit) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(binding: ActivityDetailBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imageviewItemImage = binding.dishIllustration
        private val textviewItemTitle = binding.titleView
        private val textviewItemPrice = binding.priceView

        fun bind(data: DishInfo) {
            if (data.image.isEmpty())
                Picasso.get().load(R.drawable.ouch).into(imageviewItemImage)
            else
                Picasso.get().load(data.image).into(imageviewItemImage)
            textviewItemTitle.text = data.title
            textviewItemPrice.text = data.price.toString()

            textviewItemTitle.setOnClickListener {
                onItemClicked(data.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val viewHolderBinding = ActivityDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(viewHolderBinding)
    }

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menu[position])
    }

    fun addItem(item: DishInfo) {
        menu.add(item)
        notifyItemInserted(menu.indexOf(item))
    }

}