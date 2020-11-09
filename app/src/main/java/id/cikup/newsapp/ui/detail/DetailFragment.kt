package id.cikup.newsapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso
import id.cikup.newsapp.R

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val title = arguments?.get("judul")
        val description = arguments?.get("description")
        val author = arguments?.get("author")
        val publishAt = arguments?.get("date")
        val image = arguments?.get("image")


        val imageIV = requireView().findViewById<ImageView>(R.id.imageDetailFragmentIV)
        val titleTV = requireView().findViewById<TextView>(R.id.titleDetailNewsTV)
        val descriptionTV = requireView().findViewById<TextView>(R.id.contentDetailNewsTV)
        val authorTV = requireView().findViewById<TextView>(R.id.authorDetailNewsTV)
        val dateTV = requireView().findViewById<TextView>(R.id.dateDetailNewsTV)

        Picasso.get().load(image.toString()).into(imageIV)

        titleTV.text = title.toString()
        descriptionTV.text = description.toString()
        authorTV.text = author.toString()
        dateTV.text = publishAt.toString()


    }
}