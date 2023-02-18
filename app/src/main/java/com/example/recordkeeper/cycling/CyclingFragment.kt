package com.example.recordkeeper.cycling

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recordkeeper.databinding.FragmentCyclingBinding

class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOnClickViewListeners()
    }

    private fun setupOnClickViewListeners() {
        binding.containerLongestRide.setOnClickListener { launchEditCyclingRecordScreen("Longest Ride") }
        binding.containerBiggestClimb.setOnClickListener { launchEditCyclingRecordScreen("Biggest Climb") }
        binding.containerBestSpeed.setOnClickListener { launchEditCyclingRecordScreen("Best Average Speed") }
    }

    private fun launchEditCyclingRecordScreen(ride: String) {
        val intent = Intent(context, EditCyclingRecordActivity::class.java)
        intent.putExtra("Ride", ride)
        startActivity(intent)
    }

}