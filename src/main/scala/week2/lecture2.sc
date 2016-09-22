def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  }
  sumF
}

def sumInts =  sum(x => x)
def sumCubes = sum(x => x * x * x)

sumCubes(1, 10)

////Original product function
//def product(f: Int => Int)(a: Int, b: Int): Int =
//  if (a > b) 1
//  else f(a) * product(f)(a + 1, b)
//
//product(x => x * x)(3, 4)

//Generalized function
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
if (a > b) zero
else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

def product(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)

product(x => x * x)(3, 4)

//Composable function
def factorial(f: Int => Int)(a: Int, b: Int): Int =
  if (a == 0) 1
  else product(f)(a + 1, b)

//Curried Function! A function (fact) in terms of another function (product)!
def fact(n: Int) = product(x => x)(1, n)

//Tests for our factorials
var num = 6
assert(factorial(x => x)(1,num) == fact(num))


