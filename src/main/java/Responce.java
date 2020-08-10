import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Responce {
    private String success;
    private String body;
    private String url;
    private String contentType;

    public String getSuccess() {
        return success;
    }

    public Responce(String body, String url, String contentType) {
        this.body = body;
        this.url = url;
        this.contentType = contentType;
    }

    public Response send(){

        RequestSpecification request = RestAssured.given();
        request.body(body);
        request.contentType(contentType);
        Response response = request.post(url);
        return response;
    }

}
