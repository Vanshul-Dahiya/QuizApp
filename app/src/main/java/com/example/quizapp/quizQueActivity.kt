package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_que.*

class quizQueActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mUserName  : String? = null
    private var mCorrectAnswers  : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_que)

//        fetching username from main activity
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()

//        passing to Onclick function via "this"
        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)



    }

    private fun setQuestion() {
        Toast.makeText(this, "Total quesitons : ${mQuestionList!!.size}", Toast.LENGTH_SHORT).show()


        //        gives us individual question
        val question = mQuestionList!![mCurrentPosition - 1]

        //        reset options color
        defaultOptionsView()

        //        setting up progressbarText according to question Number
        progressBar?.progress = mCurrentPosition

        //        setting up progressbar according to question Number
        tv_progress?.text = "$mCurrentPosition / ${progressBar?.max}"

        //        accessing image property of question object and setting it as imageResource
        iv_img1?.setImageResource(question.image)

        //        setting question text as question from question list
        QuesTv?.text = question.question

        //        setting options
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        onclickabke()

        //        if we are at last question ->
        if (mCurrentPosition == mQuestionList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
    }

    private fun unclickabke() {
        optionOne?.isClickable = false
        optionTwo?.isClickable = false
        optionThree?.isClickable = false
        optionFour?.isClickable = false
    }
    private fun onclickabke() {
        optionOne?.isClickable = true
        optionTwo?.isClickable = true
        optionThree?.isClickable = true
        optionFour?.isClickable = true
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

//        adding all options in our 'options' variable
        optionOne?.let {
            options.add(0,it)
        }
        optionTwo?.let {
            options.add(1,it)
        }
        optionThree?.let {
            options.add(2,it)
        }
        optionFour?.let {
            options.add(3,it)
        }

//        Go through all options and set them as following
        for (option in options){
            option.setTextColor(Color.parseColor("#FF03DAC5"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.options)
        }
    }

//    highlight selected option
    private fun selectedOptionView(tv : TextView,selectedOptionNum : Int){

        defaultOptionsView()

//        setting position of selected option
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#FF03DAC5"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne -> {
                optionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.optionTwo -> {
                optionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.optionThree -> {
                optionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.optionFour -> {
                optionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btn_submit -> {
//                check if selectedoptionpostion = 0 , 0 is selectedoption by default
                if (mSelectedOptionPosition == 0){
//                    going to next question
                    mCurrentPosition++

//                    as long as we have questions left , iterate ->
                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
//                        at the end of question list , no more questions left
                        else ->{
                            val intent = Intent(this,resultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
//                    mSelectedOptionPosition != 0   => not at first ques ,on any else ques no

                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option)
                    }else{
//                        if answer is correct , increase score
                        mCorrectAnswers++
                    }
//                    no matter right or wrong , correct option will always turn green
                    answerView(question.correctAnswer,R.drawable.correct_option)

//                    Now check if we are at end of question list
                    if (mCurrentPosition == mQuestionList!!.size){
                        btn_submit?.text = "FINISH"
                    }else{
                        btn_submit?.text = "Go to NEXT Question"
                    }.also {
                        unclickabke()
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer : Int , drawableView : Int){

        when(answer){
            1 -> {
                optionOne.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

}