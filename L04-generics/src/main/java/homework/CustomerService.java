package homework;

import java.util.Map;
import java.util.TreeMap;

public class CustomerService {
    private TreeMap<Customer, String> customerData = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        return customerData.firstEntry();
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> nextEntry = customerData.higherEntry(customer);
        return nextEntry != null ? nextEntry : null;
    }

    public void add(Customer customer, String data) {
        customerData.put(customer, data);
    }
}
