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
  val product = Product.from(ProductType.OTHER, BigDecimal("12.49"), null)

  val result = product.calculateHt()

  assertEquals(result, Product.from(
   ProductType.BOOK,
   BigDecimal("14.99"),
   BigDecimal("1.5")
  ))
 }

 @Test
 fun `should calculate tax for book product`() {
  val book = Product.from(ProductType.OTHER, BigDecimal("12.49"), null)

  val result = book.calculateHt()

  assertEquals(result, Product.from(
   ProductType.BOOK,
   BigDecimal("12.49"),
   BigDecimal("0")
  ))
 }
}