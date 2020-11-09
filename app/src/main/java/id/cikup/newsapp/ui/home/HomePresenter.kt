package id.cikup.newsapp.ui.home

import id.cikup.newsapp.model.Article
import id.cikup.newsapp.model.NewsModel
import id.cikup.newsapp.service.ServiceConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(model : HomeContruct.View) : HomeContruct.Presenter {

    var view :HomeContruct.View? = null

    init {
        view = model
    }
    override fun getNews() {
        view?.showProgress()
        ServiceConfig.create().getNews().enqueue(object :Callback<NewsModel>{
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                view?.hideProsess()
                if (response.isSuccessful){
                    view?.getNews(response.body()?.articles as List<Article>)
                }else{
                    view?.onFailed(response.toString())
                }
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
               view?.onFailed(t.message.toString())
            }

        })
    }
}