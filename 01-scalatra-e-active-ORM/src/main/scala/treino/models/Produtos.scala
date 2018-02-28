package treino.models

import com.github.aselab.activerecord._

case class Produto(nome:String, comentario:String)extends ActiveRecord{
  lazy val variant = hasMany[Variante]
}

object Produto extends ActiveRecordCompanion[Produto]




