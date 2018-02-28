package treino.models

import com.github.aselab.activerecord._
import com.github.aselab.activerecord.dsl._

object Tables extends ActiveRecordTables {
  val produtos = table[Produto]
  val variante = table[Variante]
}