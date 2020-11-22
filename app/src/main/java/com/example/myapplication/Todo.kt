package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @ColumnInfo//타이틀
    public var title: String?
) {
    @PrimaryKey(autoGenerate = true)//PK 자동 생성
    public var id: Int = 0
}