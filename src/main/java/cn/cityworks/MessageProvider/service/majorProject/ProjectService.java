package cn.cityworks.MessageProvider.service.majorProject;

import cn.cityworks.MessageProvider.dao.LoadCsv;
import cn.cityworks.MessageProvider.domain.majorProject.ProjectInProgress;
import cn.cityworks.MessageProvider.domain.majorProject.ProjectPlan;
import cn.cityworks.MessageProvider.domain.majorProject.ProjectPrepare;
import cn.cityworks.MessageProvider.domain.majorProject.ProjectTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {

    @Autowired
    private LoadCsv loadCsv;

    /**
     * 获取项目总体合计情况
     * @return
     */
    public ProjectTotal getNewTotal(){
        Map<String,ProjectTotal> projectTotalMap = loadCsv.getProjectTotal();
        return projectTotalMap.get("合计");
    }

    /**
     * 获取项目在建合计情况
     * @return
     */
    public ProjectInProgress getNewInProgress(){
        Map<String,ProjectInProgress> projectInProgressMap = loadCsv.getProjectInProgress();
        return projectInProgressMap.get("合计");
    }

    /**
     * 获取计划项目合计情况
     * @return
     */
    public ProjectPlan getNewPlan(){
        Map<String,ProjectPlan> projectPlanMap = loadCsv.getProjectPlan();
        return projectPlanMap.get("合计");
    }

    /**
     * 获取预备项目合计情况
     * @return
     */
    public ProjectPrepare getNewPrepare(){
        Map<String,ProjectPrepare> projectPrepareMap = loadCsv.getProjectPrepare();
        return projectPrepareMap.get("合计");
    }

    /**
     * 获取责任部门列表
     * @return
     */
    public List<String> getOnDutyList(){
        Map<String,ProjectTotal> projectTotalMap = loadCsv.getProjectTotal();
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, ProjectTotal> entry : projectTotalMap.entrySet()) {
            result.add(entry.getKey());
        }
        result.remove("合计");
        return result;
    }

    /**
     * 重点项目数量分布
     * @return
     */
    public List<Object> getProjectTotalNum(){
        Map<String,ProjectTotal> projectTotalMap = loadCsv.getProjectTotal();
        List<String> onDutyList = getOnDutyList();
        List<Object> result = new ArrayList<>();
        for (String onDuty:onDutyList){
            if(projectTotalMap.get(onDuty)!=null) {
                result.add(projectTotalMap.get(onDuty).getTotalNum());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 重点项目投资分布
     * @return
     */
    public List<Object> getProjectTotalInvestment(){
        Map<String,ProjectTotal> projectTotalMap = loadCsv.getProjectTotal();
        List<String> onDutyList = getOnDutyList();
        List<Object> result = new ArrayList<>();
        for (String onDuty:onDutyList){
            if(projectTotalMap.get(onDuty)!=null) {
                result.add(projectTotalMap.get(onDuty).getTotalInvestment());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 计划项目完成投资情况
     * @return
     */
    public List<Object> getProjectPlanInvestmentCompleted(){
        Map<String,ProjectPlan> projectTotalMap = loadCsv.getProjectPlan();
        List<String> onDutyList = getOnDutyList();
        List<Object> result = new ArrayList<>();
        for (String onDuty:onDutyList){
            if(projectTotalMap.get(onDuty)!=null) {
                result.add(projectTotalMap.get(onDuty).getInvestmentCompleted());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 计划项目完成投资率
     * @return
     */
    public List<Object> getProjectPlanInvestmentCompletedRate(){
        Map<String,ProjectPlan> projectTotalMap = loadCsv.getProjectPlan();
        List<String> onDutyList = getOnDutyList();
        List<Object> result = new ArrayList<>();
        for (String onDuty:onDutyList){
            if(projectTotalMap.get(onDuty)!=null) {
                result.add(projectTotalMap.get(onDuty).getInvestmentCompletedRate());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 预备项目前期开工数
     * @return
     */
    public List<Object> getProjectPrepareTotalNum(){
        Map<String,ProjectPrepare> projectTotalMap = loadCsv.getProjectPrepare();
        List<String> onDutyList = getOnDutyList();
        List<Object> result = new ArrayList<>();
        for (String onDuty:onDutyList){
            if(projectTotalMap.get(onDuty)!=null) {
                result.add(projectTotalMap.get(onDuty).getTotalNum());
            } else {
                result.add("");
            }
        }
        return result;
    }

}
