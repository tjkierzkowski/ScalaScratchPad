//trait Expr
trait Expr {
  def eval: Int = this match {
    case Number(n) => n
    case Sum(e1,  e2) => e1.eval + e2.eval
  }

}
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Var(x: String) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

def eval(e: Expr): Int = e match {
  case Number(n) => n
  case Sum(e1, e2) => eval(e1) + eval(e2)
}
/** Implement the show expression
  * */
def show(e: Expr): String = e match {
  case Var(x) => x
  case Number(n) => n.toString
  case Prod(e1, e2) => show(e1) + " * " + show(e2)
  case Sum(e1, e2) =>"(" + show(e1) + " + " + show(e2) + ")"

}
eval(Sum(Number(1),Number(2)))
show(Sum(Number(1), Number(2)))
show(Prod(Sum( Number(2), Var("x")), Var("y")))
assert(show(Prod(Sum( Number(2), Var("x")), Var("y"))) == "(2 + x) * y")
show(Sum(Prod(Number(2), Var("x")), Var("y")))
assert(show(Sum(Prod(Number(2), Var("x")), Var("y"))) == "2 * x + y")



