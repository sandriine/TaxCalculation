package domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.taxCalculation.domain.model.Product
import org.taxCalculation.domain.model.ProductType
import java.math.BigDecimal

class ProductTest (

) {

 @Test
 fun `should calculate ttc for other product`() {
  val product = Product.from(
   type = ProductType.OTHER,
   ht = BigDecimal("14.99"),
   ttc= null)

  val result = product.calculateTtc()

  assertEquals(result, Product.from(
   type = ProductType.OTHER,
   ht = BigDecimal("14.99"),
   ttc = BigDecimal("16.49")
  ))
 }

 @Test
 fun `should calculate ttc for book product`() {
  val book = Product.from(
   type = ProductType.BOOK,
   ht = BigDecimal("12.49"),
   ttc = null)

  val result = book.calculateTtc()

  assertEquals(result, Product.from(
   ProductType.BOOK,
   BigDecimal("12.49"),
   BigDecimal("12.49")
  ))
 }

 @Test
 fun `should calculate ttc for food product`() {
  val book = Product.from(
   type = ProductType.FOOD,
   ht = BigDecimal("0.85"),
   ttc = null)

  val result = book.calculateTtc()

  assertEquals(result, Product.from(
   ProductType.FOOD,
   BigDecimal("0.85"),
   BigDecimal("0.85")
  ))
 }

 @Test
 fun `should calculate ttc for drug product`() {
  val book = Product.from(
   type = ProductType.DRUG,
   ht = BigDecimal("9.75"),
   ttc = null)

  val result = book.calculateTtc()

  assertEquals(result, Product.from(
   ProductType.DRUG,
   BigDecimal("9.75"),
   BigDecimal("9.75")
  ))
 }

 @Test
 fun `should calculate ttc for other product imported`() {
  val product = Product.from(
   type = ProductType.OTHER,
   ht = BigDecimal("47.50"),
   ttc = null,
   imported = true)

  val result = product.calculateTtc()

  assertEquals(result, Product.from(
   type = ProductType.OTHER,
   ht = BigDecimal("47.50"),
   ttc = BigDecimal("54.65"),
   imported = true
  ))
 }

 @Test
 fun `should calculate ttc for food product imported`() {
  val product = Product.from(
   type = ProductType.FOOD,
   ht = BigDecimal("10"),
   ttc = null,
   imported = true)

  val result = product.calculateTtc()

  assertEquals(result, Product.from(
   type = ProductType.FOOD,
   ht = BigDecimal("10"),
   ttc = BigDecimal("10.50"),
   imported = true
  ))
 }
}