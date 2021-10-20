package com.example.balazskrisztian_kopapirollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var icon_ember : ImageView
    lateinit var icon_gep : ImageView
    lateinit var win_ember : TextView
    lateinit var win_gep : TextView
    lateinit var btn_ko : Button
    lateinit var btn_papir : Button
    lateinit var btn_ollo : Button

    var ember = 0
    var win = 0
    var lose = 0
    var draw = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init();
    }

    fun init(){
        icon_ember = findViewById(R.id.icon_ember)
        icon_gep = findViewById(R.id.icon_gep)
        win_ember = findViewById(R.id.win_ember)
        win_gep = findViewById(R.id.win_gep)
        btn_ko = findViewById(R.id.btn_ko)
        btn_papir = findViewById(R.id.btn_papir)
        btn_ollo = findViewById(R.id.btn_ollo)
        btn_ko.setOnClickListener {btn_koOn()}
        btn_papir.setOnClickListener {btn_papirOn()}
        btn_ollo.setOnClickListener {btn_olloOn()}
    }

    private fun btn_olloOn() {
        TODO("Not yet implemented")
    }

    private fun btn_papirOn() {
        TODO("Not yet implemented")
    }

    private fun btn_koOn() {
        TODO("Not yet implemented")
    }

}
