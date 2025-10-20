package org.taxCalculation.domain.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Product(
    private val type: ProductType,
    private val ht: BigDecimal? = null,
    private val ttc: BigDecimal? = null,
    private val imported: Boolean = false,
    private val label: String = "",
){
    companion object {
        fun from(type: ProductType, ttc: BigDecimal?, ht: BigDecimal?, imported: Boolean = false, label: String = ""): Product {
            return Product(
                type = type,
                ttc = ttc,
                ht = ht,
                imported = imported,
                label = label,
            )
        }
    }

    fun calculateTtc(): Product {
        val taxAmount = getTaxAmount()

        val ttc = ht?.add(taxAmount)?.setScale(2, RoundingMode.HALF_UP)

        return Product(
            type = type,
            ht = ht,
            ttc = ttc,
            imported = imported,
            label = label
        )
    }

    fun getTaxAmount(): BigDecimal {
        return Tax
            .fromProductTypeAndImported(type, imported)
            .calculateTaxAmount(ht)
            .roundUpToNearestFiveCents()
    }

    fun getTtc(): BigDecimal {
        return ttc ?: BigDecimal.ZERO
    }

    fun getLabel(): String {
        return label ?: ""
    }
}
