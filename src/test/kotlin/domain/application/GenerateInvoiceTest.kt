package domain.application

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.taxCalculation.domain.application.GenerateInvoice
import org.taxCalculation.domain.model.Invoice
import org.taxCalculation.domain.model.Product
import org.taxCalculation.domain.model.ProductType
import java.math.BigDecimal

class GenerateInvoiceTest {

 @Test
 fun `should generate invoice for products`() {
  val products = listOf(
   Product(type = ProductType.BOOK, ht = BigDecimal("12.49")),
   Product(type = ProductType.OTHER, ht = BigDecimal("14.99")),
   Product(type = ProductType.FOOD, ht = BigDecimal("0.85")),
  )

  val generate = GenerateInvoice(products)

  val invoice = generate.generateInvoice()

  assertEquals(invoice, Invoice(
   products = products,
   amountTax = BigDecimal("1.50"),
   total = BigDecimal("29.83")
  )
  )
 }
}