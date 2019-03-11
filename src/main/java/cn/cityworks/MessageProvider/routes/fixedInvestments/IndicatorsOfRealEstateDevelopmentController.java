package cn.cityworks.MessageProvider.routes.fixedInvestments;

import cn.cityworks.MessageProvider.service.fixedInvestments.IndicatorsOfRealEstateDevelopmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getIndicatorsOfRealEstate")
public class IndicatorsOfRealEstateDevelopmentController {

    @Autowired
    private IndicatorsOfRealEstateDevelopmentService service;


    @RequestMapping(value = "/getTotal")
    @ResponseBody
    public Object getTotal(){
        return service.getTotal();
    }

    @RequestMapping(value = "/getIndicators")
    @ResponseBody
    public Object getIndicators(){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","房地产开发指标");
        indicator.put("name",service.getNameList());

        data.put("指标", service.getIndicators());

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
