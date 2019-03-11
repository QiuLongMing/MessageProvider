package cn.cityworks.MessageProvider.domain.fixedInvestments;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 房地产开发财务指标
 */
public class RealEstateDevelopmentFinancialIndicators implements Serializable {

    @JsonIgnore
    private String name;
    @JsonProperty("企业数")
    private String enterpriseNum;
    @JsonProperty("年末从业人数")
    private String employeesNum;
    @JsonProperty("资产总计")
    private String property;
    @JsonProperty("流动资产合计")
    private String currentAsset;
    @JsonProperty("负债合计")
    private String debtAccumulated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnterpriseNum() {
        return enterpriseNum;
    }

    public void setEnterpriseNum(String enterpriseNum) {
        this.enterpriseNum = enterpriseNum;
    }

    public String getEmployeesNum() {
        return employeesNum;
    }

    public void setEmployeesNum(String employeesNum) {
        this.employeesNum = employeesNum;
    }

    public String getProperty() {
        return Utils.keepAfterTwo(property);
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCurrentAsset() {
        return Utils.keepAfterTwo(currentAsset);
    }

    public void setCurrentAsset(String currentAsset) {
        this.currentAsset = currentAsset;
    }

    public String getDebtAccumulated() {
        return Utils.keepAfterTwo(debtAccumulated);
    }

    public void setDebtAccumulated(String debtAccumulated) {
        this.debtAccumulated = debtAccumulated;
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
