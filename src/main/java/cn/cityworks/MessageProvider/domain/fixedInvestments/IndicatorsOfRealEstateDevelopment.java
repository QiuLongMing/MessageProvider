package cn.cityworks.MessageProvider.domain.fixedInvestments;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 房地产开发指标
 */
public class IndicatorsOfRealEstateDevelopment implements Serializable {

    @JsonProperty("指标名称")
    private String name;
    @JsonProperty("计划总投资")
    private String total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return Utils.keepAfterTwo(total);
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
