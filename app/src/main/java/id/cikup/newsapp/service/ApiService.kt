package id.cikup.newsapp.service

import id.cikup.newsapp.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines?country=us&apiKey=7659de32d86f41bfbf3864f433c6252b")
    fun getNews() : Call<NewsModel>
}