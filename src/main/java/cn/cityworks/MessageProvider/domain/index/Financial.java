package cn.cityworks.MessageProvider.domain.index;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 一般公共预算
 */
public class Financial implements Serializable {

    private Date date;
    private String totalPublicBudgetRevenue;
    private String publicBudgetRevenue;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @JsonFormat(pattern="yyyy",timezone = "GMT+8")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTotalPublicBudgetRevenue() {
        return Utils.keepAfterTwo(totalPublicBudgetRevenue);
    }

    public void setTotalPublicBudgetRevenue(String totalPublicBudgetRevenue) {
        this.totalPublicBudgetRevenue = totalPublicBudgetRevenue;
    }

    public String getPublicBudgetRevenue() {
        return Utils.keepAfterTwo(publicBudgetRevenue);
    }

    public void setPublicBudgetRevenue(String publicBudgetRevenue) {
        this.publicBudgetRevenue = publicBudgetRevenue;
    }
}
