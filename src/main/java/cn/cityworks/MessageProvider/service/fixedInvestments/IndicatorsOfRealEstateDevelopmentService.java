package cn.cityworks.MessageProvider.service.fixedInvestments;

import cn.cityworks.MessageProvider.dao.LoadFixedInvestments;
import cn.cityworks.MessageProvider.domain.fixedInvestments.IndicatorsOfRealEstateDevelopment;
import cn.cityworks.MessageProvider.domain.fixedInvestments.ThreeIndustrialFixedAssetsInvestment;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IndicatorsOfRealEstateDevelopmentService {

    @Autowired
    private LoadFixedInvestments loadFixedInvestments;

    /**
     * 获取房地产开发总指标
     * @return
     */
    public IndicatorsOfRealEstateDevelopment getTotal(){
        Map<String,IndicatorsOfRealEstateDevelopment> map = loadFixedInvestments.getIndicatorsOfRealEstateDevelopment();
        return map.get("总计");
    }

    /**
     * 获取指标名称列表
     * @return
     */
    public List<String> getNameList(){
        Map<String,IndicatorsOfRealEstateDevelopment> map = loadFixedInvestments.getIndicatorsOfRealEstateDevelopment();
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, IndicatorsOfRealEstateDevelopment> entry : map.entrySet()) {
            result.add(entry.getKey());
        }
        result.remove("总计");
        return result;
    }

    /**
     * 获取房地产开发指标
     * @return
     */
    public List<Object> getIndicators(){
        Map<String,IndicatorsOfRealEstateDevelopment> map = loadFixedInvestments.getIndicatorsOfRealEstateDevelopment();
        List<String> locationList = getNameList();
        List<Object> result = new ArrayList<>();
        for (String onDuty:locationList){
            if(map.get(onDuty)!=null) {
                result.add(map.get(onDuty).getTotal());
            } else {
                result.add("");
            }
        }
        return result;
    }

}
