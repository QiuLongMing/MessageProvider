package cn.cityworks.MessageProvider.domain.majorProject;

import cn.cityworks.MessageProvider.utils.Utils;

import java.io.Serializable;

/**
 * 项目在建情况
 */
public class ProjectInInvestmentProportion implements Serializable {

    private String type;
    private String totalInvestment;
    private String investmentRate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTotalInvestment() {
        return Utils.keepAfterTwo(totalInvestment);
    }

    public void setTotalInvestment(String totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public String getInvestmentRate() {
        return Utils.keepAfterTwo(investmentRate);
    }

    public void setInvestmentRate(String investmentRate) {
        this.investmentRate = investmentRate;
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
