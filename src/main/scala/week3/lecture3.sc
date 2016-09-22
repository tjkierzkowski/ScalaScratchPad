import week3._

import scala.annotation.tailrec

def singleton[T](elem: T): List[T] = new Cons[T](elem, new Nil[T])

singleton(1)

def nth[T](n: Int, list: List[T]): T = {
  if (list.isEmpty) throw new IndexOutOfBoundsException
  else if (n == 0) list.head
  else nth(n - 1, list.tail)
}

val test = new Cons(1, new Cons(2, new Cons(3, new Nil)))
assert(nth(2, test) == 3)
nth(-2, test)
