package cn.cityworks.MessageProvider.routes.index;

import cn.cityworks.MessageProvider.service.index.IndustrialService;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getIndustrial")
public class IndustrialController {

    @Autowired
    private IndustrialService industrialService;


    @RequestMapping
    @ResponseBody
    public Object getTotal(@RequestParam(defaultValue = "2011",required = false) String start,@RequestParam(defaultValue = "now",required = false) String end){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","工业总产值");
        indicator.put("name",Utils.getTimeList(start,end));

        data.put("工业总产值", industrialService.getTotal(start,end));
        data.put("规模以上工业总产值", industrialService.getAboveDesignatedSize(start,end));


        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
