package test.factaboutnumber.activity.fragmentEnterNumber.fragmentInterestFact

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import architecture.BaseFragment
import test.factaboutnumber.activity.fragmentEnterNumber.FragmentEnterNumberArgs
import test.factaboutnumber.databinding.FragmentInterestFactBinding

class FragmentInterestFact :
    BaseFragment<FragmentInterestFactBinding>(FragmentInterestFactBinding::inflate) {

    private val viewModel: FragmentInterestFactViewModel by viewModels()
    private val args: FragmentEnterNumberArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
        setListeners()
    }

    private fun setData() {
        with(binding) {
            tvNumber.text = args.number.number
            tvInterestFact.text = args.number.interestFact
        }
    }

    private fun setListeners() {
        with(binding) {
            btnArrow.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}