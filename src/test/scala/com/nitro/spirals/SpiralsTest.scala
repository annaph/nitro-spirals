package com.nitro.spirals

import com.nitro.spirals.Spirals.findLocation
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SpiralsTest extends AnyFlatSpec with Matchers {

  "findLocation" should "find Location(value = 1, row = 0, column = 0)" in {
    // given
    val elementValue = 1
    val expected = Location(value = 1, row = 0, column = 0)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 2, row = 0, column = 1)" in {
    // given
    val elementValue = 2
    val expected = Location(value = 2, row = 0, column = 1)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 3, row = -1, column = 1)" in {
    // given
    val elementValue = 3
    val expected = Location(value = 3, row = -1, column = 1)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 5, row = -1, column = -1)" in {
    // given
    val elementValue = 5
    val expected = Location(value = 5, row = -1, column = -1)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 6, row = 0, column = -1)" in {
    // given
    val elementValue = 6
    val expected = Location(value = 6, row = 0, column = -1)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 7, row = 1, column = -1)" in {
    // given
    val elementValue = 7
    val expected = Location(value = 7, row = 1, column = -1)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 8, row = 1, column = 0)" in {
    // given
    val elementValue = 8
    val expected = Location(value = 8, row = 1, column = 0)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 9, row = 1, column = 1)" in {
    // given
    val elementValue = 9
    val expected = Location(value = 9, row = 1, column = 1)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 10, row = 1, column = 2)" in {
    // given
    val elementValue = 10
    val expected = Location(value = 10, row = 1, column = 2)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 12, row = -1, column = 2)" in {
    // given
    val elementValue = 12
    val expected = Location(value = 12, row = -1, column = 2)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 23, row = 2, column = 0)" in {
    // given
    val elementValue = 23
    val expected = Location(value = 23, row = 2, column = 0)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 1024, row = -16, column = -15)" in {
    // given
    val elementValue = 1024
    val expected = Location(value = 1024, row = -16, column = -15)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

  it should "find Location(value = 368078, row = 303, column = -68)" in {
    // given
    val elementValue = 368078
    val expected = Location(value = 368078, row = 303, column = -68)

    // when
    val actual = findLocation(elementValue)

    // then
    actual shouldBe expected
  }

}
