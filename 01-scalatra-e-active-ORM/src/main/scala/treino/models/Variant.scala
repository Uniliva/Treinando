package treino.models

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion}

case class Variante(tamanho:String, cor:String) extends ActiveRecord{
  val produtoId: Long = 0
  lazy val produto = belongsTo[Produto]
}
object Variante extends ActiveRecordCompanion[Variante]