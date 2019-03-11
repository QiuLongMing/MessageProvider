package cn.cityworks.MessageProvider.routes.fixedInvestments;

import cn.cityworks.MessageProvider.service.fixedInvestments.CompletedInvestmentInFixedAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getInvestmentInFixedAssets")
public class CompletedInvestmentInFixedAssetsController {

    @Autowired
    private CompletedInvestmentInFixedAssetsService completedInvestmentInFixedAssetsService;


    @RequestMapping(value = "/getStatistics")
    @ResponseBody
    public Object getStatistics(){
        return completedInvestmentInFixedAssetsService.getStatistics();
    }

    @RequestMapping(value = "/getInvestmentTotalNum")
    @ResponseBody
    public Object getTotalInvestment(){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","固定投资额区绝对值对比");
        indicator.put("name",completedInvestmentInFixedAssetsService.getLocationList());

        data.put("2017年", completedInvestmentInFixedAssetsService.getInvestmentTotalNum());

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
