package org.taxCalculation.domain.model

import java.math.BigDecimal

data class Invoice(
    private val invoiceItems: List<InvoiceItem>,
    private val amountTax: BigDecimal,
    private val total: BigDecimal,
)
