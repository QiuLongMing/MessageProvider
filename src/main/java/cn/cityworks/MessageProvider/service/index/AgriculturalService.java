package cn.cityworks.MessageProvider.service.index;

import cn.cityworks.MessageProvider.dao.LoadCsv;
import cn.cityworks.MessageProvider.domain.index.Agricultural;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AgriculturalService {

    @Autowired
    private LoadCsv loadCsv;

    /**
     * 获取农林牧渔生产总值
     * @param start
     * @param end
     * @return
     */
    public List<Object> getTotal(String start,String end){
        Map<String,Agricultural> gdpMap = loadCsv.getAgricultural();
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
