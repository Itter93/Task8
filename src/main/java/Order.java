import java.util.ArrayList;

public class Order {
    private String customerLogin;
    private ArrayList orderList;

    public Order(String customerLogin, ArrayList orderList) {
        this.customerLogin = customerLogin;
        this.orderList = orderList;
    }
}