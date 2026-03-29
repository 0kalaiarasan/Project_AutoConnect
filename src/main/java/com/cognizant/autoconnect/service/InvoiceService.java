package com.cognizant.autoconnect.service;

import com.cognizant.autoconnect.entity.Invoice;
import com.cognizant.autoconnect.exception.ResourceNotFoundException;
import com.cognizant.autoconnect.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found with id: " + id));
    }

    public List<Invoice> getInvoicesByCustomerId(Long customerId) {
        return invoiceRepository.findByCustomerId(customerId);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice updateInvoice(Long id, Invoice invoiceDetails) {
        Invoice invoice = getInvoiceById(id);
        invoice.setRelatedEntityId(invoiceDetails.getRelatedEntityId());
        invoice.setLineItemsJson(invoiceDetails.getLineItemsJson());
        invoice.setSubtotal(invoiceDetails.getSubtotal());
        invoice.setTaxes(invoiceDetails.getTaxes());
        invoice.setDiscountsJson(invoiceDetails.getDiscountsJson());
        invoice.setTotalAmount(invoiceDetails.getTotalAmount());
        invoice.setDueDate(invoiceDetails.getDueDate());
        invoice.setStatus(invoiceDetails.getStatus());
        invoice.setInvoiceUri(invoiceDetails.getInvoiceUri());
        return invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Long id) {
        Invoice invoice = getInvoiceById(id);
        invoiceRepository.delete(invoice);
    }
}
