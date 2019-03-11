package cn.cityworks.MessageProvider.routes.index;

import cn.cityworks.MessageProvider.service.index.FinancialService;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getFinancial")
public class FinancialController {

    @Autowired
    private FinancialService financialService;


    @RequestMapping
    @ResponseBody
    public Object getFinancial(@RequestParam(defaultValue = "2014",required = false) String start,@RequestParam(defaultValue = "now",required = false) String end){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","一般公共预算");
        indicator.put("name",Utils.getTimeList(start,end));

        data.put("一般公共预算总收入", financialService.getTotalPublicBudgetRevenue(start,end));
        data.put("一般公共预算收入", financialService.getPublicBudgetRevenue(start,end));


        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
