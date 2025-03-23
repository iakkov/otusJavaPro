package homework;

import java.util.Stack;

public class CustomerReverseOrder {
    private Stack<Customer> stack = new Stack<>();

    public void add(Customer customer) {
        stack.push(customer);
    }

    public Customer take() {
        return stack.pop();
    }
}
