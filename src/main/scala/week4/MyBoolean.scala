package week4

/**
  * Created by Tom on 9/7/2016.
  */

//abstract class Boolean {
//  def ifThenElse[T](t: => T, e: => T): T
//
//  def && (x: => Boolean): Boolean = ifThenElse(x, false)
//  def || (x: => Boolean): Boolean = ifThenElse(true, x)
//  def unary_! :Boolean = ifThenElse(false, true)
//
//  def == (x: => Boolean): Boolean = ifThenElse(x, unary_!)
//  def != (x: => Boolean): Boolean = ifThenElse(unary_!, x)
//
//  def < (x: => Boolean): Boolean = ifThenElse(false, x)
//}
//
//object true extends Boolean {
//  def ifThenElse[T](t: => T, e: => T) = t
//}
//
//object false extends Boolean {
//  def ifThenElse[T] (t: => T, e: => T) = e
//}
