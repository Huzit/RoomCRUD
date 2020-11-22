package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db: AppDatabase = Room.databaseBuilder(
        application,         //대상 객체
        AppDatabase::class.java,    //저장할 DB
        "todo-db"             //DB이름
    ).build()

    fun getAll(): LiveData<List<Todo>>{
        return db.todoDao().getAll()
    }
    //반드시 비동기 처리해야된다는 의미의 suspend
    suspend fun insert(todo: Todo){
        db.todoDao().insert(todo)
    }
}