package org.mutationtesting.demo

import org.scalatest.{FunSpec, Matchers}

class CartSpec extends FunSpec with Matchers {
  describe("Cart") {
    it("has no assert") {
      new Cart(3).add("shoes")
    }

    it("has irrelevant assert") {
      new Cart(3).add("shoes") shouldBe false
    }

    it("asserts few things") {
      val cart = new Cart(3)
      cart.add("shoes")
      cart.items.length shouldBe 1
    }
  }
}
