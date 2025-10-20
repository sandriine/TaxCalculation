package org.taxCalculation.domain.model

import java.math.BigDecimal

data class Product(
    private val type: ProductType,
    private val ht: BigDecimal? = null,
    private val ttc: BigDecimal? = null,
){
    companion object {
        fun from(type: ProductType, ttc: BigDecimal, ht: BigDecimal?): Product {
            return Product(
                type = type,
                ttc = ttc,
                ht = ht
            )
        }
    }

    fun calculateHt(): Product {
        return Product(
            type = type,
            ttc = ttc,
        )
    }
}
