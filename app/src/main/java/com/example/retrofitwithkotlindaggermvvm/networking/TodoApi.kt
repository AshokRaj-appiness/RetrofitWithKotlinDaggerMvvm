package com.example.retrofitwithkotlindaggermvvm.networking

import com.example.retrofitwithkotlindaggermvvm.models.Todo
import io.reactivex.Single
import retrofit2.http.GET

interface TodoApi {
    @GET("/todos/")
    fun getTodos(): Single<List<Todo>>
}