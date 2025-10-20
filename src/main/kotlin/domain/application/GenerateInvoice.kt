package org.taxCalculation.domain.application

import org.taxCalculation.domain.model.Invoice
import org.taxCalculation.domain.model.InvoiceItem
import org.taxCalculation.domain.model.Product
import java.math.BigDecimal

class GenerateInvoice (
    private val products: List<Product>
){
    fun generateInvoice(): Invoice {
        val productsWithTtc = products
            .map { it.calculateTtc() }

        val amountTax = productsWithTtc
            .map { it.getTaxAmount() }
            .fold(BigDecimal.ZERO) { acc, tax -> acc + tax }

        val total = productsWithTtc
            .map { it.getTtc() }
            .fold(BigDecimal.ZERO) { acc, ttc -> acc + ttc }

        return Invoice(
            invoiceItems = productsWithTtc.map { InvoiceItem.from(it) },
            amountTax = amountTax,
            total = total
        )
    }
}