package prova.example.segundaprova.banco

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import prova.example.segundaprova.Igreja

@Dao
interface IgrejaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)

    suspend fun cadastraIgreja(igreja: Igreja)

@Query("SELECT* FROM tabela_igrja ORDER BY id ASC")
    fun readAllData(): LiveData<List<Igreja>>
}