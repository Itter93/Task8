import com.google.gson.Gson;
import org.junit.Test;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;


public class Main {

    @Test
    public void test1() {
        String url = "https://reqbin.com/echo/post/json";
        String customerLogin = "customer";

        ArrayList<String> productList = new ArrayList<String>();
        productList.add("IPTV");
        productList.add("INTERNET");

        ArrayList orderList = new ArrayList();
        orderList.add(new Orders("152468", "sell", productList));
        orderList.add(new Orders("152469", "change", productList));

        Order order = new Order(customerLogin, orderList);
        Gson gson = new Gson();
        String json = gson.toJson(order);
        System.out.println(json + "\n");
        Responce reply = new Responce(json, url, "application/json");
        reply = gson.fromJson(reply.send().getBody().asString(), Responce.class);
        System.out.println("Response: " + reply.getSuccess());
    }

    @Test
    public void test2() {
        String url = "http://10.28.43.17:28080/aifemulator/integration/SecretWordService?WSDL";
        String ExternalId = "178689818";

        String secretWord = "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <S:Body>\n" +
                "      <ns2:GetSecretWord xmlns:ns3=\"http://www.rt.ru/integration/messages/fault\" xmlns:ns2=\"http://www.rt.ru/integration/messages/crm/secretword\" xmlns=\"http://www.rt.ru/integration/messages/core\">\n" +
                "         <ns2:Destination>\n" +
                "         </ns2:Destination>\n" +
                "         <ns2:ExternalId>" + ExternalId + "</ns2:ExternalId>\n" +
                "      </ns2:GetSecretWord>\n" +
                "   </S:Body>\n" +
                "</S:Envelope>";

        System.out.println(secretWord + "\n");
        Responce reply = new Responce(secretWord, url, "text/xml");
        String text = reply.send().getBody().asString();
        Document document = null;
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = documentBuilder.parse(new ByteArrayInputStream(text.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        NodeList nodeList = document.getElementsByTagName("sec:SecretWord");

        System.out.println("SecretWord: " + nodeList.item(0).getTextContent());

    }
}
