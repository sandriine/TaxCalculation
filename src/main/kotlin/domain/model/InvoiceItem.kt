package org.taxCalculation.domain.model

import java.math.BigDecimal

data class InvoiceItem(
    private val quantity: Int,
    private val label: String,
    private val ttc: BigDecimal
){
    companion object {
        fun from(product: Product): InvoiceItem {
            return InvoiceItem(
                quantity = 1,
                label = product.getLabel(),
                ttc = product.getTtc()
            )
        }
    }
}
