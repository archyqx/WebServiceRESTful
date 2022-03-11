package demo.restful.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/thermal_engineering")
public class OutdoorResource_Thermal_Engineering {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() {
        return "thermal_engineering";
    }

    @GET
    @Path("/{param}")
    @Produces("text/plain;charset=UTF-8")
    public String getInfoToUTF8(@PathParam("param") String username, @Context HttpServletRequest req) {
//        return "thermal_engineering<><> " + username;
        String t="Data from File!\n";
        String fileName=req.getSession().getServletContext().getRealPath("");
        System.out.println("-----------------------");
        System.out.println(fileName);
        System.out.println("-----------------------");
        fileName+="xmlfiles\\thermal_engineering_"+username+".xml";
        System.out.println("-----------------------");
        System.out.println(fileName);
        System.out.println("-----------------------");
        t+=ReadFileUTF8.read(fileName);
        return t ;
    }
}

