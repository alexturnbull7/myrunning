package com.alext.myrunning.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.alext.myrunning.R
import com.alext.myrunning.databinding.RunSplitsBinding
import com.alext.myrunning.utils.getViewModel
import com.alext.myrunning.viewmodel.RunSplitsViewModel
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.*
import kotlinx.android.synthetic.main.run_splits.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RunSplitsFragment : Fragment() {

    private lateinit var vm: RunSplitsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vm = getViewModel()

        return RunSplitsBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = activity
            viewModel = vm
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBindings(view)
    }

    private fun setupBindings(view: View) {
        view.findViewById<RadioGroup>(R.id.distanceRadio)?.checkedChanges()?.subscribe({
            if (it > 0) vm.selectedDistance.postValue(BigDecimal.valueOf(26.2))
        }) {
            error("error attaching binding to radio group")
        }

        hours.textChanges()?.subscribe({
            if (!it.isNullOrBlank()) vm.selectedHours.postValue(BigDecimal(it.toString()))
        }) {
            error("error attaching binding to text field")
        }

        minutes.textChanges()?.subscribe({
            if (!it.isNullOrBlank()) vm.selectedMinutes.postValue(BigDecimal(it.toString()))
        }) {
            error("error attaching binding to text field")
        }

        seconds.textChanges()?.subscribe({
            if (!it.isNullOrBlank()) vm.selectedSeconds.postValue(BigDecimal(it.toString()))
        }) {
            error("error attaching binding to text field")
        }

        calculateButton.clicks().subscribe ({
            vm.calculatePace()
        }) {
            error("error calculating pace")
        }


    }
}
