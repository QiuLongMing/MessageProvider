package cn.cityworks.MessageProvider.routes.fixedInvestments;

import cn.cityworks.MessageProvider.service.fixedInvestments.ProjectInvestmentCompletionStatusService;
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
@RequestMapping(value = "/getThreeIndustrialInvestment")
public class ThreeIndustrialFixedAssetsInvestmentController {

    @Autowired
    private ThreeIndustrialFixedAssetsInvestmentService investmentService;


    @RequestMapping
    @ResponseBody
    public Object getInvestment(@RequestParam(defaultValue = "2012",required = false) String start,@RequestParam(defaultValue = "now",required = false) String end){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","三次产业固定资产投资");
        indicator.put("name",Utils.getTimeList(start,end));

        data.put("三次产业固定资产投资", investmentService.getInvestment(start,end));

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
