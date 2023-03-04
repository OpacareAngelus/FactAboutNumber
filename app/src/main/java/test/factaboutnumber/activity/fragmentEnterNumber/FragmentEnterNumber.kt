package test.factaboutnumber.activity.fragmentEnterNumber

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import architecture.BaseFragment
import test.factaboutnumber.NumbersDetailDb
import test.factaboutnumber.R
import test.factaboutnumber.activity.fragmentEnterNumber.adapter.RecyclerAdapterNumbersList
import test.factaboutnumber.databinding.FragmentEnterNumberBinding
import test.factaboutnumber.model.NumberDetails

class FragmentEnterNumber :
    BaseFragment<FragmentEnterNumberBinding>(FragmentEnterNumberBinding::inflate) {

    private val viewModel: FragmentEnterNumberViewModel by viewModels()

    private val usersAdapter by lazy {
        RecyclerAdapterNumbersList(
            numbersListController = this
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRoom()
        setAdapter()
        setListeners()
        setObserver()
    }

    private fun setListeners() {
        with(binding) {

            btnFindFactAboutNumber.setOnClickListener {
                if (etEnterNumber.text.isNullOrEmpty()) {
                    etEnterNumber.error = getString(R.string.et_enter_number)
                } else viewModel.requestInterestFact(etEnterNumber.text.toString())
            }

            btnFindRandomFact.setOnClickListener {
                viewModel.requestRandomNumberFact()
            }
        }
    }

    private fun setAdapter() {
        val recyclerView: RecyclerView = binding.rvFoundedNumbers.apply { adapter = usersAdapter }
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
    }

    private fun initRoom() {
        viewModel.db = NumbersDetailDb.getDb(requireActivity())
        viewModel.initDB()
    }

    private fun setObserver() {
        viewModel.numbersFact.observe(viewLifecycleOwner) {
            usersAdapter.submitList(it.reversed())
        }
    }

    fun openDetails(number: NumberDetails) {
        findNavController().navigate(
            FragmentEnterNumberDirections.actionFragmentEnterNumberToFragmentInterestFact(
                number
            )
        )
    }
}