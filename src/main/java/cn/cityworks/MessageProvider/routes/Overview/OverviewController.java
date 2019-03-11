package cn.cityworks.MessageProvider.routes.Overview;

import cn.cityworks.MessageProvider.service.Overview.OverviewService;
import cn.cityworks.MessageProvider.service.TrafficProject.TrafficProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/getOverview")
public class OverviewController {

    @Autowired
    private OverviewService overviewService;

    @RequestMapping(value = "/getData", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getTotalStatus(@RequestParam String target) {
        return overviewService.getData(target);
    }

}
