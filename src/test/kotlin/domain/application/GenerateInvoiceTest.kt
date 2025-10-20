package domain.application

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.taxCalculation.domain.application.GenerateInvoice
import org.taxCalculation.domain.model.Invoice
import org.taxCalculation.domain.model.InvoiceItem
import org.taxCalculation.domain.model.Product
import org.taxCalculation.domain.model.ProductType
import java.math.BigDecimal

class GenerateInvoiceTest {

 @Test
 fun `should generate invoice for products`() {
  val products = listOf(
   Product(type = ProductType.BOOK, ht = BigDecimal("12.49"), label = "livre"),
   Product(type = ProductType.OTHER, ht = BigDecimal("14.99"), label = "CD musical"),
   Product(type = ProductType.FOOD, ht = BigDecimal("0.85"), label = "barre de chocolat"),
  )
  val generate = GenerateInvoice(products)

  val invoice = generate.generateInvoice()

  val expectedInvoiceItems = listOf(
   InvoiceItem(
    quantity = 1,
    label = "livre",
    ttc = BigDecimal("12.49"),
   ),
   InvoiceItem(
    quantity = 1,
    label = "CD musical",
    ttc = BigDecimal("16.49"),
   ),
   InvoiceItem(
    quantity = 1,
    label = "barre de chocolat",
    ttc = BigDecimal("0.85"),
   )
  )

  assertEquals(invoice, Invoice(
   invoiceItems = expectedInvoiceItems,
   amountTax = BigDecimal("1.50"),
   total = BigDecimal("29.83")
  )
  )
 }
}