package com.jaehyeon.data.remote.dto

data class Body(
    val dataType: String,
    val items: Items,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int
)