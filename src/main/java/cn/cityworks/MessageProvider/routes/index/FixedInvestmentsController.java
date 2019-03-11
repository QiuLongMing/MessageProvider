package cn.cityworks.MessageProvider.routes.index;

import cn.cityworks.MessageProvider.service.index.FixedInvestmentsService;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getFixedInvestments")
public class FixedInvestmentsController {

    @Autowired
    private FixedInvestmentsService fixedInvestmentsService;


    @RequestMapping
    @ResponseBody
    public Object getTotal(@RequestParam(defaultValue = "2011",required = false) String start,@RequestParam(defaultValue = "now",required = false) String end){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","固定资产投资");
        indicator.put("name",Utils.getTimeList(start,end));

        data.put("固定资产投资", fixedInvestmentsService.getTotal(start,end));

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
