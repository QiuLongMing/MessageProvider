package cn.cityworks.MessageProvider.routes.BuildLand;

import cn.cityworks.MessageProvider.service.BuildLand.BuildLandService;
import cn.cityworks.MessageProvider.service.TrafficProject.TrafficProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/getBuildLand")
public class BuildLandController {

    @Autowired
    private BuildLandService buildLandService;

    @RequestMapping(value = "/getData", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getTotalStatus(@RequestParam String target) {
        return buildLandService.getData(target);
    }

}
