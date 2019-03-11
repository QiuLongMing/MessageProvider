package cn.cityworks.MessageProvider.routes.fixedInvestments;

import cn.cityworks.MessageProvider.service.fixedInvestments.ProjectInvestmentCompletionStatusService;
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
@RequestMapping(value = "/getProjectInvestment")
public class ProjectInvestmentCompletionStatusController {

    @Autowired
    private ProjectInvestmentCompletionStatusService completionStatusService;


    @RequestMapping
    @ResponseBody
    public Object getProjectInvestment(@RequestParam(defaultValue = "2012",required = false) String start,@RequestParam(defaultValue = "now",required = false) String end){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","项目投资完成情况");
        indicator.put("name",Utils.getTimeList(start,end));

        data.put("第一产业", completionStatusService.getPrimary(start,end));
        data.put("第二产业", completionStatusService.getSecondary(start,end));
        data.put("第三产业", completionStatusService.getTertiary(start,end));


        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

}
