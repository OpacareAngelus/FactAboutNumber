package test.factaboutnumber.activity.fragmentEnterNumber.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import test.factaboutnumber.R
import test.factaboutnumber.activity.fragmentEnterNumber.FragmentEnterNumber
import test.factaboutnumber.activity.fragmentEnterNumber.FragmentEnterNumberDirections
import test.factaboutnumber.databinding.RecyclerviewItemFoundedLogBinding
import test.factaboutnumber.model.NumberDetails
import test.factaboutnumber.util.DiffUtil

class RecyclerAdapterNumbersList(
    private val numbersListController : FragmentEnterNumber
) :
    ListAdapter<NumberDetails, RecyclerAdapterNumbersList.ViewHolder>(DiffUtil) {

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_founded_log, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            RecyclerviewItemFoundedLogBinding.bind(itemView).run {
                val number = currentList[position]
                tvNumber.text = number.number
                tvInterestFact.text = number.interestFact

                containerItem.setOnClickListener{
                    numbersListController.openDetails(number)
                }
            }
        }
    }

    interface NumbersListController{
        fun openDetails(number: NumberDetails)
    }
}

