package domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.taxCalculation.domain.model.Product
import org.taxCalculation.domain.model.ProductType
import java.math.BigDecimal
import kotlin.test.expect

class ProductTest (

) {

 @Test
 fun `should calculate tax for other product`() {
  val product = Product.from(ProductType.OTHER, BigDecimal("14.99"), null)

  val result = product.calculateHt()

  assertEquals(result, Product.from(
   ProductType.OTHER,
   BigDecimal("14.99"),
   BigDecimal("13.49")
  ))
 }

 @Test
 fun `should calculate tax for book product`() {
  val book = Product.from(ProductType.BOOK, BigDecimal("12.49"), null)

  val result = book.calculateHt()

  assertEquals(result, Product.from(
   ProductType.BOOK,
   BigDecimal("12.49"),
   BigDecimal("12.49")
  ))
 }

 @Test
 fun `should calculate tax for food product`() {
  val book = Product.from(ProductType.FOOD, BigDecimal("0.85"), null)

  val result = book.calculateHt()

  assertEquals(result, Product.from(
   ProductType.FOOD,
   BigDecimal("0.85"),
   BigDecimal("0.85")
  ))
 }

 @Test
 fun `should calculate tax for drug product`() {
  val book = Product.from(ProductType.DRUG, BigDecimal("9.75"), null)

  val result = book.calculateHt()

  assertEquals(result, Product.from(
   ProductType.DRUG,
   BigDecimal("9.75"),
   BigDecimal("9.75")
  ))
 }
}