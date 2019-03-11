package cn.cityworks.MessageProvider.service.index;

import cn.cityworks.MessageProvider.dao.LoadCsv;
import cn.cityworks.MessageProvider.domain.index.PCDI;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PCDIService {

    @Autowired
    private LoadCsv loadCsv;

    /**
     * 获取城镇居民可支配收入
     * @param start
     * @param end
     * @return
     */
    public List<Object> getTowner(String start,String end){
        Map<String,PCDI> gdpMap = loadCsv.getPCDI();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time).getTowner());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 获取乡村居民可支配收入
     * @param start
     * @param end
     * @return
     */
    public List<Object> getCountry(String start,String end){
        Map<String,PCDI> gdpMap = loadCsv.getPCDI();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time).getCountry());
            } else {
                result.add("");
            }
        }
        return result;
    }


}
