package dao;

import model.*;

import java.util.List;
import java.util.Optional;

public interface InvoiceDAO {
    Optional<List<Invoice>> displayInvoice(int customerId);
    List<Customer> getAllCustomers();
    List<Plan> getAllPlans();
    List<Subscription> getAllSubscriptions();
    List<Usage> getAllUsage();
}
