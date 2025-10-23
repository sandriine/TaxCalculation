package org.taxCalculation

import org.taxCalculation.domain.model.Product
import org.taxCalculation.domain.model.ProductType
import org.taxCalculation.infra.InvoiceAdapter
import java.math.BigDecimal

fun main() {
    val adapter = InvoiceAdapter()

    //CASE 1
    val products1 = listOf(
        Product(type = ProductType.BOOK, ht = BigDecimal("12.49"), label = "livre"),
        Product(type = ProductType.OTHER, ht = BigDecimal("14.99"), label = "CD musical"),
        Product(type = ProductType.FOOD, ht = BigDecimal("0.85"), label = "barre de chocolat"),
    )
    val output1 = adapter.getInvoice(products1)
    println(output1.getResult())

    //CASE 2
    val products2 = listOf(
        Product(type = ProductType.FOOD, ht = BigDecimal("10"), label = "boîte de chocolats", imported = true),
        Product(type = ProductType.OTHER, ht = BigDecimal("47.50"), label = "flacon de parfum", imported = true),
    )
    val output2 = adapter.getInvoice(products2)
    println(output2.getResult())

    //CASE 3
    val products3 = listOf(
        Product(type = ProductType.OTHER, ht = BigDecimal("27.99"), label = "flacon de parfum", imported = true),
        Product(type = ProductType.OTHER, ht = BigDecimal("18.99"), label = "flacon de parfum"),
        Product(type = ProductType.DRUG, ht = BigDecimal("9.75"), label = "boîte de pilules contre la migraine"),
        Product(type = ProductType.FOOD, ht = BigDecimal("11.25"), label = "boîte de chocolats", imported = true),
    )
    val output3 = adapter.getInvoice(products3)
    println(output3.getResult())
}