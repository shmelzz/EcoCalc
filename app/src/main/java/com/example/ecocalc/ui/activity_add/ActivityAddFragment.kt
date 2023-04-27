package com.example.ecocalc.ui.activity_add

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ecocalc.data.user.UserDao
import com.example.ecocalc.data.user.UserDatabase
import com.example.ecocalc.data.user.currentUser
import com.example.ecocalc.databinding.FragmentActivityAddBinding
import com.example.ecocalc.ui.dialog.AddedActivitiesDialog
import com.example.ecocalc.ui.activity_add.meal.MealDialog
import com.example.ecocalc.ui.activity_add.meal.MealDialogViewModel
import com.example.ecocalc.ui.activity_add.plastic.PlasticDialog
import com.example.ecocalc.ui.activity_add.plastic.PlasticDialogViewModel
import com.example.ecocalc.ui.activity_add.transport.TransportDialog
import com.example.ecocalc.ui.activity_add.transport.TransportDialogViewModel

class ActivityAddFragment : Fragment() {

    private var _binding: FragmentActivityAddBinding? = null

    private val binding get() = _binding!!

    private lateinit var userDao: UserDao

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActivityAddBinding.inflate(inflater, container, false)

        val root: View = binding.root
        userDao = UserDatabase.getDataBase(requireActivity().application).userDao()

        binding.transportButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = TransportDialog(
                    TransportDialogViewModel(userDao)
                )
                activity?.supportFragmentManager?.let { dialog.show(it, "transport") }
            })
        }

        binding.mealButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = MealDialog(
                    MealDialogViewModel(userDao)
                )
                activity?.supportFragmentManager?.let { dialog.show(it, "meal") }
            })
        }

        binding.plasticButton.apply {
            setOnClickListener(View.OnClickListener { view ->
                val dialog = PlasticDialog(
                    PlasticDialogViewModel(userDao)
                )
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
