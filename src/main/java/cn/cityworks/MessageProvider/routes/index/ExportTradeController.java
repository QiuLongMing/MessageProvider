package cn.cityworks.MessageProvider.routes.index;

import cn.cityworks.MessageProvider.service.index.ExportTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/getExportTrade")
public class ExportTradeController {

    @Autowired
    private ExportTradeService exportTradeService;


    @RequestMapping
    @ResponseBody
    public Object getExportTrade(){
        return exportTradeService.findNew();
    }

}
