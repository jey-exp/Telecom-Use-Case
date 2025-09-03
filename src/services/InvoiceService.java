package services;

import model.Invoice;
import model.Subscription;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    Optional<List<Invoice>> displayInvoice(int customerId);
    Invoice generateNewInvoice(int customerId);
}
