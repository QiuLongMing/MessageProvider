package cn.cityworks.MessageProvider.service.IndustrialEnterprise;

import cn.cityworks.MessageProvider.dao.LoadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndustrialEnterpriseService {

    @Autowired
    private LoadProperties loadProperties;

    public String getData(String proName){
        return loadProperties.getData("IndustrialEnterprise",proName);
    }

}
