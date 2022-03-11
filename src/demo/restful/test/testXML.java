package demo.restful.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.FileWriter;
import java.util.List;


public class testXML
{
    public static void main(String[] args) throws Exception {

        Document doc = new SAXReader().read("WebContent/xmlfiles/50136隔热典型日逐时参数.xml");//得到文档G:/graduation_project/javaWeb/WebServiceRESTfulDemo/  WebContent/xmlfiles/50136隔热典型日逐时参数.xml

        Element root = doc.getRootElement();//得到根节点

        List<Element> list = root.elements();//得到根节点下的所有儿子节点【Hum】

//        //删节点操作
//        Element H= list.get(2).element("name");//通过第三个Hum，找到name节点
//        H.detach();//删除第三个Hum中的name节点(精确删节点)

        Element H2= list.get(1);//得到第三个Hum节点
        H2.detach();// 删除第三个Hum节点--删整个节点(诛九族)

//        //删属性操作 （一般不会删属性值保留属性的，如有此需求，直接修改属性值为空就好了）
//        Attribute arr = H.attribute("id");//从孙子name脑壳上找到id属性
//        arr.detach();//删除这个 id==003

        //第二种方式 通过父节点调用remove() 可以删子节点 属性 文本 怎么方便怎么用


        //这里是保存，路径相同相当于是更新内容
        OutputFormat format = new OutputFormat();
        format.setEncoding("UTF-8");
        XMLWriter w = new XMLWriter(new FileWriter("WebContent/xmlfiles/50136隔热典型日逐时参数.xml"),format);//G:/graduation_project/javaWeb/WebServiceRESTfulDemo/
        w.write(doc);
        w.close();
        System.out.println("成功");
    }
}


