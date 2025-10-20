package org.taxCalculation.domain.model

import java.math.BigDecimal
import java.math.RoundingMode

data class Tax(
    private val percentage: BigDecimal,
    private val amount: BigDecimal = BigDecimal.ZERO,
){
    companion object {
        fun fromProductTypeAndImported(type: ProductType, imported: Boolean): Tax {
            var percentage = BigDecimal(ProductType.getTax(type))
            if (imported) {
                percentage = percentage.add(BigDecimal("5"))
            }

            return Tax(
                percentage = percentage
            )
        }
    }

    fun roundUpToNearestFiveCents(): BigDecimal {
        val increment = BigDecimal("0.05")
        val divided = amount.divide(increment, 0, RoundingMode.UP)
        return divided.multiply(increment).setScale(2, RoundingMode.HALF_UP)
    }

    fun calculateTaxAmount(ht: BigDecimal?): Tax = Tax(
        percentage = percentage,
        amount = ht?.multiply(percentage)?.divide(BigDecimal(100)) ?: BigDecimal.ZERO
    )
}
