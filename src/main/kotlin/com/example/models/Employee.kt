package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val id: Int,
    val name: String,
    val age: String,
    val address: String
)
