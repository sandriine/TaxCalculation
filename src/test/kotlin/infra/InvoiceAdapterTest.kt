package infra

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.taxCalculation.domain.model.Product
import org.taxCalculation.domain.model.ProductType
import org.taxCalculation.infra.InvoiceAdapter
import java.math.BigDecimal

class InvoiceAdapterTest {

  @Test
  fun `should map domain invoice to view correctly`() {
   val invoiceAdapter = InvoiceAdapter()
   val products = listOf(
    Product(type = ProductType.BOOK, ht = BigDecimal("12.49"), label = "livre"),
    Product(type = ProductType.OTHER, ht = BigDecimal("14.99"), label = "CD musical"),
    Product(type = ProductType.FOOD, ht = BigDecimal("0.85"), label = "barre de chocolat"),
   )

   val result = invoiceAdapter.getInvoice(products)

   val expectedOutput = "1 livre : 12.49, 1 CD musical : 16.49, 1 barre de chocolat : 0.85 Montant des taxes : 1.50 Total : 29.83"

   assertEquals(expectedOutput, result.getResult())
  }
 }