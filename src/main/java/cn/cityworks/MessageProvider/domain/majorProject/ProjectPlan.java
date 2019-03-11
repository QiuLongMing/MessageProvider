package cn.cityworks.MessageProvider.domain.majorProject;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 计划新建项目
 */
public class ProjectPlan implements Serializable {

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
    @JsonProperty(value = "实际开工数")
    private String actualStart;
    @JsonProperty(value = "开工率")
    private String actualStartRate;

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getActualStart() {
        return Utils.keepAfterTwo(actualStart);
    }

    public void setActualStart(String actualStart) {
        this.actualStart = actualStart;
    }

    public String getActualStartRate() {
        return Utils.keepAfterTwo(actualStartRate);
    }

    public void setActualStartRate(String actualStartRate) {
        this.actualStartRate = actualStartRate;
    }
}
