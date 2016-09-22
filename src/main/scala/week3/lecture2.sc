/** How classes are organized*/
/**Organizing our code with import statements*/

//import week3.Rational             // <- Named import
//import week3.{Rational, Hello}  // <- imports specific objects/classes Named import
//import week3._                  // <- imports everything Wildcard import

//new week3.Rational(1,2)   // <- creating an object using explicit package naming
//new week3.Rational(1,2)

/**Error Handling example*/
def error(msg: String): Nothing = throw new Error(msg)

/**Returns a Nothing type, halting all execution below*/
//error("test")

val x = null
val y: String = x

/**What is the value of this expression*/

val exp = if (true) 1 else false







