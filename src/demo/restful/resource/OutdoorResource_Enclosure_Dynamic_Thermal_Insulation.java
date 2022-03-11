package demo.restful.resource;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import java.io.FileWriter;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import java.io.*;// file access


@Path("/enclosure_dynamic_thermal_insulation")
public class OutdoorResource_Enclosure_Dynamic_Thermal_Insulation {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() {
        return "Enclosure_Dynamic_Thermal_Insulation";
    }

    @GET
    @Path("/get/{param}")
    @Produces("text/plain;charset=UTF-8")
    public String getInfoToUTF8(@PathParam("param") String username, @Context HttpServletRequest req) throws DocumentException {
//        return "thermal_engineering<><> " + username;

        String fileName=req.getSession().getServletContext().getRealPath("");
        Document doc = new SAXReader().read(new File(fileName+"xmlfiles/50136隔热典型日逐时参数.xml"));

        System.out.println("--------------------------------");
        System.out.println(fileName);
        System.out.println("--------------------------------");

        Element root = doc.getRootElement();//得到根节点

//        Element firstElement = (Element) root.elements(String.valueOf(0));
//        List elements = root.elements();
//        Element element = (Element) elements.get(0);

        List<Element> E = root.elements();//得到子节点全体

        int fi = -1;
        for (int i = 0; i < E.size(); i++) {
//            String textName =    //获取节点名字

            if(E.get(i).getName().equals("Row" + username)){
                fi = i;
                System.out.println("第" + (i + 1) + "节点名" + E.get(i).getName());
                System.out.println("------------------------");
                System.out.println("/n" +fi+"/n");
                System.out.println("------------------------");

            }
        }
        System.out.println("------------------------");
        System.out.println(E.get(0).getName() );
        System.out.println("------------------------");
        System.out.println("Row"+username);
        System.out.println("------------------------");
//        for(int i=0;i<E.size();i++) {
//            System.out.println("第"+(i+1)+"节点名"+E.get(i).getName());
//
//        }

        int num = Integer.parseInt(username);
        //得到第一个Hum里面的 子节点名 属性 属性值 (为了打印好看才调getName，增删改时不用调)
        Element N = E.get(fi);//得到第一个Hum节点中的name节点
//        N.getText();
//        //递归遍历当前节点所有的子节点
//        List<Element> listElement=N.elements();//所有一级子节点的list
//        for(Element e:listElement) {//遍历所有一级子节点
//            this.getNodes(e);//递归
//        }

//        //创建SAXReader对象
//        SAXReader reader = new SAXReader();
//        //读取文件 转换成Document
//        Document document = reader.read(new File("src/demo/restful/test/s.xml"));
//        //获取根节点
//        Element root = document.getRootElement();
//        //根节点转换为String字符串
//        String rootStr = root.asXML();
//        System.out.println("root 字符串：" + rootStr);
//        //获取其中student1节点
//        Element student1Node = root.element("student1");
//        //student1节点转换为String字符串
//        String student1Str = student1Node.asXML();
//        System.out.println("student1 字符串：" + student1Str);

        String tStr = N.asXML();

//        t = String.valueOf(N);
//        String fileName=req.getSession().getServletContext().getRealPath("");
//        fileName+="xmlfiles\\enclosure_dynamic_thermal_insulation_"+username+".xml";
//        t+=ReadFileUTF8.read(fileName);
        return tStr ;
    }


//    @GET
//    @Path("/get/{param}")
//    @Produces("text/plain;charset=UTF-8")   //text/xml
//    public String getInfoToUTF8(@PathParam("param") String username, @Context HttpServletRequest req) throws IOException, DocumentException {
//        //return "Enclosure_Dynamic_Thermal_Insulation<><> " + username;
////        String t="Data from File!\n";
//        String fileName=req.getSession().getServletContext().getRealPath("");
////        fileName+="xmlfiles\\enclosure_dynamic_thermal_insulation_"+username+".xml";
//
//        Document doc = new SAXReader().read("WebContent/xmlfiles/50136隔热典型日逐时参数.xml");//得到文档
//
//        Element root = doc.getRootElement();//得到根节点
//
//        List<Element> list = root.elements();//得到根节点下的所有儿子节点【Hum】
//
////        //删节点操作
////        Element H= list.get(2).element("name");//通过第三个Hum，找到name节点
////        H.detach();//删除第三个Hum中的name节点(精确删节点)
//
//        int i = Integer.parseInt(username);
//        Element H2= list.get(i);//得到第三个Hum节点
//        H2.detach();// 删除第三个Hum节点--删整个节点(诛九族)
//
////        //删属性操作 （一般不会删属性值保留属性的，如有此需求，直接修改属性值为空就好了）
////        Attribute arr = H.attribute("id");//从孙子name脑壳上找到id属性
////        arr.detach();//删除这个 id==003
//
//        //第二种方式 通过父节点调用remove() 可以删子节点 属性 文本 怎么方便怎么用
//
//
//        //这里是保存，路径相同相当于是更新内容
//        OutputFormat format = new OutputFormat();
//        format.setEncoding("UTF-8");
//        XMLWriter w = new XMLWriter(new FileWriter("WebContent/xmlfiles/50136隔热典型日逐时参数.xml"),format);
//        w.write(doc);
//        w.close();
//
//        fileName+="xmlfiles\\50136隔热典型日逐时参数.xml";
//        String t = null;
//        t+=ReadFileUTF8.read(fileName);
//        return t ;
//    }



    //下为新增方法
    //表示处理的请求类型，post对应的是insert新增操作
    //访问当前服务接口方法对应的路径  【.../userService/user】
//    public void saveUser(User user);
    @POST
    @Path("/post/{param}")
    @Consumes("application/x-www-form-urlencoded")       //{MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}    "text/plain;charset=UTF-8"
//    @Consumes(value = MediaType.APPLICATION_FORM_URLENCODED)
    public void postInfoToUTF8( @PathParam("param")String rowId, @Context HttpServletRequest req
            ,
                                @FormParam("param")String stno,@FormParam("param")String temp,@FormParam("param")String sfs,
                                @FormParam("param")String s,@FormParam("param")String n,@FormParam("param")String e,@FormParam("param")String w
    ) throws DocumentException, IOException {
        //return "Enclosure_Dynamic_Thermal_Insulation<><> " + username;
        String fileName=req.getSession().getServletContext().getRealPath("");
        Document doc = new SAXReader().read(new File(fileName+"xmlfiles/50136隔热典型日逐时参数.xml"));
//        fileName+="xmlfiles\\50136隔热典型日逐时参数.xml";
        Element root = doc.getRootElement();//得到根节点

        List<Element> list = root.elements();//得到根节点下的所有儿子节点【Hum】
        int fi = -1;
        for (int i = 0; i < list.size(); i++) {
//            String textName =    //获取节点名字
            if(list.get(i).getName().equals("Row" + rowId)){
                fi = i;
                System.out.println("第" + (i + 1) + "节点名" + list.get(i).getName());
                System.out.println("------------------------");
                System.out.println("/n" +fi+"/n");
                System.out.println("------------------------");
            }
        }
        Element H2 = list.get(fi);//得到第三个Hum节点
        //H2.detach();// 删除第三个Hum节点--删整个节点(诛九族)
        if(H2 == null ) {
            return;
        }

        Element h3 = H2.element("stno");
        if (h3.getText() != "") {
            h3.setText(stno);
        }
        Element h4 = H2.element("temp");
        if (h4.getText() != "") {
            h4.setText(temp);
        }
        Element h5 = H2.element("sfs");
        if (h5.getText() != "") {
            h5.setText(sfs);
        }
        Element h6 = H2.element("s");
        if (h6.getText() != "") {
            h6.setText(s);
        }
        Element h7 = H2.element("n");
        if (h7.getText() != "") {
            h7.setText(n);
        }
        Element h8 = H2.element("e");
        if (h8.getText() != "") {
            h8.setText(e);
        }
        Element h9 = H2.element("w");
        if (h9.getText() != "") {
            h9.setText(w);
        }

        OutputFormat format = new OutputFormat();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter(fileName+"xmlfiles/50136隔热典型日逐时参数.xml"), format);
        writer.write(doc);
        writer.close();
//        t+=ReadFileUTF8.read(fileName);
//        return t ;
    }

    //下为新增方法
    //表示处理的请求类型，put为update修改操作
//    @PUT
//    @Path("/user")
//    @Consumes({ "application/xml", "application/json" })
//    public void updateUser(User user);

    //下为新增方法
    //delete删除操作
//    @Path("/user/{id}")
//    //服务器支持的请求数据格式类型
//    @Consumes({"application/xml", "application/json"})
//    public void deleteUser(@PathParam("id") Integer id);
    @DELETE
    @Path("/get/{param}")
    @Consumes("text/plain;charset=UTF-8")
    public void deleteInfoToUTF8(@PathParam("param") String username, @Context HttpServletRequest req) throws IOException, DocumentException {
//        //return "Enclosure_Dynamic_Thermal_Insulation<><> " + username;
//        String t="Data from File!\n";
        String fileName=req.getSession().getServletContext().getRealPath("");
        System.out.println("--------------------------------");
        System.out.println(fileName);
        System.out.println("--------------------------------");
//        fileName+="xmlfiles\\50136隔热典型日逐时参数.xml";
//        t+=ReadFileUTF8.read(fileName);
//        return t ;
//        Document doc = new SAXReader().read("WebContent/xmlfiles/50136隔热典型日逐时参数.xml");//得到文档

//        String xmlPath = "G:\\graduation_project\\javaWeb\\WebServiceRESTfulDemo\\WebContent\\xmlfiles\\50136隔热典型日逐时参数.xml";
//        File file = new File(xmlPath);

        Document doc = new SAXReader().read(fileName+"xmlfiles\\50136隔热典型日逐时参数.xml");//得到文档

        Element root = doc.getRootElement();//得到根节点

        List<Element> list = root.elements();//得到根节点下的所有儿子节点【Hum】

//        //删节点操作
//        Element H= list.get(2).element("name");//通过第三个Hum，找到name节点
//        H.detach();//删除第三个Hum中的name节点(精确删节点)

        //int usernum = Integer.parseInt(username);

        int fi = -1;
        for (int i = 0; i < list.size(); i++) {
//            String textName =    //获取节点名字
            if(list.get(i).getName().equals("Row" + username)){
                fi = i;
                System.out.println("第" + (i + 1) + "节点名" + list.get(i).getName());
                System.out.println("------------------------");
                System.out.println("/n" +fi+"/n");
                System.out.println("------------------------");
            }
        }

        Element H2 = list.get(fi);//得到第三个Hum节点
        H2.detach();// 删除第三个Hum节点--删整个节点

//        //删属性操作 （一般不会删属性值保留属性的，如有此需求，直接修改属性值为空就好了）
//        Attribute arr = H.attribute("id");//从孙子name脑壳上找到id属性
//        arr.detach();//删除这个 id==003

        //第二种方式 通过父节点调用remove() 可以删子节点 属性 文本 怎么方便怎么用


        //这里是保存，路径相同相当于是更新内容
        OutputFormat format = new OutputFormat();
        format.setEncoding("UTF-8");
        XMLWriter w = new XMLWriter(new FileWriter(fileName+"xmlfiles\\50136隔热典型日逐时参数.xml"), format);
        w.write(doc);
        w.close();

//        fileName+="xmlfiles\\50136隔热典型日逐时参数.xml";
//        String t = null;
//        t+=ReadFileUTF8.read(fileName);
//        return t ;
    }
}
