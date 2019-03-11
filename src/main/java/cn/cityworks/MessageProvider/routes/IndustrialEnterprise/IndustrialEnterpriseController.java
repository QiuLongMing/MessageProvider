package cn.cityworks.MessageProvider.routes.IndustrialEnterprise;

import cn.cityworks.MessageProvider.service.IndustrialEnterprise.IndustrialEnterpriseService;
import cn.cityworks.MessageProvider.service.Overview.OverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/getIndustrialEnterprise")
public class IndustrialEnterpriseController {

    @Autowired
    private IndustrialEnterpriseService industrialEnterpriseService;

    @RequestMapping(value = "/getData", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getTotalStatus(@RequestParam String target) {
        return industrialEnterpriseService.getData(target);
    }

}
