package org.mutationtesting.demo

import scala.collection.mutable

class Cart(size: Int) {
  val items = mutable.ArrayBuffer[String]()

  def add(item: String): Boolean = {
    println(s"item add: $item")
    val exists = items.contains(item)
    if (items.length < size) {
      items.append(item)
    }
    exists
  }
}
