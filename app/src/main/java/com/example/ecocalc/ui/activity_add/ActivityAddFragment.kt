package com.example.ecocalc.ui.activity_add

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import com.example.ecocalc.R
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.data.utils.articleList
import com.example.ecocalc.databinding.FragmentActivityAddBinding
import com.example.ecocalc.databinding.FragmentArticlesBinding
import com.example.ecocalc.ui.dialog.MealDialog
import com.example.ecocalc.ui.dialog.PlasticDialog
import com.example.ecocalc.ui.dialog.TransportDialog
import javax.net.ssl.ManagerFactoryParameters

class ActivityAddFragment : Fragment() {

    companion object {
        fun newInstance() = ActivityAddFragment()
    }

    private lateinit var viewModel: ActivityAddViewModel
    private var _binding: FragmentActivityAddBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ActivityAddViewModel::class.java)
        _binding = FragmentActivityAddBinding.inflate(inflater, container, false)

        val root: View = binding.root

        binding.transportButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = TransportDialog()
                activity?.supportFragmentManager?.let { dialog.show(it, "transport") }
                binding.totalCarbonPrintText.text =
                    "Total carbon print: ${String.format("%.3f", currentUser.carbonPrint)} kg CO2"
            })
        }

        binding.mealButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = MealDialog()
                activity?.supportFragmentManager?.let { dialog.show(it, "meal") }
                binding.totalCarbonPrintText.text =
                    "Total carbon print: ${String.format("%.3f", currentUser.carbonPrint)} kg CO2"
            })
        }

        binding.plasticButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = PlasticDialog()
                activity?.supportFragmentManager?.let { dialog.show(it, "plastic") }
                binding.totalCarbonPrintText.text =
                    "Total carbon print: ${String.format("%.3f", currentUser.carbonPrint)} kg CO2"
            })
        }

        binding.averageTestButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("http://www.footprintcalculator.org/home/en")
                startActivity(openURL)
            })
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ActivityAddViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()
        binding.totalCarbonPrintText.text =
            "Total carbon print: ${String.format("%.3f", currentUser.carbonPrint)} kg CO2"
    }
}
