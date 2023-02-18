package com.example.recordkeeper.running

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun setupClickListeners() {
        binding.container5km.setOnClickListener { launchRunningRecordScreen("5km") }
        binding.container10km.setOnClickListener { launchRunningRecordScreen("10km") }
        binding.containerHalfMarathon.setOnClickListener { launchRunningRecordScreen("Half Marathon") }
        binding.containerMarathon.setOnClickListener { launchRunningRecordScreen("Marathon") }
    }

    private fun displayRecords() {
        val runningPreferences = requireContext().getSharedPreferences("running", Context.MODE_PRIVATE)

        binding.tv5kmValue.text = runningPreferences.getString("5km record", null)
        binding.tv5kmDate.text = runningPreferences.getString("5km date", null)

        binding.tv10kmValue.text = runningPreferences.getString("10km record", null)
        binding.tv10kmValue.text = runningPreferences.getString("10km date", null)

        binding.tvHalfMarathonValue.text = runningPreferences.getString("Half Marathon record", null)
        binding.tvHalfMarathonValue.text = runningPreferences.getString("Half Marathon date", null)

        binding.tvMarathonValue.text = runningPreferences.getString("Marathon record", null)
        binding.tvMarathonDate.text = runningPreferences.getString("Marathon date", null)
    }

    private fun launchRunningRecordScreen(distance: String) {
        val intent = Intent(context, EditRunningRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }

}