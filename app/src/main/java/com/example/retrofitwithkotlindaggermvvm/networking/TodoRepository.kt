package com.example.retrofitwithkotlindaggermvvm.networking

import com.example.retrofitwithkotlindaggermvvm.models.Todo
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

class TodoRepository @Inject constructor() {
    @Inject
    lateinit var todoDataSource: TodoApi

    inner class Result(val todos:List<Todo>?= null,val errorString:String?= null){
        fun hasTodos():Boolean{
            return todos!=null && !todos.isEmpty()
        }

        fun haserror():Boolean{
            return errorString!=null
        }
    }
    fun getTodoDatas(): Single<Result> = todoDataSource.getTodos()
                                            .map { Result(todos = it) }
                                            .onErrorReturn {Result(errorString = it.message)}
}