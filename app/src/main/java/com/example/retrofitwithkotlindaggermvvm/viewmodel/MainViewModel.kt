package com.example.retrofitwithkotlindaggermvvm.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithkotlindaggermvvm.base.BaseViewModel
import com.example.retrofitwithkotlindaggermvvm.models.Todo
import com.example.retrofitwithkotlindaggermvvm.networking.TodoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var todoRepository: TodoRepository

    var TodoList = MutableLiveData<List<Todo>>()
    var error = MutableLiveData<String>()
    fun getTodoList(){
        todoRepository.getTodoDatas()
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                compositeDisposable.add(it)
             }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                result -> when{
                            result.hasTodos() -> TodoList.value = result.todos
                            result.haserror() -> error.value = result.errorString
                            else -> error.value = "Null Error"
                        }
            }
    }
    fun getResult():LiveData<List<Todo>>{
        return TodoList
    }
    fun geterror():LiveData<String>{
        return error
    }
}