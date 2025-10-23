package infra

import org.junit.jupiter.api.Assertions.*
import org.taxCalculation.domain.model.Invoice
import org.taxCalculation.domain.model.InvoiceItem
import org.taxCalculation.infra.InvoiceView
import java.math.BigDecimal
import kotlin.test.Test

class InvoiceViewTest {
     @Test
     fun `should map invoice to invoice view`() {
         val invoiceItems = listOf(
             InvoiceItem(label = "livre", quantity = 1, ttc = BigDecimal("12.49")),
             InvoiceItem(label = "CD musical", quantity = 1, ttc = BigDecimal("16.49")),
             InvoiceItem(label = "barre de chocolat", quantity = 1, ttc = BigDecimal("0.85"))
         )

         val invoice = Invoice(
             invoiceItems = invoiceItems,
             amountTax = BigDecimal("1.50"),
             total = BigDecimal("29.83")
         )

         val result = InvoiceView.from(invoice)

         val expectedResult =
             "1 livre : 12.49, 1 CD musical : 16.49, 1 barre de chocolat : 0.85 Montant des taxes : 1.50 Total : 29.83"

         assertEquals(expectedResult, result.getResult())
     }
 }