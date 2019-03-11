package cn.cityworks.MessageProvider.routes.majorProject;

import cn.cityworks.MessageProvider.service.majorProject.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/getProject")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @RequestMapping(value = "/getTotalNum")
    @ResponseBody
    public Object getTotalNum(){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","福州市重点项目数量分布情况");
        indicator.put("name",projectService.getOnDutyList());

        data.put("福州市重点项目数量分布情况", projectService.getProjectTotalNum());

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

    @RequestMapping(value = "/getTotalInvestment")
    @ResponseBody
    public Object getTotalInvestment(){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","福州市重点项目投资额分布情况");
        indicator.put("name",projectService.getOnDutyList());

        data.put("福州市重点项目投资额分布情况", projectService.getProjectTotalInvestment());

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

    @RequestMapping(value = "/getPlanCompleted")
    @ResponseBody
    public Object getPlanCompleted(){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","计划完成情况");
        indicator.put("name",projectService.getOnDutyList());

        data.put("完成投资额", projectService.getProjectPlanInvestmentCompleted());
        data.put("完成率", projectService.getProjectPlanInvestmentCompletedRate());

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

    @RequestMapping(value = "/getPrepareStart")
    @ResponseBody
    public Object getPrepareStart(){
        Map<String, Object> container = new LinkedHashMap<String, Object>();
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String, Object> indicator = new LinkedHashMap<String, Object>();

        indicator.put("title","福州市2018预备前期开工数");
        indicator.put("name",projectService.getOnDutyList());

        data.put("各区准备前期开工数统计", projectService.getProjectPrepareTotalNum());

        container.put("indicator",indicator);
        container.put("data",data);

        return container;
    }

    @RequestMapping(value = "/getProjectTotal")
    @ResponseBody
    public Object getProjectTotal(){
        return projectService.getNewTotal();
    }

    @RequestMapping(value = "/getProjectInProgress")
    @ResponseBody
    public Object getProjectInProgress(){
        return projectService.getNewInProgress();
    }

    @RequestMapping(value = "/getProjectPlan")
    @ResponseBody
    public Object getProjectPlan(){
        return projectService.getNewPlan();
    }

    @RequestMapping(value = "/getProjectPrepare")
    @ResponseBody
    public Object getProjectPrepare(){
        return projectService.getNewPrepare();
    }

}
