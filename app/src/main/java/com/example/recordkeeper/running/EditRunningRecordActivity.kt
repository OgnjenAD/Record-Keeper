package com.example.recordkeeper.running

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.recordkeeper.databinding.ActivityEditRunningRecordBinding

class EditRunningRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRunningRecordBinding
    private lateinit var runningPreferences: SharedPreferences
    private val distance: String? by lazy { intent.getStringExtra("Distance") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        runningPreferences = getSharedPreferences("running", Context.MODE_PRIVATE)

        title = "$distance Record"

        displayRecord()

        binding.btnSave.setOnClickListener {
            saveRecord()
            finish()
        }
    }

    private fun displayRecord() {
        binding.etRecord.setText(runningPreferences.getString("$distance record", null))
        binding.etDate.setText(runningPreferences.getString("$distance date", null))
    }

    private fun saveRecord() {
        val record = binding.etRecord.text.toString()
        val date = binding.etDate.text.toString()
        
        runningPreferences.edit {
            putString("$distance record", record)
            putString("date", date)
        }
    }
}