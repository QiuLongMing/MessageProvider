package cn.cityworks.MessageProvider.service.index;

import cn.cityworks.MessageProvider.dao.LoadCsv;
import cn.cityworks.MessageProvider.domain.index.Financial;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FinancialService {

    @Autowired
    private LoadCsv loadCsv;

    /**
     * 获取一般公共预算总收入
     * @param start
     * @param end
     * @return
     */
    public List<Object> getTotalPublicBudgetRevenue(String start,String end){
        Map<String,Financial> gdpMap = loadCsv.getFinancial();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time).getTotalPublicBudgetRevenue());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 获取一般公共预算收入
     * @param start
     * @param end
     * @return
     */
    public List<Object> getPublicBudgetRevenue(String start,String end){
        Map<String,Financial> gdpMap = loadCsv.getFinancial();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time).getPublicBudgetRevenue());
            } else {
                result.add("");
            }
        }
        return result;
    }


}
