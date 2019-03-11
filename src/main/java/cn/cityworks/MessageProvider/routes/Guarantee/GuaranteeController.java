package cn.cityworks.MessageProvider.routes.Guarantee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
public class GuaranteeController {


    /*紧急通知模块*/
    @RequestMapping("/getUrgentMessage")
    public Object getUrgentMessage(){

        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Map<String, Object> map1 = new LinkedHashMap<String, Object>();


        map.put("title","紧急通知");
        List<String> list1=new ArrayList<>();
        list1.add("1号馆闭馆接待通知");
        list1.add("时间：8：00~10：00");
        map.put("date",list1);
        return map;
    }

    /*交通状况模块*/
    @RequestMapping("/getTtraffic")
    public Object getTtraffic(){

        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Map<String, Object> map1 = new LinkedHashMap<String, Object>();


        Map<String, Object> listTotal=new LinkedHashMap<>();
        map.put("title","交通状况");
        List<String> list1=new ArrayList<>();
        list1.add("交通管制");
        list1.add("各区警力对比柱状图");
        list1.add("车位情况");
        map.put("name",list1);
        map1.put("路段",3);
        map1.put("共有交警",46);
        listTotal.put("交通管制",map1);

        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
        Map<String, Object> map3 = new LinkedHashMap<String, Object>();
        List<String> listSection=new ArrayList<>();
        listSection.add("区");
        listSection.add("数量");
        map2.put("name",listSection);

        List<String> listq = new ArrayList<String>();
        listq.add("仓山区");
        listq.add("鼓楼区");
        listq.add("台江区");
        listq.add("晋安区");
        listq.add("马尾区");
        listq.add("长乐区");

        List<Integer> listN = new ArrayList<Integer>();
        listN.add(231);
        listN.add(172);
        listN.add(196);
        listN.add(256);
        listN.add(189);
        listN.add(204);
        map3.put("区",listq);
        map3.put("数量",listN);
        map2.put("data",map3);
        listTotal.put("各区警力对比柱状图",map2);

        Map<String, Object> map4 = new LinkedHashMap<String, Object>();
        map4.put("共有车位",2251);
        map4.put("共有空闲车位",551);
        listTotal.put("车位情况",map4);
        map.put("data",listTotal);

        return map;
    }




    /*c场内物联网设备报警模块*/
    @RequestMapping("/getEquipment")
    public Object getEquipment () {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Map<String, Object> mapData = new LinkedHashMap<String, Object>();
        map.put("title", "物联网设备报警");
        List<String> listName=new ArrayList<>();
        listName.add("设施类别");
        listName.add("报警类型饼状图");
        map.put("name",listName);

        List<String> listType=new ArrayList<>();
        listType.add("安全设施");
        listType.add("电路设施");
        listType.add("消防设施");
        mapData.put("设施类别",listType);


        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
        Map<String, Object> map3 = new LinkedHashMap<String, Object>();
        List<String> listSection=new ArrayList<>();
        listSection.add("区");
        listSection.add("重量");
        listSection.add("百分比");

        map2.put("name",listSection);

        List<String> listq = new ArrayList<String>();
        listq.add("仓山区");
        listq.add("鼓楼区");
        listq.add("台江区");


        List<Integer> listKg = new ArrayList<Integer>();
        listKg.add(231);
        listKg.add(172);
        listKg.add(196);
        List<Integer> listfb = new ArrayList<Integer>();
        listfb.add(30);
        listfb.add(30);
        listfb.add(40);

        map3.put("区",listq);
        map3.put("重量",listKg);
        map3.put("百分比",listfb);
        map2.put("data",map3);
        mapData.put("报警类型饼状图",map2);


        map.put("data",mapData);

        return map;



    }


    /*场馆安检模块*/
    @RequestMapping("/getSecurity")
    public Object getSecurity () {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Map<String, Object> mapData = new LinkedHashMap<String, Object>();
        map.put("title", "场馆安检");

        List<String> listName=new ArrayList<>();
        listName.add("安检");
        listName.add("人员进出趋势分析");
        map.put("name",listName);


        Map<String, Object> map1 = new LinkedHashMap<String, Object>();

        map1.put("一道门进人数",215);
        map1.put("二道门进人数",210);
        mapData.put("安检",map1);

        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
        Map<String, Object> map3 = new LinkedHashMap<String, Object>();
        List<String> listSection=new ArrayList<>();
        listSection.add("时间");
        listSection.add("数量");
        map2.put("name",listSection);

        List<Integer> listTime = new ArrayList<Integer>();
        listTime.add(17);
        listTime.add(18);
        listTime.add(19);
        listTime.add(20);
        listTime.add(21);
        listTime.add(22);

        List<Integer> listNum = new ArrayList<Integer>();
        listNum.add(10);
        listNum.add(30);

        map3.put("时间",listTime);
        map3.put("数量",listNum);

        map2.put("data",map3);

        mapData.put("人员进出趋势分析",map2);

        map.put("data",mapData);




        return map;
    }

    /*网络安全模块*/
    @RequestMapping("/getNetwork")
    public Object getNetwork () {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Map<String, Object> mapData = new LinkedHashMap<String, Object>();
        map.put("title", "网络安全");

        List<String> listName=new ArrayList<>();
        listName.add("总小时");
        listName.add("在线人数");
        map.put("name",listName);


        Map<String, Object> map1 = new LinkedHashMap<String, Object>();

        map1.put("小时",2153);
        mapData.put("总小时",map1);

        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
        Map<String, Object> map3 = new LinkedHashMap<String, Object>();
        List<String> listSection=new ArrayList<>();
        listSection.add("人数");
        listSection.add("系统类别");
        map2.put("name",listSection);

        List<Integer> listTime = new ArrayList<Integer>();
        listTime.add(22);
        listTime.add(382);
        listTime.add(12);
        listTime.add(382);


        List<String> listNum = new ArrayList<String>();
        listNum.add("人在线食品监督系统");
        listNum.add("人在线安检系统");
        listNum.add("人在线停车场系统");
        listNum.add("人在线安检系统");

        map3.put("人数",listTime);
        map3.put("系统类别",listNum);

        map2.put("data",map3);

        mapData.put("在线人数",map2);

        map.put("data",mapData);



        return map;

    }


    /*食品ring安全模块*/
    @RequestMapping("/getFoodSafety")
    public Object getFoodSafety () {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Map<String, Object> mapData = new LinkedHashMap<String, Object>();
        map.put("title", "食品安全");

        List<String> listName=new ArrayList<>();
        listName.add("可供就餐人数");
        listName.add("抽检达标率趋势图");
        map.put("name",listName);

        Map<String, Object> map1 = new LinkedHashMap<String, Object>();

        map1.put("就餐人数",2155);
        mapData.put("可供就餐人数",map1);

        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
        Map<String, Object> map3 = new LinkedHashMap<String, Object>();
        List<String> listSection=new ArrayList<>();
        listSection.add("时间");
        listSection.add("数量");
        map2.put("name",listSection);

        List<Integer> listTime = new ArrayList<Integer>();
        listTime.add(17);
        listTime.add(18);
        listTime.add(19);
        listTime.add(20);
        listTime.add(21);
        listTime.add(22);

        List<Integer> listNum = new ArrayList<Integer>();
        listNum.add(10);
        listNum.add(30);

        map3.put("时间",listTime);
        map3.put("数量",listNum);

        map2.put("data",map3);

        mapData.put("抽检达标率趋势图",map2);

        map.put("data",mapData);




        return map;
    }



}
