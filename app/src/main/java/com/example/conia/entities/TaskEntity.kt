package com.example.conia.entities

data class TaskEntity(val id: Int,
                      val userId: Int,
                      val careerId: Int,
                      var description: String,
                      var dueDate: String,
                      var complete: Boolean)