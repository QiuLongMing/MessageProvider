package cn.cityworks.MessageProvider.routes.fixedInvestments;

import cn.cityworks.MessageProvider.service.fixedInvestments.RealEstateDevelopmentFinancialIndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/getRealEstateFinancial")
public class RealEstateDevelopmentFinancialIndicatorsController {

    @Autowired
    private RealEstateDevelopmentFinancialIndicatorsService service;


    @RequestMapping
    @ResponseBody
    public Object getTotal(){
        return service.getTotal();
    }

}
