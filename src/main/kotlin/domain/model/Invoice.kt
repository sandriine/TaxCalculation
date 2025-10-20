package org.taxCalculation.domain.model

import java.math.BigDecimal

data class Invoice(
    private val products: List<Product>,
    private val amountTax: BigDecimal,
    private val total: BigDecimal,
)
