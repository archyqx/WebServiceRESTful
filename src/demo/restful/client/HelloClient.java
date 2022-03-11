package demo.restful.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import demo.restful.resource.UnicodeReader;

public class HelloClient {

    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();

        Client client = ClientBuilder.newClient(clientConfig);

        WebTarget webTarget = client.target("http://localhost:8080/WebServiceRESTfulDemo");

        WebTarget resourceWebTarget = webTarget.path("rest");


        //测试thermal_engineering
        //WebTarget helloworldWebTarget = resourceWebTarget.path("thermal_engineering");

        WebTarget helloworldWebTarget = resourceWebTarget.path("thermal_engineering/漠河");

        //测试enclosure_dynamic_thermal_insulation
//        WebTarget helloworldWebTarget = resourceWebTarget.path("enclosure_dynamic_thermal_insulation");

//        WebTarget helloworldWebTarget = resourceWebTarget.path("enclosure_dynamic_thermal_insulation/广州");



        Invocation.Builder invocationBuilder = helloworldWebTarget.request(MediaType.TEXT_PLAIN_TYPE);

        invocationBuilder.header("some-header", "true");


        Response response = invocationBuilder.get();    //修改方法
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));

//        response.close();//缺省，读完实体后自动关掉

    }

}

