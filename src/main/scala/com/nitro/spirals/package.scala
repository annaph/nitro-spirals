package com.nitro

import scala.util.{Failure, Success, Try}

package object spirals {

  // count - number of elements in the Level; last - value of the last element in the Level
  type CountAndLast = (Int, Int)

  val allLevels: LazyList[Level] = {

    def scanCounters(prevCountAndLast: CountAndLast, count: Int): CountAndLast = {
      val (_, last) = prevCountAndLast
      count -> (count + last)
    }

    def toLevel(countAndLast: CountAndLast, i: Int): Level = {
      val (count, last) = countAndLast
      Level(
        value = i,
        numberOfElements = count,
        lastElementValue = last)
    }

    LazyList
      .from(2) // 2,3,4,...
      .filter(_ % 2 == 1) // 3,5,7,...
      .map(x => 4 * (x - 1)) // 8,16,24,...
      .scanLeft(1 -> 1)(scanCounters) // (1,1),(8,9),(16,25)
      .zipWithIndex // (1,1) -> 0, (8,9) -> 1, (16,25) -> 2
      .map {
        case (countAndLast, index) =>
          toLevel(countAndLast, index)
      }
  }

  def extractElementValue(args: Array[String]): Long =
    Try(args(0).toLong)
    match {
      case Success(elementValue) if elementValue > 0 =>
        elementValue
      case Success(_) =>
        throw new Exception("Value must be greater than 0!")
      case Failure(e) =>
        throw new Exception("Error extracting value!", e)
    }

}
