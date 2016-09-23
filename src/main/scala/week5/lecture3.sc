import math.Ordering
/*
def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs splitAt n
    merge(msort(fst)(lt), msort(snd)(lt))
  }
}

//Testing out the merge sort
val numbers = List (2, -4, 5, 7, 1)
val fruits = List("apple", "pineapple", "orange", "banana")
msort(numbers)((x, y) => x < y)
msort(fruits)((x, y) => x.compareTo(y) < 0)
  */

/*
def msort[T](xs: List[T])(order: Ordering[T]): List[T] = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (order.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs splitAt n
    merge(msort(fst)(order), msort(snd)(order))
  }
}

//Testing out the merge sort
val numbers = List (2, -4, 5, 7, 1)
val fruits = List("apple", "pineapple", "orange", "banana")
msort(numbers)(Ordering.Int)
msort(fruits)(Ordering.String)
*/

def msort[T](xs: List[T])(implicit order: Ordering[T]): List[T] = {
  val n = xs.length/2
  if (n == 0) xs
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (order.lt(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
    val (fst, snd) = xs splitAt n
    merge(msort(fst), msort(snd))
  }
}

//Testing out the merge sort
val numbers = List (2, -4, 5, 7, 1)
val fruits = List("apple", "pineapple", "orange", "banana")
msort(numbers)
msort(fruits)


