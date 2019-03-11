package cn.cityworks.MessageProvider.routes.index;

import cn.cityworks.MessageProvider.service.index.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/getIndex")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/getData", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getTotalStatus(@RequestParam String target) {
        return indexService.getData(target);
    }

}
