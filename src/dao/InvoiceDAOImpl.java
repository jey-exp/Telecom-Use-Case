package dao;

import exceptions.NoListofInvoices;
import model.*;
import repo.CustomerSeeder;
import repo.PlanSeeder;
import repo.SubscriptionSeeder;
import repo.UsageSeeder;
import repo.Invoices;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class InvoiceDAOImpl implements InvoiceDAO {

    @Override
    public Optional<List<Invoice>> displayInvoice(int customerId) {
        try {
            List<Invoice> allInvoice = Invoices.getInvoices();
            if (allInvoice.isEmpty()) {
                throw new NoListofInvoices("No invoices found");
            } else {
                return Optional.of(allInvoice);
            }
        } catch (NoListofInvoices e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
    //Date passers
    public List<Customer> getAllCustomers(){
        return CustomerSeeder.seedCustomers();
    }
    public List<Plan> getAllPlans(){
        return PlanSeeder.seedPlans();
    }
    public List<Subscription> getAllSubscriptions(){
        return SubscriptionSeeder.seedSubscriptions();
    }
    public List<Usage> getAllUsage(){
        return UsageSeeder.seedUsage();
    }
}
