package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.enterbtn)
        val et_name = findViewById<EditText>(R.id.edTxt)

        btnStart.setOnClickListener {
            if (et_name.text.isEmpty()){
                Toast.makeText(this,"Enter a name!",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,quizQueActivity :: class.java)
                intent.putExtra(Constants.USER_NAME , edTxt.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}