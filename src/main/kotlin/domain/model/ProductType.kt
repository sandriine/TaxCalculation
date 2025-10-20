package org.taxCalculation.domain.model

import java.math.BigDecimal

enum class ProductType(val tax: Int) {
    FOOD(0),
    BOOK(0),
    DRUG(0),
    OTHER(10);

    companion object {
        fun getTax(type: ProductType): Int = type.tax
    }
}