package cn.cityworks.MessageProvider.routes.index;

import cn.cityworks.MessageProvider.service.index.ProjectConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/getProjectConstruction")
public class ProjectConstructionController {

    @Autowired
    private ProjectConstructionService projectConstructionService;


    @RequestMapping
    @ResponseBody
    public Object getExportTrade(){
        return projectConstructionService.findNew();
    }

}
