package test.factaboutnumber.util

import androidx.recyclerview.widget.DiffUtil
import test.factaboutnumber.model.NumberDetails

object DiffUtil : DiffUtil.ItemCallback<NumberDetails>() {

    override fun areItemsTheSame(oldItem: NumberDetails, newItem: NumberDetails): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NumberDetails, newItem: NumberDetails): Boolean {
        return oldItem.interestFact == newItem.interestFact

    }
}
