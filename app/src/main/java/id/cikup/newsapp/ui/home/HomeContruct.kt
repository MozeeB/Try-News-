package id.cikup.newsapp.ui.home

import id.cikup.newsapp.model.Article

interface HomeContruct {

    interface View{
        fun showProgress()
        fun hideProsess()
        fun onFailed(messagae:String)
        fun getNews(dataItem:List<Article>)
    }

    interface Presenter{
        fun getNews()
    }
}