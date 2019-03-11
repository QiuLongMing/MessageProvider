package cn.cityworks.MessageProvider.domain.index;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 重点项目建设
 */
public class ProjectConstruction implements Serializable {

    @JsonProperty(value = "年份")
    private Date date;
    @JsonProperty(value = "投资项目数")
    private String totalNum;
    @JsonProperty(value = "总投资")
    private String totalInvestment;
    @JsonProperty(value = "总投资增长率")
    private String totalInvestmentGrowthRate;
    @JsonProperty(value = "年计划总投资")
    private String planInvestment;
    @JsonProperty(value = "年计划总投资增长率")
    private String planInvestmentGrowthRate;

    @JsonFormat(pattern="yyyy",timezone = "GMT+8")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTotalNum() {
        return Utils.keepAfterTwo(totalNum);
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public String getTotalInvestment() {
        return Utils.keepAfterTwo(totalInvestment);
    }

    public void setTotalInvestment(String totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public String getTotalInvestmentGrowthRate() {
        return Utils.keepAfterTwo(totalInvestmentGrowthRate);
    }

    public void setTotalInvestmentGrowthRate(String totalInvestmentGrowthRate) {
        this.totalInvestmentGrowthRate = totalInvestmentGrowthRate;
    }

    public String getPlanInvestment() {
        return Utils.keepAfterTwo(planInvestment);
    }

    public void setPlanInvestment(String planInvestment) {
        this.planInvestment = planInvestment;
    }

    public String getPlanInvestmentGrowthRate() {
        return Utils.keepAfterTwo(planInvestmentGrowthRate);
    }

    public void setPlanInvestmentGrowthRate(String planInvestmentGrowthRate) {
        this.planInvestmentGrowthRate = planInvestmentGrowthRate;
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
