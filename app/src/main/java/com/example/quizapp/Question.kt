package com.example.quizapp

data class Question (
    val id : Int,
    val question : String,
    val image : Int,
    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,
    val correctAnswer : Int   // 0 if optionOne , 1 if optionTwo ,.. etc
)