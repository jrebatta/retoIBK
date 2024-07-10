package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PetSteps {

    private Response response;
    private final String BASE_URL = "https://petstore.swagger.io/v2";
    private ObjectMapper mapper = new ObjectMapper();
    private Map<String, Object> requestBody;
    private static String responseBody;
    private static long petId;


    @Given("crear nueva mascota con datos {string}, {string}, {string}, {string}, {string}, {string} y {string}")
    public void crearNuevaMascotaConDatosY(String categoryID, String categoryName, String PetName, String photoUrls, String tagID, String tagName, String status) throws JsonProcessingException {
        int categoryIdInt = Integer.parseInt(categoryID);
        int tagIdInt = Integer.parseInt(tagID);

        Map<String, Object> category = new HashMap<>();
        Map<String, Object> tag = new HashMap<>();

        category.put("id", categoryIdInt);
        category.put("name", categoryName);

        tag.put("id", tagIdInt);
        tag.put("name", tagName);

        requestBody = new HashMap<>();
        requestBody.put("category", category);
        requestBody.put("name", PetName);
        requestBody.put("photoUrls", Collections.singletonList(photoUrls));
        requestBody.put("tags", Collections.singletonList(tag));
        requestBody.put("status", status);

        String jsonBody = mapper.writeValueAsString(requestBody);

        RestAssured.baseURI = BASE_URL;

        response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post("/pet");
    }

    @Then("se valida el codigo de respuesta {string}")
    public void seValidaElCodigoDeRespuesta(String statusCode) {
        response.then()
                .log().all()
                .statusCode(Integer.parseInt(statusCode));
    }

    @Then("se obtiene el ID de la nueva mascota y se guarda el response")
    public void seObtieneElIDDeLaNuevaMascotaYSeGuardaElResponse() throws JsonProcessingException {
        responseBody = response.getBody().asString();
        Map responseMap = mapper.readValue(responseBody, Map.class);
        petId = ((Number) responseMap.get("id")).longValue();
        System.out.println("ID de la nueva mascota: " + petId);
    }

    @Given("consultar el ID de la mascota creada")
    public void consultarElIDDeLaMascotaCreada() {
        RestAssured.baseURI = BASE_URL;
        response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .when()
                .get("/pet/{petId}", petId);
    }

    @Then("se obtiene el response de la mascota y se compara")
    public void seObtieneElResponseDeLaMascotaYSeCompara() {
        Assert.assertEquals(responseBody, response.getBody().asString());
    }

    @Given("actualizar {string} de la mascota creada")
    public void actualizarDeLaMascotaCreada(String PetName) throws JsonProcessingException {

        Map responseMap = mapper.readValue(responseBody, Map.class);
        responseMap.put("name", PetName);
        String jsonBody = mapper.writeValueAsString(responseMap);

        response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .put("/pet");
    }

    @Then("se obtiene el response de la mascota y se valida el {string}")
    public void seObtieneElResponseDeLaMascotaYSeValidaEl(String PetName) throws JsonProcessingException {
        responseBody = response.getBody().asString();
        System.out.println(responseBody);
        Map responseMap = mapper.readValue(responseBody, Map.class);
        Assert.assertEquals("El nombre de la mascota se actualizó correctamente", PetName, responseMap.get("name"));
    }

    @Given("consultar el ID de la mascota a eliminar")
    public void consultarElIDDeLaMascotaAEliminar() {
        RestAssured.baseURI = BASE_URL;
        response = RestAssured.given()
                .log().all()
                .contentType("application/json")
                .when()
                .delete("/pet/{petId}", petId);
    }

    @Then("se obtiene el response de la mascota eliminada y se valida el ID")
    public void seObtieneElResponseDeLaMascotaEliminadaYSeValidaElID() throws JsonProcessingException {
        responseBody = response.getBody().asString();
        Map responseMap = mapper.readValue(responseBody, Map.class);
        String code = (String) responseMap.get("message");
        Assert.assertEquals("Validacion de codigo eliminado",petId,Long.parseLong(code));
    }
}
