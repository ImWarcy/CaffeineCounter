package com.caffeine.counter

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var caffeineMg = 0
    private var lastValue = 0

    private lateinit var textCounter: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textCounter = findViewById(R.id.text_counter)
        progressBar = findViewById(R.id.progress_indicator)

        val btnMonster = findViewById<Button>(R.id.btn_monster)
        val btnEspresso = findViewById<Button>(R.id.btn_espresso)
        val btnCocaCola = findViewById<Button>(R.id.btn_cocacola)
        val btnCustom = findViewById<Button>(R.id.btn_custom)
        val btnRevert = findViewById<Button>(R.id.btn_revert)
        val btnReset = findViewById<Button>(R.id.btn_reset)

        btnMonster.setOnClickListener {
            addCaffeine(160)
        }

        btnEspresso.setOnClickListener {
            addCaffeine(60)
        }

        btnCocaCola.setOnClickListener {
            addCaffeine(24)
        }

        btnCustom.setOnClickListener {
            showCustomDialog()
        }

        btnRevert.setOnClickListener {
            revertLast()
        }

        btnReset.setOnClickListener {
            resetCounter()
        }

        updateCounter()
    }