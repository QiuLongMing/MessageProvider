package cn.cityworks.MessageProvider.service.majorProject;

import cn.cityworks.MessageProvider.dao.LoadCsv;
import cn.cityworks.MessageProvider.domain.majorProject.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProjectInInvestmentProportionService {

    @Autowired
    private LoadCsv loadCsv;

    /**
     * 获取行业列表
     * @return
     */
    public List<String> getTypeList(){
        Map<String,ProjectInInvestmentProportion> map = loadCsv.getProjectInInvestmentProportion();
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, ProjectInInvestmentProportion> entry : map.entrySet()) {
            result.add(entry.getKey());
        }
        result.remove("合计");
        return result;
    }

    /**
     * 总投资值
     * @return
     */
    public List<Object> getTotalInvestment(){
        Map<String,ProjectInInvestmentProportion> map = loadCsv.getProjectInInvestmentProportion();
        List<String> list = getTypeList();
        List<Object> result = new ArrayList<>();
        for (String type:list){
            if(map.get(type)!=null) {
                result.add(map.get(type).getTotalInvestment());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 计划投资占比
     * @return
     */
    public List<Object> getInvestmentRate(){
        Map<String,ProjectInInvestmentProportion> map = loadCsv.getProjectInInvestmentProportion();
        List<String> list = getTypeList();
        List<Object> result = new ArrayList<>();
        for (String type:list){
            if(map.get(type)!=null) {
                result.add(map.get(type).getInvestmentRate());
            } else {
                result.add("");
            }
        }
        return result;
    }


}
