package org.example;

import spark.Request;
import spark.Response;

import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        staticFileLocation("/public");
        get("/cadena", (req,res) -> getCadena(req,res));

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    public static String getCadena(Request request , Response response){
        String res = "";
        String salida= "";
        String num = request.queryParams("name");
        int numm = Integer.parseInt(num);
        while (!(numm == 1)){
            if(numm % 2 == 0){
                numm = numm/2;
                res = String.valueOf(numm);
                salida = salida + numm +"->" ;

            } else{
                numm = 3*numm+1;
                res = String.valueOf(numm);
                salida = salida + numm +"->" ;
            }
        }
        String msg = "{\n" +
                "\n" +
                " \"operation\": \"collatzsequence\",\n" +
                "\n" +
                " \"input\":" +num +
                "\n" +
                " \"output\": "+ salida +
                "\n" +
                "}";
        return msg;
    }

}