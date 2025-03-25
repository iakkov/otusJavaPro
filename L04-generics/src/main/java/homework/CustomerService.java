package homework;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {
    private NavigableMap<Customer, String> customerData = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> smallestEntry = customerData.firstEntry();
        if (smallestEntry != null) {
            return Map.entry(new Customer(smallestEntry.getKey()), smallestEntry.getValue());
        }
        return null;
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> nextEntry = customerData.higherEntry(customer);
        if (nextEntry != null) {
            return Map.entry(new Customer(nextEntry.getKey()), nextEntry.getValue());
        }
        return null;
    }

    public void add(Customer customer, String data) {
        customerData.put(customer, data);
    }
}
