package id.cikup.newsapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.cikup.newsapp.R
import id.cikup.newsapp.adapter.NewsAdapter
import id.cikup.newsapp.model.Article

class HomeFragment : Fragment(), HomeContruct.View {

    lateinit var presenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = HomePresenter(this)
        presenter.getNews()

    }

    override fun showProgress() {
        val progress = requireView().findViewById<ConstraintLayout>(R.id.progressHome)
        progress.visibility = View.VISIBLE

    }

    override fun hideProsess() {
        val progress = requireView().findViewById<ConstraintLayout>(R.id.progressHome)
        progress.visibility = View.GONE
    }

    override fun onFailed(messagae: String) {
        val progress = requireView().findViewById<ConstraintLayout>(R.id.progressHome)
        progress.visibility = View.GONE
    }

    override fun getNews(dataItem: List<Article>) {
        val rvNews = requireView().findViewById<RecyclerView>(R.id.rvNews)
        rvNews.setHasFixedSize(true)
        rvNews.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvNews.adapter = NewsAdapter(requireContext(), dataItem)


    }


}