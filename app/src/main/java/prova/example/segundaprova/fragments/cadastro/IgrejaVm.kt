package prova.example.segundaprova.fragments.cadastro

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import prova.example.segundaprova.Igreja
import prova.example.segundaprova.banco.IgrejaDataBase
import prova.example.segundaprova.banco.IgrejaRepository

class IgrejaVm (application: Application):AndroidViewModel(application){

private val readAllData:LiveData<List<Igreja>>
private val repository: IgrejaRepository
init {
    val igrejaDao= IgrejaDataBase.getDatabase(application).userDao()
    repository = IgrejaRepository(igrejaDao)
    readAllData=repository.readAllData
}
    fun cadastraIgreja(igreja: Igreja){
        viewModelScope.launch (Dispatchers.IO) {
            repository.cadastraIgreja(igreja)
        }

    }


}