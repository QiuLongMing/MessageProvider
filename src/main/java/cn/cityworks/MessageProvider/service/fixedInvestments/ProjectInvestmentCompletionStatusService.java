package cn.cityworks.MessageProvider.service.fixedInvestments;

import cn.cityworks.MessageProvider.dao.LoadFixedInvestments;
import cn.cityworks.MessageProvider.domain.fixedInvestments.ProjectInvestmentCompletionStatus;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProjectInvestmentCompletionStatusService {

    @Autowired
    private LoadFixedInvestments loadFixedInvestments;

    /**
     * 获取第一产业投资完成情况
     * @param start
     * @param end
     * @return
     */
    public List<Object> getPrimary(String start,String end){
        Map<String,ProjectInvestmentCompletionStatus> gdpMap = loadFixedInvestments.getProjectInvestmentCompletionStatus();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time).getPrimary());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 获取第二产业投资完成情况
     * @param start
     * @param end
     * @return
     */
    public List<Object> getSecondary(String start,String end){
        Map<String,ProjectInvestmentCompletionStatus> gdpMap = loadFixedInvestments.getProjectInvestmentCompletionStatus();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time).getSecondary());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 获取第三产业投资完成情况
     * @param start
     * @param end
     * @return
     */
    public List<Object> getTertiary(String start,String end){
        Map<String,ProjectInvestmentCompletionStatus> gdpMap = loadFixedInvestments.getProjectInvestmentCompletionStatus();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time).getTertiary());
            } else {
                result.add("");
            }
        }
        return result;
    }


}
