package cn.cityworks.MessageProvider.routes.fixedInvestments;

import cn.cityworks.MessageProvider.domain.fixedInvestments.RealEstateDevelopmentInvestment;
import cn.cityworks.MessageProvider.service.fixedInvestments.RealEstateDevelopmentInvestmentService;
import cn.cityworks.MessageProvider.service.fixedInvestments.ThreeIndustrialFixedAssetsInvestmentService;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getRealEstateInvestment")
public class RealEstateDevelopmentInvestmentController {

    @Autowired
    private RealEstateDevelopmentInvestmentService service;


    @RequestMapping(value = "/getByET")
    @ResponseBody
    public Object getByET(@RequestParam(defaultValue = "2017",required = false) String year){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","房地产开发投资情况");
        String[] name = {"国有经济","集体经济","其他经济"};
        indicator.put("name",name);

        data.put("按经济类型", service.getEconomicType(year));

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

    @RequestMapping(value = "/getByEP")
    @ResponseBody
    public Object getByET(@RequestParam(defaultValue = "2014",required = false) String start,@RequestParam(defaultValue = "now",required = false) String end){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = service.getByEP(start,end);
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","房地产开发投资情况");
        String[] name = {"时间","商业营业","住宅","办公楼","其他"};
        indicator.put("name",name);

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
