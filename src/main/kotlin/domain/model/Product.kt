package org.taxCalculation.domain.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Product(
    private val type: ProductType,
    private val ht: BigDecimal? = null,
    private val ttc: BigDecimal? = null,
    private val imported: Boolean = false,
){
    companion object {
        fun from(type: ProductType, ttc: BigDecimal?, ht: BigDecimal?, imported: Boolean = false): Product {
            return Product(
                type = type,
                ttc = ttc,
                ht = ht,
                imported = imported,
            )
        }
    }

    fun calculateTtc(): Product {
        val tax = BigDecimal(ProductType.getTax(type))
        val ttc = ht?.add(ht.multiply(tax).divide(BigDecimal(100)))?.setScale(2, RoundingMode.HALF_UP)

        return Product(
            type = type,
            ht = ht,
            ttc = ttc
        )
    }
}
