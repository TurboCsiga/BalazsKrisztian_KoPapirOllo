package com.example.balazskrisztian_kopapirollo

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var icon_ember : ImageView
    lateinit var icon_gep : ImageView
    lateinit var win_ember : TextView
    lateinit var win_gep : TextView
    lateinit var btn_ko : Button
    lateinit var btn_papir : Button
    lateinit var btn_ollo : Button

    var random = Random
    var ember = 0
    var dontetlen = 0
    var vereseg = 0
    var gyozelem = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init();
    }

    fun init() {
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
        icon_ember.setImageResource(R.drawable.scissors)
        ember = 2
        gep()
    }

    private fun btn_papirOn() {
        icon_ember.setImageResource(R.drawable.paper)
        ember = 1
        gep()
    }

    private fun btn_koOn() {
        icon_ember.setImageResource(R.drawable.rock)
        ember = 0
        gep()
    }

    fun gep() {
        val gep_szam = random.nextInt(3)

        if (gep_szam == 0) {
            icon_gep.setImageResource(R.drawable.rock)
        } else if (gep_szam == 1) {
            icon_gep.setImageResource(R.drawable.paper)
        } else if (gep_szam == 2) {
            icon_gep.setImageResource(R.drawable.scissors)
        }

        if (ember == gep_szam) {
            dontetlen_kekw()
        } else if (ember == 2 && gep_szam == 0) {
            vereseg_kekw()
        } else if (ember == 0 && gep_szam == 2) {
            gyozelem_kekw()
        } else if (ember > gep_szam) {
            gyozelem_kekw()
        } else {
            vereseg_kekw()
        }
    }

        fun dontetlen_kekw() {
            dontetlen++
        }

        fun vereseg_kekw() {
            vereseg++
            ujgep()
        }

        fun gyozelem_kekw() {
            gyozelem++
            ujember()
        }

        fun ujgep() {
            win_gep.setText(vereseg.toString())
            nezzedhogywinee()
        }

        fun ujember() {
            win_ember.setText(gyozelem.toString())
            nezzedhogywinee()
        }

    fun ujelet() {
        ember = 0
        dontetlen = 0
        vereseg = 0
        gyozelem = 0

        icon_gep.setImageResource(R.drawable.rock)
        icon_ember.setImageResource(R.drawable.rock)

        win_ember.setText("0")
        win_gep.setText("0")
    }


    fun nezzedhogywinee() {
        if (gyozelem == 3) {
            var alertacio = AlertDialog.Builder(this).setTitle("Win volt")
                .setCancelable(false)
                .setMessage("Mehet tov??bb a csapat??s?")
                .setPositiveButton("Nan?? haverda", DialogInterface.OnClickListener { dialogInterface, i -> ujelet() })
                .setNegativeButton("Hagyj??l m??r tesa", DialogInterface.OnClickListener { dialogInterface, i -> finish() })
                .show()
        }
        else if (vereseg == 3) {
            var alertacio = AlertDialog.Builder(this).setTitle("Nem win volt")
                .setCancelable(false)
                .setMessage("Mehet tov??bb a csapat??s?")
                .setPositiveButton("Nan?? haverda", DialogInterface.OnClickListener { dialogInterface, i -> ujelet() })
                .setNegativeButton("Hagyj??l m??r tesa", DialogInterface.OnClickListener { dialogInterface, i -> finish() })
                .show()
        }
    }
}

