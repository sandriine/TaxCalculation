package org.taxCalculation.infra

import org.taxCalculation.domain.model.Invoice

data class InvoiceView (
    private val result: String,
) {
    companion object {
        fun from(invoice: Invoice): InvoiceView {
            return InvoiceView(
                result = invoice.getInvoiceItems().joinToString { invoiceItem ->
                    "${invoiceItem.getQuantity()} ${ invoiceItem.getLabel() } : ${ invoiceItem.getTtc() }"} + " Montant des taxes : " + invoice.getAmountTax() + " Total : " + invoice.getTotal()
            )
        }
    }

    fun getResult(): String {
        return result
    }
}