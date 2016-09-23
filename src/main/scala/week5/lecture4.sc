def squareListMatch(xs: List[Int]): List[Int] =
  xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareListMatch(ys)
  }

def squareListMap(xs: List[Int]): List[Int] =
  xs map (x => x * x)

//Some Higher Order List functions in List
val nums = List (2, -4, 5, 7, 1)
val fruits = List("apple", "pineapple", "orange", "banana")

nums filter (x => x > 0)
nums filterNot(x => x > 0)
assert(nums.filterNot(x => x > 0) == nums.filter(x => x < 0))

nums partition (x => x > 0)   //Returns 2 lists in one traversal!

nums takeWhile (x => x > 0)
nums dropWhile (x => x > 0)

nums span (x => x > 0)


def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (first, rest) = xs span (y => y == x)
    first :: pack(rest)
}

def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs) map (ys => (ys.head, ys.length))

assert( pack(List("a", "a", "a", "b", "c", "c", "a")) ==
  List(List("a", "a", "a"), List("b"), List("c", "c"), List("a")))

assert( encode(List("a", "a", "a", "b", "c", "c", "a")) ==
  List(("a", 3), ("b", 1), ("c", 2), ("a", 1)))
