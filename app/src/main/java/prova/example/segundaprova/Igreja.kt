package prova.example.segundaprova

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_igrja")
data class Igreja(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nome:String,
    val endereco:String,
    val profeta:String,
    val descricao:String,
    val fieis:Int
) {
}