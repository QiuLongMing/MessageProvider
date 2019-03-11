package cn.cityworks.MessageProvider.service.TrafficProject;

import cn.cityworks.MessageProvider.dao.LoadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrafficProjectService {

    @Autowired
    private LoadProperties loadProperties;

    public String getData(String proName){
        return loadProperties.getData("TrafficProject",proName);
    }

}
