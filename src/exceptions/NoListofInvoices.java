package exceptions;

public class NoListofInvoices extends RuntimeException {
    public NoListofInvoices(String message) {
        super(message);
    }
}
