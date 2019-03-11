package cn.cityworks.MessageProvider.service.fixedInvestments;

import cn.cityworks.MessageProvider.dao.LoadFixedInvestments;
import cn.cityworks.MessageProvider.domain.fixedInvestments.IndicatorsOfRealEstateDevelopment;
import cn.cityworks.MessageProvider.domain.fixedInvestments.RealEstateDevelopmentFinancialIndicators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RealEstateDevelopmentFinancialIndicatorsService {

    @Autowired
    private LoadFixedInvestments loadFixedInvestments;

    /**
     * 获取房地产开发财务指标
     * @return
     */
    public RealEstateDevelopmentFinancialIndicators getTotal(){
        Map<String,RealEstateDevelopmentFinancialIndicators> map = loadFixedInvestments.getRealEstateDevelopmentFinancialIndicators();
        return map.get("总计");
    }


}
