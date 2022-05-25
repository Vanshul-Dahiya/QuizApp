package com.example.quizapp

object Constants {
//    username , amount of questions , correct Answers

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

//    from question activity
    fun getQuestions() : ArrayList<Question>{

        val questionsList = ArrayList<Question>()
//    fill this list by creating individual questions

//    val que1 = Question(
//        1,
//        "What country does this flag belong to?",
//        R.drawable.coolbg,
//        "BHARAT",
//        "HINDUSTAN",
//        "INDIAN",
//        "Pakistan ka BAP",
//        1
//    )
//    queslist.add(que1)
//    val que2 = Question(
//        1,
//        "What country does this flag belong to?",
//        R.drawable.coolbg,
//        "CHIN",
//        "CHINA",
//        "...",
//        "malaysia",
//        1
//    )
//    queslist.add(que2)

    // 1
    val que1 = Question(
        1, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Argentina", "Australia",
        "Armenia", "Austria", 1
    )

    questionsList.add(que1)

    // 2
    val que2 = Question(
        2, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Angola", "Austria",
        "Australia", "Armenia", 3
    )

    questionsList.add(que2)

    // 3
    val que3 = Question(
        3, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Belarus", "Belize",
        "Brunei", "Brazil", 4
    )

    questionsList.add(que3)

    // 4
    val que4 = Question(
        4, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Bahamas", "Belgium",
        "Barbados", "Belize", 2
    )

    questionsList.add(que4)

    // 5
    val que5 = Question(
        5, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Gabon", "France",
        "Fiji", "Finland", 3
    )

    questionsList.add(que5)

    // 6
    val que6 = Question(
        6, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Germany", "Georgia",
        "Greece", "none of these", 1
    )

    questionsList.add(que6)

    // 7
    val que7 = Question(
        7, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Dominica", "Egypt",
        "Denmark", "Ethiopia", 3
    )

    questionsList.add(que7)

    // 8
    val que8 = Question(
        8, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Ireland", "Iran",
        "Hungary", "India", 4
    )

    questionsList.add(que8)

    // 9
    val que9 = Question(
        9, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Australia", "New Zealand",
        "Tuvalu", "United States of America", 2
    )

    questionsList.add(que9)

    // 10
    val que10 = Question(
        10, "What country does this flag belong to?",
        R.drawable.coolbg,
        "Kuwait", "Jordan",
        "Sudan", "Palestine", 1
    )

    questionsList.add(que10)
    return questionsList
    }

}