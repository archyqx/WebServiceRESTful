package demo.restful.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Attribute;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class testXML2String {
    //xml文档或节点转换为字符串
    public void test001()throws Exception{
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File("src/demo/restful/test/s.xml"));
        //document转换为String字符串
        String documentStr = document.asXML();
        System.out.println("document 字符串：" + documentStr);
        //获取根节点
        Element root = document.getRootElement();
        //根节点转换为String字符串
        String rootStr = root.asXML();
        System.out.println("root 字符串：" + rootStr);
        //获取其中student1节点
        Element student1Node = root.element("student1");
        //student1节点转换为String字符串
        String student1Str = student1Node.asXML();
        System.out.println("student1 字符串：" + student1Str);
    }

    public static void main(String[] args)throws Exception {
        Document doc = new SAXReader().read(new File("WebContent/xmlfiles/50136隔热典型日逐时参数.xml"));

        Element root = doc.getRootElement();//得到根节点

        List<Element> E = root.elements();//得到子节点全体

//        int fi;
//        for (int i = 0; i < E.size(); i++) {
//            String textTrim = E.get(i).getTextTrim();   //获取节点名字
//            System.out.println("第" + (i + 1) + "节点名" + E.get(i).getName());
//            if(textTrim == usename){
//                fi = i;
//            }
//        }

        int num = Integer.parseInt("1");
        //得到第一个Hum里面的 子节点名 属性 属性值 (为了打印好看才调getName，增删改时不用调)
        Element N = E.get(num);//得到第一个Hum节点中的name节点
//        N.getText();
//        //递归遍历当前节点所有的子节点
//        List<Element> listElement=N.elements();//所有一级子节点的list
//        for(Element e:listElement) {//遍历所有一级子节点
//            this.getNodes(e);//递归
//        }

//        List<Attribute> listAttr=E.attributes();//当前节点的所有属性的list
//        for(Attribute attr:listAttr){//遍历当前节点的所有属性
//            String name=attr.getName();//属性名称
//            String value=attr.getValue();//属性的值
//            System.out.println("属性名称："+name+"属性值："+value);
//        }



        String tStr = N.asXML();
        System.out.println(tStr);
    }
}
