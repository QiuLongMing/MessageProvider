package cn.cityworks.MessageProvider.routes.index;

import cn.cityworks.MessageProvider.service.index.PCDIService;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getPCDI")
public class PCDIController {

    @Autowired
    private PCDIService pcdiService;


    @RequestMapping
    @ResponseBody
    public Object getPCDI(@RequestParam(defaultValue = "2012",required = false) String start,@RequestParam(defaultValue = "now",required = false) String end){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","城乡居民收入");
        indicator.put("name",Utils.getTimeList(start,end));

        data.put("城镇居民可支配收入", pcdiService.getTowner(start,end));
        data.put("乡村居民可支配收入", pcdiService.getCountry(start,end));


        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
