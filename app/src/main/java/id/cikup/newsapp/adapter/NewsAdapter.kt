package id.cikup.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.cikup.newsapp.R
import id.cikup.newsapp.model.Article

class NewsAdapter(c: Context?, data: List<Article>?) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var dataItem: List<Article>? = data
    var mContext: Context? = c

    override fun getItemCount(): Int {
        return dataItem?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.judul?.text = dataItem?.get(position)?.title
        holder.description?.text = dataItem?.get(position)?.description

        Picasso.get().load(dataItem?.get(position)?.urlToImage).into(holder.image)

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("judul" to dataItem?.get(position)?.title,
            "description" to dataItem?.get(position)?.description,
            "image" to dataItem?.get(position)?.urlToImage,
            "author" to dataItem?.get(position)?.author,
            "date" to dataItem?.get(position)?.publishedAt)


            it.findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }
    }


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var judul = itemView?.findViewById<TextView>(R.id.newsTitleItemViewTV)
        var description = itemView?.findViewById<TextView>(R.id.newsDescriptionItemViewTV)
        var image = itemView?.findViewById<ImageView>(R.id.newsItemViewIV)



    }
}
