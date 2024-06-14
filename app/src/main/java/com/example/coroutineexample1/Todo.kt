package com.example.coroutineexample1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo (var content: String){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}