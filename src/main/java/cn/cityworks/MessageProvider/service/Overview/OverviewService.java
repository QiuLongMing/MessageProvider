package cn.cityworks.MessageProvider.service.Overview;

import cn.cityworks.MessageProvider.dao.LoadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverviewService {

    @Autowired
    private LoadProperties loadProperties;

    public String getData(String proName){
        return loadProperties.getData("Overview",proName);
    }

}
