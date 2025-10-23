package org.taxCalculation.infra

import org.taxCalculation.domain.application.GenerateInvoice
import org.taxCalculation.domain.model.Product

class InvoiceAdapter {

    private lateinit var generateInvoice: GenerateInvoice

    fun getInvoice(products: List<Product>): InvoiceView {
        val generate = GenerateInvoice(products)

        val invoice = generate.generateInvoice()

        return InvoiceView.from(invoice)
    }
}