package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //스키마 생성
        val db : AppDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "todo_d1"
        )   .allowMainThreadQueries()
            .build()
//
//        //현재 저장된 튜플 일괄출력
//        View_1.text = db.todoDao().getAll().toString()
//
//        //입력버튼 클릭 이벤트
//        btn_insert.setOnClickListener {
//            db.todoDao().insert(Todo(0, edt_input.text.toString()))
//            View_1.text = db.todoDao().getAll().toString()
//        }
    }
}