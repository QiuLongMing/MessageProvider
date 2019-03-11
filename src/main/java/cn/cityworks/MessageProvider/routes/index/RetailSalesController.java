package cn.cityworks.MessageProvider.routes.index;

import cn.cityworks.MessageProvider.service.index.RetailSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/getRetailSales")
public class RetailSalesController {

    @Autowired
    private RetailSalesService retailSalesService;


    @RequestMapping
    @ResponseBody
    public Object getRetailSales(@RequestParam(defaultValue = "2013",required = false) String start, @RequestParam(defaultValue = "now",required = false) String end){
        return retailSalesService.getTotal(start,end);
    }

}
