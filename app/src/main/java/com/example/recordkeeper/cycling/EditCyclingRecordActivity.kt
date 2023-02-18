package com.example.recordkeeper.cycling

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recordkeeper.databinding.ActivityEditCyclingRecordBinding
import com.example.recordkeeper.databinding.ActivityEditRunningRecordBinding
import com.example.recordkeeper.databinding.FragmentCyclingBinding

class EditCyclingRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditCyclingRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditCyclingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val ride = intent.getStringExtra("Ride")
        title = "$ride Record"
    }
}