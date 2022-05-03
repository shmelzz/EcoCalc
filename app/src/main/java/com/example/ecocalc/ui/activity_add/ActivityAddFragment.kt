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
import com.example.ecocalc.ui.dialog.AddedActivitiesDialog
import com.example.ecocalc.ui.dialog.MealDialog
import com.example.ecocalc.ui.dialog.PlasticDialog
import com.example.ecocalc.ui.dialog.TransportDialog
import javax.net.ssl.ManagerFactoryParameters

class ActivityAddFragment : Fragment() {

    private var _binding: FragmentActivityAddBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActivityAddBinding.inflate(inflater, container, false)

        val root: View = binding.root

        binding.transportButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = TransportDialog()
                activity?.supportFragmentManager?.let { dialog.show(it, "transport") }
            })
        }

        binding.mealButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = MealDialog()
                activity?.supportFragmentManager?.let { dialog.show(it, "meal") }
            })
        }

        binding.plasticButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = PlasticDialog()
                activity?.supportFragmentManager?.let { dialog.show(it, "plastic") }
            })
        }

        binding.averageTestButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("http://www.footprintcalculator.org/home/en")
                startActivity(openURL)
            })
        }

        binding.mealAddedButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = AddedActivitiesDialog("MEAL")
                activity?.supportFragmentManager?.let { dialog.show(it, "added meals") }
            })
        }

        binding.transportAddedButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = AddedActivitiesDialog("TRANSPORT")
                activity?.supportFragmentManager?.let { dialog.show(it, "added transport") }
            })
        }

        binding.plasticAddedButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = AddedActivitiesDialog("PLASTIC")
                activity?.supportFragmentManager?.let { dialog.show(it, "added plastic") }
            })
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        binding.totalCarbonPrintText.text =
            "Total carbon print: ${String.format("%.3f", currentUser.carbonPrint)} kg CO2"
    }
}
