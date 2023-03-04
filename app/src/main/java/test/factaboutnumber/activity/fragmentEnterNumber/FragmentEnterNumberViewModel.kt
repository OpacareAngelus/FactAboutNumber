package test.factaboutnumber.activity.fragmentEnterNumber

import NetworkService.requestAPI
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import test.factaboutnumber.NumbersDetailDb
import test.factaboutnumber.model.NumberDetails
import test.factaboutnumber.remote.response.InterestFactResponse

class FragmentEnterNumberViewModel : ViewModel() {

    lateinit var db: NumbersDetailDb

    private val _numbersFact = MutableLiveData<List<NumberDetails>>()
    val numbersFact: LiveData<List<NumberDetails>> = _numbersFact

    fun initDB() {
        viewModelScope.launch(Dispatchers.IO) {
            _numbersFact.postValue(db.getDao().getAllNumbers())
        }
    }


    fun requestInterestFact(number: String) {
        viewModelScope.launch {
            try {
                val response = requestAPI.getFactAboutNumber(
                    number
                )
                saveDataAboutNewNumber(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun requestRandomNumberFact(){
        viewModelScope.launch {
            try {
                val response = requestAPI.getFactAboutRandomNumber()
                saveDataAboutNewNumber(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun saveDataAboutNewNumber(response: InterestFactResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            val numberDetails = NumberDetails(
                null, response.number.toString(), response.text
            )
            _numbersFact.postValue(_numbersFact.value?.plus(numberDetails))
            db.getDao().insertNumber(numberDetails)
        }
    }
}