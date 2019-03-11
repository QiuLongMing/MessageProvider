package cn.cityworks.MessageProvider.service.fixedInvestments;

import cn.cityworks.MessageProvider.dao.LoadFixedInvestments;
import cn.cityworks.MessageProvider.domain.fixedInvestments.CompletedInvestmentInFixedAssets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompletedInvestmentInFixedAssetsService {

    @Autowired
    private LoadFixedInvestments loadFixedInvestments;

    /**
     * 获取固定资产投资完成额概况
     * @return
     */
    public Map<String,Object> getStatistics(){
        Map<String,CompletedInvestmentInFixedAssets> completedInvestmentInFixedAssetsMap = loadFixedInvestments.getCompletedInvestmentInFixedAssets();
        CompletedInvestmentInFixedAssets completedInvestmentInFixedAssets = completedInvestmentInFixedAssetsMap.get("福州市");
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("总投资额",completedInvestmentInFixedAssets.getTotal());
        map.put("房地产开发投资额",completedInvestmentInFixedAssets.getRealEstate());
        return map;
    }


    /**
     * 获取区县列表
     * @return
     */
    public List<String> getLocationList(){
        Map<String,CompletedInvestmentInFixedAssets> projectTotalMap = loadFixedInvestments.getCompletedInvestmentInFixedAssets();
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, CompletedInvestmentInFixedAssets> entry : projectTotalMap.entrySet()) {
            result.add(entry.getKey());
        }
        result.remove("福州市");
        result.remove("市区");
        return result;
    }

    /**
     * 固定资产投资完成额分布
     * @return
     */
    public List<Object> getInvestmentTotalNum(){
        Map<String,CompletedInvestmentInFixedAssets> projectTotalMap = loadFixedInvestments.getCompletedInvestmentInFixedAssets();
        List<String> locationList = getLocationList();
        List<Object> result = new ArrayList<>();
        for (String onDuty:locationList){
            if(projectTotalMap.get(onDuty)!=null) {
                result.add(projectTotalMap.get(onDuty).getTotal());
            } else {
                result.add("");
            }
        }
        return result;
    }

}
