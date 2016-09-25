import javax.script.Bindings

val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
val capitalOfCountry = Map("US" -> "Washington D.C.","Switzerland" -> "Bern")

capitalOfCountry get "andorra"
capitalOfCountry get "US"

class Polynomial(val terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue 0.0
  //  def + (other: Polynomial) = new Polynomial(terms ++ (other.terms map adjust))
  def + (other: Polynomial) = new Polynomial((other.terms foldLeft terms)(addTerm))
  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    exp -> (coeff + terms(exp))
//    terms get exp match {
//      case Some(coeff1) => exp -> (coeff + coeff1)
//      case None => exp -> coeff
//    }
  }
  def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }
  override def toString =
    (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff+"x^"+exp) mkString " + "
}

//val p1 = new Polynomial(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
//val p2 = new Polynomial(Map(0 -> 3.0, 3 -> 7.0))
val p1 = new Polynomial(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
val p2 = new Polynomial(0 -> 3.0, 3 -> 7.0)
p1 + p2
p1.terms(7)

