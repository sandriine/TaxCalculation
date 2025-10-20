package org.taxCalculation.domain.application

import org.taxCalculation.domain.model.Invoice
import org.taxCalculation.domain.model.Product
import java.math.BigDecimal

class GenerateInvoice (
    val products: List<Product>
){

    fun generateInvoice(): Invoice {
        return Invoice(
            products = products,
            amountTax = BigDecimal.ZERO,
            total = BigDecimal.ZERO
        )
    }
}