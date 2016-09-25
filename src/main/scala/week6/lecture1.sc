val xs = Array(1, 2, 3, 44)
xs map (x => x * 2)

val str = "Hello World"
str filter (c => c.isUpper)

str exists (c => c.isUpper)
str forall (c => c.isUpper)

val pairs = (1 to str.size) zip str
pairs.unzip

str flatMap (c => List('.', c))

xs.sum
xs.max

val r: Range = 1 until 5
val s: Range = 1 to 5
1 to 10 by 3
6 to 1 by -2

def isPrime(n: Int): Boolean = (2 until n).forall(d => n % d != 0)

