package cn.cityworks.MessageProvider.service.index;

import cn.cityworks.MessageProvider.domain.index.ProjectConstruction;
import cn.cityworks.MessageProvider.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class ProjectConstructionService {

    /**
     * 获取最新的外贸信息
     * @return
     */
    public ProjectConstruction findNew(){
        ProjectConstruction newOne = new ProjectConstruction();
        newOne.setDate(Utils.StringToDate("2017","yyyy"));
        newOne.setTotalNum("792");
        newOne.setTotalInvestment("16395.18");
        newOne.setTotalInvestmentGrowthRate("7.11");
        newOne.setPlanInvestment("2833.1");
        newOne.setPlanInvestmentGrowthRate("-14.30");
        return newOne;
    }

}
