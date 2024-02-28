package com.shrey.my_book.model

data class Book(
    val bookName: String,
    val bookAuthor: String,
    val bookCost: String,
    val bookRatings: String,
    val bookImage: Int // Int type because it holds the id of the image it holds
)