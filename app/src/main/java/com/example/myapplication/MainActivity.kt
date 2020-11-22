package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.List.of

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModelProvider로 ViewModel 생성
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        val viewModel : MainViewModel = MainViewModel(application) <- 이 방식으로 하게되면 자칫 여러번 생성되거나 상태손실될 수 있다 그러니 ViewModelProvider로 관리하자
        viewModel.getAll().observe(this, Observer {
            result_text.text = it.toString()
        })

        //입력 버튼
       enter_btn.setOnClickListener {
           //비동기 처리(백그라운드 스레드)
           lifecycleScope.launch(Dispatchers.IO){
               //db에 insert
               viewModel.insert(Todo(todo_edit.text.toString()))
           }
       }
    }
}
