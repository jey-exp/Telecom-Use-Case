package repo;

import model.Invoice;
import model.Subscription;

import java.time.LocalDate;
import java.util.*;

public class Invoices {

    private static int lastId = 0;
    public static List<Invoice> generatedInvoices = new ArrayList<>();
    public static Map<String, List<Invoice>> familyInvoices = new HashMap<>();

    static {
        Invoice invoice1 = new Invoice();
        invoice1.setInvoiceId(++lastId);
        invoice1.setCustomerId(1);
        invoice1.setSubscriptionId(1);
        invoice1.setPlanId(101);
        invoice1.setBaseRental(500.0);
        invoice1.setOverageAmount(50.0);
        invoice1.setTotalAmount(550.0);
        invoice1.setInvoiceDate(LocalDate.of(2023, 2, 1));
        invoice1.setPaid(false);
        addInvoiceInternal(invoice1);

        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId(++lastId);
        invoice2.setCustomerId(2);
        invoice2.setSubscriptionId(2);
        invoice2.setPlanId(102);
        invoice2.setBaseRental(700.0);
        invoice2.setOverageAmount(150.0);
        invoice2.setTotalAmount(850.0);
        invoice2.setInvoiceDate(LocalDate.of(2023, 2, 1));
        invoice2.setPaid(false);
        addInvoiceInternal(invoice2);

        Invoice invoice3 = new Invoice();
        invoice3.setInvoiceId(++lastId);
        invoice3.setCustomerId(2);
        invoice3.setSubscriptionId(2);
        invoice3.setPlanId(102);
        invoice3.setBaseRental(700.0);
        invoice3.setOverageAmount(150.0);
        invoice3.setTotalAmount(850.0);
        invoice3.setInvoiceDate(LocalDate.of(2025,8, 31));
        invoice3.setPaid(false);
        addInvoiceInternal(invoice3);
    }

    // Return all invoices
    public static List<Invoice> getInvoices() {
        return generatedInvoices;
    }

    // Return family invoices grouped by familyId
    public static Map<String, List<Invoice>> getFamilyInvoices() {
        return familyInvoices;
    }

    // Create and add a new invoice programmatically
    public static Invoice createInvoice(int customerId,
                                        int subscriptionId,
                                        int planId,
                                        double baseRental,
                                        double overageAmount,
                                        double totalAmount,
                                        LocalDate invoiceDate,
                                        boolean paid,
                                        String familyId) {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(++lastId);
        invoice.setCustomerId(customerId);
        invoice.setSubscriptionId(subscriptionId);
        invoice.setPlanId(planId);
        invoice.setBaseRental(baseRental);
        invoice.setOverageAmount(overageAmount);
        invoice.setTotalAmount(totalAmount);
        invoice.setInvoiceDate(invoiceDate);
        invoice.setPaid(paid);
        addInvoiceInternal(invoice, familyId);
        return invoice;
    }

    // TO add Invoices with no familyID - method overloaded
    private static void addInvoiceInternal(Invoice invoice) {
        addInvoiceInternal(invoice, null);
    }

    private static void addInvoiceInternal(Invoice invoice, String familyId) {
        generatedInvoices.add(invoice);

        if (familyId != null) {
            familyInvoices
                    .computeIfAbsent(familyId, k -> new ArrayList<>())
                    .add(invoice);
        }
    }
}
