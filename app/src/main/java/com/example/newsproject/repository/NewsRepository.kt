package com.example.newsproject.repository

import com.example.newsproject.api.Retrofitinstance
import com.example.newsproject.db.ArticleDatabase
import com.example.newsproject.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        Retrofitinstance.api.getHeadlines(countryCode, pageNumber)


    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        Retrofitinstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

     fun getFavoriteNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}