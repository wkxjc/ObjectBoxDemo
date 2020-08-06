package com.example.objectboxdemo
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

@Entity
data class Note(
    // id 必须为var（因为id会自增），Long类型，初始化为0。不妨记作固定写法
        @Id var id: Long = 0,
        var text: String,
        var createAt: Date
)
