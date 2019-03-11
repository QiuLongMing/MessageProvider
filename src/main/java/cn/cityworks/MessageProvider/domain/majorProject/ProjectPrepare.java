package cn.cityworks.MessageProvider.domain.majorProject;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 预备开工项目
 */
public class ProjectPrepare implements Serializable {

    @JsonIgnore
    private String onDuty;
    @JsonProperty(value = "项目总数")
    private String totalNum;
    @JsonProperty(value = "总投资")
    private String totalInvestment;

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

    public String getTotalInvestment() {
        return Utils.keepAfterTwo(totalInvestment);
    }

    public void setTotalInvestment(String totalInvestment) {
        this.totalInvestment = totalInvestment;
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
