package cn.cityworks.MessageProvider.service.fixedInvestments;

import cn.cityworks.MessageProvider.dao.LoadFixedInvestments;
import cn.cityworks.MessageProvider.domain.fixedInvestments.ProjectInvestmentCompletionStatus;
import cn.cityworks.MessageProvider.domain.fixedInvestments.RealEstateDevelopmentInvestment;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RealEstateDevelopmentInvestmentService {

    @Autowired
    private LoadFixedInvestments loadFixedInvestments;

    /**
     * 房地产开发投资情况-按经济类型划分
     * @return
     */
    public List<Object> getEconomicType(String year){
        Map<String,RealEstateDevelopmentInvestment> map = loadFixedInvestments.getRealEstateDevelopmentInvestment();
        List<Object> result = new ArrayList<>();
        RealEstateDevelopmentInvestment realEstateDevelopmentInvestment = map.get(year);
        result.add(realEstateDevelopmentInvestment.getStateOwned());
        result.add(realEstateDevelopmentInvestment.getCollectiveOwned());
        result.add(realEstateDevelopmentInvestment.getOtherOwned());
        return result;
    }

    /**
     * 房地产开发投资情况-按工程用途划分
     * @param start
     * @param end
     * @return
     */
    public Map<String, Object> getByEP(String start,String end){
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        Map<String,RealEstateDevelopmentInvestment> gdpMap = loadFixedInvestments.getRealEstateDevelopmentInvestment();
        List<String> times = Utils.getTimeList(start,end);
        Collections.reverse(times);
        for (String time:times){
            List<Object> result = new ArrayList<>();
            if(gdpMap.get(time)!=null) {
                result.add(time);
                result.add(gdpMap.get(time).getHousesForBusinessUse());
                result.add(gdpMap.get(time).getResidence());
                result.add(gdpMap.get(time).getOfficBuilding());
                result.add(gdpMap.get(time).getOther());
            } else {
                result.add("");
            }
            data.put(time,result);
        }
        return data;
    }

}
