package cn.cityworks.MessageProvider.service.index;

import cn.cityworks.MessageProvider.dao.LoadCsv;
import cn.cityworks.MessageProvider.domain.index.ExportTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExportTradeService {

    @Autowired
    private LoadCsv loadCsv;

    /**
     * 获取最新的外贸信息
     * @return
     */
    public ExportTrade findNew(){
        Map<String,ExportTrade> exportTradeMap = loadCsv.getExportTrade();
        ExportTrade newOne = null;
        if(exportTradeMap.size()!=0){
            newOne = exportTradeMap.get("2017");
            for (Map.Entry<String, ExportTrade> entry : exportTradeMap.entrySet()) {
                if(entry.getValue().getDate().compareTo(newOne.getDate())>0){
                    newOne = entry.getValue();
                }
            }
        }
        return newOne;
    }

}
