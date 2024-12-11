package recycler_view_pack

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RvMoviesItemBinding

// Data class to hold movie details
data class Movie(val name: String, val description: String, val imageResId: Int)

class MyAdapter : RecyclerView.Adapter<MyAdapter.MovieViewHolder>() {

    private var itemsList: List<Movie> = emptyList()

    fun updateItems(newItems: List<Movie>) {
        itemsList = newItems
        notifyDataSetChanged()
    }

    // ViewHolder using ViewBinding
    class MovieViewHolder(private val binding: RvMoviesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movieName.text = movie.name
            binding.movieDescription.text = movie.description
            binding.movieImage.setImageResource(movie.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = RvMoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size
}
