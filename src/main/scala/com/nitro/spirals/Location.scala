package com.nitro.spirals

import scala.math.abs

case class Location(value: Long, row: Long, column: Long) {

  lazy val distance: Long = abs(row) + abs(column)

  override def toString: String =
    s"Location(value = $value, row = $row, column = $column)"

}
