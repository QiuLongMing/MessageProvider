package cn.cityworks.MessageProvider.routes.index;

import cn.cityworks.MessageProvider.service.index.GDPService;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getGDP")
public class GDPController {

    @Autowired
    private GDPService gdpService;


    @RequestMapping(value = "/getTotal")
    @ResponseBody
    public Object getTotal(@RequestParam(defaultValue = "2011",required = false) String start,@RequestParam(defaultValue = "now",required = false) String end){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","市生产总值");
        indicator.put("name",Utils.getTimeList(start,end));

        data.put("市生产总值", gdpService.getTotal(start,end));

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

    @RequestMapping(value = "/getPerCapita")
    @ResponseBody
    public Object getPerCapita(@RequestParam(defaultValue = "2011",required = false) String start,@RequestParam(defaultValue = "now",required = false) String end){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","人均生产总值");
        indicator.put("name",Utils.getTimeList(start,end));

        data.put("人均生产总值", gdpService.getPerCapita(start,end));

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

    @RequestMapping(value = "/getThreeIndustrial")
    @ResponseBody
    public Object getPerCapita(){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        String[] name = {"第一产业","第二产业","第三产业"};
        indicator.put("title","三次产业比例");
        indicator.put("name",name);

        data.put("三次产业比例", gdpService.getThreeIndustrialStructuresg());

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
