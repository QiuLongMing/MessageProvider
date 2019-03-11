package cn.cityworks.MessageProvider.domain.majorProject;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 项目在建情况
 */
public class ProjectInProgress implements Serializable {

    @JsonIgnore
    private String onDuty;
    @JsonProperty(value = "项目总数")
    private String totalNum;
    @JsonProperty(value = "年计划投资")
    private String yearPlanInvestment;
    @JsonProperty(value = "完成投资")
    private String investmentCompleted;
    @JsonProperty(value = "完成投资比例")
    private String investmentCompletedRate;
    @JsonProperty(value = "计划建成或部分建成数")
    private String planCompleted;
    @JsonProperty(value = "实际建成或部分建成数")
    private String actuallyCompleted;
    @JsonProperty(value = "建成率")
    private String completedRate;

    public String getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(String onDuty) {
        this.onDuty = onDuty;
    }

    public String getTotalNum() {
        return Utils.keepAfterTwo(totalNum);
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public String getYearPlanInvestment() {
        return Utils.keepAfterTwo(yearPlanInvestment);
    }

    public void setYearPlanInvestment(String yearPlanInvestment) {
        this.yearPlanInvestment = yearPlanInvestment;
    }

    public String getInvestmentCompleted() {
        return Utils.keepAfterTwo(investmentCompleted);
    }

    public void setInvestmentCompleted(String investmentCompleted) {
        this.investmentCompleted = investmentCompleted;
    }

    public String getInvestmentCompletedRate() {
        return Utils.keepAfterTwo(investmentCompletedRate);
    }

    public void setInvestmentCompletedRate(String investmentCompletedRate) {
        this.investmentCompletedRate = investmentCompletedRate;
    }

    public String getPlanCompleted() {
        return Utils.keepAfterTwo(planCompleted);
    }

    public void setPlanCompleted(String planCompleted) {
        this.planCompleted = planCompleted;
    }

    public String getActuallyCompleted() {
        return Utils.keepAfterTwo(actuallyCompleted);
    }

    public void setActuallyCompleted(String actuallyCompleted) {
        this.actuallyCompleted = actuallyCompleted;
    }

    public String getCompletedRate() {
        return Utils.keepAfterTwo(completedRate);
    }

    public void setCompletedRate(String completedRate) {
        this.completedRate = completedRate;
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
