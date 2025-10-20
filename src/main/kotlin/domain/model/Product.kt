package org.taxCalculation.domain.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Product(
    private val type: ProductType,
    private val ht: BigDecimal? = null,
    private val ttc: BigDecimal? = null,
    private val imported: Boolean = false,
    private val taxAmount: BigDecimal? = null,
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
        val tax = Tax.fromProductTypeAndImported(type, imported)
        val taxAmount = tax.calculateTaxAmount(ht)
            .roundUpToNearestFiveCents()

        val ttc = ht?.add(taxAmount)?.setScale(2, RoundingMode.HALF_UP)

        return Product(
            type = type,
            ht = ht,
            ttc = ttc,
            imported = imported,
            taxAmount = taxAmount
        )
    }

    fun getTaxAmount(): BigDecimal {
        return taxAmount ?: BigDecimal.ZERO
    }

    fun getTtc(): BigDecimal {
        return ttc ?: BigDecimal.ZERO
    }
}
