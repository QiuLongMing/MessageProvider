package cn.cityworks.MessageProvider.service.index;

import cn.cityworks.MessageProvider.dao.LoadCsv;
import cn.cityworks.MessageProvider.domain.index.GDP;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GDPService {

    @Autowired
    private LoadCsv loadCsv;

    /**
     * 获取市生产总值
     * @param start
     * @param end
     * @return
     */
    public List<Object> getTotal(String start,String end){
        Map<String,GDP> gdpMap = loadCsv.getGDP();
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

    /**
     * 获取人均生产总值
     * @param start
     * @param end
     * @return
     */
    public List<Object> getPerCapita(String start,String end){
        Map<String,GDP> gdpMap = loadCsv.getGDP();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time).getPerCapita());
            } else {
                result.add("");
            }
        }
        return result;
    }

    /**
     * 获取三次产业结构
     * @return
     */
    public List<Object> getThreeIndustrialStructuresg(){
        Map<String,GDP> gdpMap = loadCsv.getGDP();
        List<Object> result = new ArrayList<>();
        GDP newOne = null;
        if(gdpMap.size()!=0){
            newOne = gdpMap.get("2017");
            for (Map.Entry<String, GDP> entry : gdpMap.entrySet()) {
                if(entry.getValue().getDate().compareTo(newOne.getDate())>0){
                    newOne = entry.getValue();
                }
            }
        }
        result.add(newOne.getPrimary());
        result.add(newOne.getSecondary());
        result.add(newOne.getTertiary());
        return result;
    }



}
