package cn.cityworks.MessageProvider.service.index;

import cn.cityworks.MessageProvider.dao.LoadCsv;
import cn.cityworks.MessageProvider.domain.index.RetailSales;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RetailSalesService {

    @Autowired
    private LoadCsv loadCsv;

    /**
     * 获取消费品零售总额
     * @param start
     * @param end
     * @return
     */
    public List<Object> getTotal(String start,String end){
        Map<String,RetailSales> gdpMap = loadCsv.getRetailSales();
        List<String> times = Utils.getTimeList(start,end);
        List<Object> result = new ArrayList<>();
        for (String time:times){
            if(gdpMap.get(time)!=null) {
                result.add(gdpMap.get(time));
            }
        }
        return result;
    }


}
