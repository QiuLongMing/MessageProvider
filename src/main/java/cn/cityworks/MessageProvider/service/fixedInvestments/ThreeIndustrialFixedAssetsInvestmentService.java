package cn.cityworks.MessageProvider.service.fixedInvestments;

import cn.cityworks.MessageProvider.dao.LoadFixedInvestments;
import cn.cityworks.MessageProvider.domain.fixedInvestments.ProjectInvestmentCompletionStatus;
import cn.cityworks.MessageProvider.domain.fixedInvestments.ThreeIndustrialFixedAssetsInvestment;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ThreeIndustrialFixedAssetsInvestmentService {

    @Autowired
    private LoadFixedInvestments loadFixedInvestments;

    /**
     * 获取三次产业固定资产投资
     * @param start
     * @param end
     * @return
     */
    public List<Object> getInvestment(String start,String end){
        Map<String,ThreeIndustrialFixedAssetsInvestment> gdpMap = loadFixedInvestments.getThreeIndustrialFixedAssetsInvestment();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time).getTotal());
            } else {
                result.add("");
            }
        }
        return result;
    }

}
