package automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import java.util.Scanner;

public class test1 {
@Test
    //void url(String u)
    void url()

    {

      Response response=RestAssured.get("https://auth.ref.o2.co.uk/identity/v1/identity/EMAIL/harry234@mailinator.com/details?active=false");

          System.out.println(response.getStatusCode());
         System.out.println(response.asString());
       // System.out.println(u);
    }
    {

        Response response=RestAssured.get("https://auth.ref.o2.co.uk/identity/v1/identity/EMAIL/hary234@mailinator.com/details?active=false");

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        // System.out.println(u);
    }
  /*{
        Response response=RestAssured.get("https://auth.ref.o2.co.uk/identity/v1/identity/EMAIL/harry@mailinator.com/details?active=false");

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }*/

/*
    public static void main(String[] arg ) {
        test1 a = new test1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the URL");
        String inputString = scanner.nextLine();
       a.url(inputString);
    }

 */
}



