package cn.cityworks.MessageProvider.service.index;

import cn.cityworks.MessageProvider.dao.LoadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    @Autowired
    private LoadProperties loadProperties;

    public String getData(String proName){
        return loadProperties.getData("Index",proName);
    }

}
