package com.nitro.spirals

case class Level(value: Long,
                 numberOfElements: Long,
                 firstLocation: Location,
                 lastLocation: Location,
                 numberOfElementsPerQuadrant: Long) {

  override def toString: String =
    s"""
       |Level info:
       |     value: '$value'
       |     numberOfElements: '$numberOfElements'
       |     firstElement: '$firstLocation'
       |     lastElement: '$lastLocation'
       |     numberOfElementsPerQuadrant: '$numberOfElementsPerQuadrant'
       |""".stripMargin

}

object Level {

  def apply(elementValue: Long): Level =
    allLevels.dropWhile(elementValue > _.lastLocation.value).take(1).head

  def apply(value: Long, numberOfElements: Long, lastElementValue: Long): Level =
    new Level(
      value,
      numberOfElements,
      firstLocation(value, numberOfElements, lastElementValue),
      lastLocation(value, lastElementValue),
      (numberOfElements / 4).toInt)

  private def firstLocation(value: Long, numberOfElements: Long, lastElementValue: Long): Location = {
    val previousLevelLastLocation = Location(
      value = lastElementValue - numberOfElements,
      row = value - 1,
      column = value - 1)

    Location(
      value = previousLevelLastLocation.value + 1,
      row = previousLevelLastLocation.row,
      column = previousLevelLastLocation.column + 1)
  }

  private def lastLocation(value: Long, lastElementValue: Long): Location =
    Location(value = lastElementValue, row = value, column = value)

}
