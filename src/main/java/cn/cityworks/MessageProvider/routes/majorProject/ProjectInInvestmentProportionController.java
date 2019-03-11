package cn.cityworks.MessageProvider.routes.majorProject;

import cn.cityworks.MessageProvider.service.majorProject.ProjectInInvestmentProportionService;
import cn.cityworks.MessageProvider.service.majorProject.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getProject")
public class ProjectInInvestmentProportionController {

    @Autowired
    private ProjectInInvestmentProportionService proportionService;


    @RequestMapping(value = "/getInvestmentRate")
    @ResponseBody
    public Object getInvestmentRate(){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","福州市重点项目年计划投资占比");
        indicator.put("name",proportionService.getTypeList());

        data.put("总投资", proportionService.getTotalInvestment());
        data.put("年计划投资占比", proportionService.getInvestmentRate());

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
