package cn.cityworks.MessageProvider.routes.TrafficProject;

import cn.cityworks.MessageProvider.service.TrafficProject.TrafficProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/getTrafficProject")
public class TrafficProjectController {

    @Autowired
    private TrafficProjectService trafficProjectService;

    @RequestMapping(value = "/getData", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getTotalStatus(@RequestParam String target) {
        return trafficProjectService.getData(target);
    }

}
