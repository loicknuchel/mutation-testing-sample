package org.mutationtesting.demo

import org.scalatest.{FunSpec, Matchers}

class DemoSpec extends FunSpec with Matchers {

  import Demo._

  describe("fizzBuzz") {
    it("should return FizzBuzz on zero") {
      fizzBuzz(0) shouldBe "FizzBuzz"
    }
    it("should return Fizz on three") {
      fizzBuzz(3) shouldBe "Fizz"
    }
    it("should return 4 on four") {
      fizzBuzz(4) shouldBe "4"
    }
    it("should return Buzz on five") {
      fizzBuzz(5) shouldBe "Buzz"
    }
  }

  describe("getPrice") {
    it("should be normal price with few and cheap items") {
      getPrice(Seq(4, 7, 1, 12)) shouldBe 24
    }
    it("should be get 10% discound on expensive items") {
      getPrice(Seq(10, 20, 30)) shouldBe 54
    }
    it("should be get one free item when buy many") {
      getPrice(Seq(3, 5, 2, 8, 1, 4)) shouldBe 22
    }
    it("should test boundary conditions") {
      getPrice(Seq(5, 10, 15, 20)) shouldBe 45 // 50 total value boundary
      getPrice(Seq(7, 8, 15, 10, 10)) shouldBe 43 // 5 item boundary
    }
  }
}
