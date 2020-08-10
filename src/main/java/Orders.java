import java.util.ArrayList;
import java.util.HashMap;

public class Orders {
    private String orderId;
    private HashMap orderInfo;

    public Orders(String orderId, String orderType, ArrayList<String> productList) {
        orderInfo = new HashMap<String, String>();
        this.orderId = orderId;
        this.orderInfo.put("orderType", orderType);
        this.orderInfo.put("productList", productList);
    }
}
