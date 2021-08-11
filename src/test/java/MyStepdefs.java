import dataProvider.ConfigFileReader;
import dataProvider.FileReafer;
import dataProvider.general;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.hamcrest.Matcher.*;
import static org.junit.Assert.assertTrue;


public class MyStepdefs {
    int responsecode;
    String method;
    String Url;
    String Query;
    String endurl;
    String validation;
    String Testdata;
    StringBuilder endpoint;
    String arg3;
    String ip_legacy;
    String endurl_legacy;
    String validation_legacy;
    int responsecode_legacy;
    String parameter;
    String parameter_legacy;
    Response response;
    Response response_legacy;
    StringBuilder endpoint_legacy;

    ConfigFileReader configFileReader= new ConfigFileReader();
    String ip ;

    FileReafer readfromExcel = new FileReafer();
    general urlconstructor = new general();

    @Given("I want to execute service of method {string}")
    public void i_want_to_execute_service_of_method(String method1) {
        method=method1;
        System.out.println(method);
        System.out.println("the ip is "+ip);
    }

    @When("the relative url is {string}")
    public void the_relative_url_is(String url)
    {
        Url=url;
        System.out.println("The relative URL is "+ Url);
    }

    @When("the query parameter is passed {string}")
    public void the_query_parameter_is_passed(String query) {
        if (query.equals("null")) {
            endurl = ip + Url;
            endurl_legacy = ip_legacy + Url;
            System.out.println("end url is " + endurl);
            System.out.println("end url for legacy is " + endurl_legacy);
        }
        else
        {

            Query = query;
            endurl = ip + endpoint + "?" + Query;
            endurl_legacy = ip_legacy + endpoint + "?" + Query;
            System.out.println("end url is " + endurl);
            System.out.println("end url for legacy is " + endurl_legacy);
        }

    }
    @When("the relative url is {string} and {string}")
    public void theRelativeUrlIsAnd(String arg0, String arg1) {
        int row =Integer.parseInt(arg0);
        int col =Integer.parseInt(arg1);
        Url=readfromExcel.fetchvalue(row,col);
        System.out.println(Url);
    }
    @And("the given test data is in  {string} and {string}")
    public void theGivenTestDataIsInAnd(String arg0, String arg1) {
        int row =Integer.parseInt(arg0);
        int col =Integer.parseInt(arg1);
        Testdata=readfromExcel.fetchvalue(row,col);
        System.out.println("Test data" +Testdata);
        if(Url.contains("{")) {
            endpoint = urlconstructor.constructURL(Url, Testdata);
            System.out.println("endpoint" + endpoint);
        }

    }
    @Then("execute the URL")
    public void execute_the_url() {
        if(method.equalsIgnoreCase("get"))
        {
             response = RestAssured.get(endurl);
            System.out.println(response.getStatusCode());
            responsecode = response.getStatusCode();
           // System.out.println(response.asString());
            validation= response.getBody().asString();
            System.out.println("response body of Microservice" +validation);

             response_legacy = RestAssured.get(endurl_legacy);
            System.out.println(response_legacy.getStatusCode());
            responsecode_legacy = response_legacy.getStatusCode();
            //System.out.println(response2.asString());
            validation_legacy= response_legacy.getBody().asString();
            System.out.println("response body of Legacy" +validation_legacy);
        }

        else if(method.equalsIgnoreCase("post")) {
             response = RestAssured.given().contentType("application/json").header("apigw-authenticated-client", "smoke").body(Testdata).post(endurl);
            System.out.println("status code is" + response.getStatusCode());
            responsecode = response.getStatusCode();
            validation = response.getBody().asString();
            //validation=validation + "hello";
            System.out.println("final response" + response.asString());

             response_legacy = RestAssured.given().contentType("application/json").header("apigw-authenticated-client", "smoke").body(Testdata).post(endurl_legacy);
            System.out.println("status code is" + response_legacy.getStatusCode());
            responsecode_legacy = response_legacy.getStatusCode();
            validation_legacy = response_legacy.getBody().asString();
            System.out.println("final response" + response_legacy.asString());

        }

        else if(method.equalsIgnoreCase("put"))

        {
               response =RestAssured.given().contentType("application/json").body(Testdata).put(endurl);

            System.out.println("status code is" + response.getStatusCode());
            responsecode = response.getStatusCode();
            validation = response.getBody().asString();
            //System.out.println(validation);
            System.out.println("final response" + response.asString());

            response_legacy =RestAssured.given().contentType("application/json").body(Testdata).put(endurl_legacy);
            System.out.println("status code is" + response_legacy.getStatusCode());
            responsecode_legacy = response_legacy.getStatusCode();
            validation_legacy = response_legacy.getBody().asString();
            System.out.println("final response legacy" + response_legacy.asString());


        }

        else if(method.equalsIgnoreCase("delete"))
        {
             response = RestAssured.delete(endurl);
            //System.out.println(response.getStatusCode());
            responsecode = response.getStatusCode();
            System.out.println("the response code of microservice is" + responsecode);


             response_legacy = RestAssured.delete(endurl_legacy);
           // System.out.println(response2.getStatusCode());
            responsecode_legacy = response_legacy.getStatusCode();
            System.out.println("the response code of legacy is " + responsecode_legacy);

        }

        else
        {
            System.out.println("give proper method");
        }

    }
    @Then("I validate status code {string}")
    public void iValidateStatusCode( String status) {
        int i=Integer.parseInt(status);
        assertEquals(responsecode,i);
        if(validation.equals(validation_legacy))
        {
            System.out.println("matching");
        } else
        {
            System.out.println("Not matching ");
        }

    }

    @And("I validate status code {string} and validate msisdn {string}")
    public void iValidateStatusCodeAndValidateMsisdn(String status, String arg1) {
        String a=arg1;

        int i=Integer.parseInt(status);
        assertEquals(responsecode,i);
        assertTrue(validation.contains(a));

        if(validation.equals(validation_legacy))
        {
            System.out.println("matching");
        } else
        {
            System.out.println("mot matching ");
        }

    }
    @Given("I want to execute service of method {string} and in environment {string}")
    public void iWantToExecuteServiceOfMethodAndInEnvironment(String arg0, String arg1) {
        method=arg0;
        arg3= arg1+"_legacy";
        ip=configFileReader.getenvironmentUrl(arg1);
        ip_legacy=configFileReader.getenvironmentUrl(arg3);
        System.out.println(method);
        System.out.println("the ip is "+ip);
        System.out.println("the ip for Legacy "+ip_legacy);
    }

    @And("the relative url is {string} and method is {string}")
    public void theRelativeUrlIsAndMethodIs(String arg0, String arg1)
    {
        method=arg1;
        endpoint = urlconstructor.constructURL(arg0, parameter);
        endpoint_legacy = urlconstructor.constructURL(arg0, parameter_legacy);
        endurl =ip+endpoint;
        endurl_legacy =ip_legacy+endpoint_legacy;
        System.out.println(endurl);
        System.out.println(endurl_legacy);

    }

    @And("The required request parameters are {string}")
    public void theRequiredRequestParametersAre(String arg0)
    {
        parameter = response.path(arg0);
        System.out.println(parameter);

        parameter_legacy = response_legacy.path(arg0);
        System.out.println(parameter_legacy);
    }
}