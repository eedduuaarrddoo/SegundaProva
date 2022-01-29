package prova.example.segundaprova.banco

import androidx.lifecycle.LiveData
import prova.example.segundaprova.Igreja

class IgrejaRepository(private val igrejaDao: IgrejaDao) {

    val readAllData: LiveData<List<Igreja>> = igrejaDao.readAllData()
suspend fun cadastraIgreja(igreja: Igreja){
    igrejaDao.cadastraIgreja(igreja)
}
}