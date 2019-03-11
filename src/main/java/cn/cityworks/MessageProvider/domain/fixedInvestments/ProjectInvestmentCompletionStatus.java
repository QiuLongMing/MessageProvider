package cn.cityworks.MessageProvider.domain.fixedInvestments;

import cn.cityworks.MessageProvider.utils.Utils;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目投资完成情况
 */
public class ProjectInvestmentCompletionStatus implements Serializable {

    private Date date;
    private String primary;
    private String secondary;
    private String tertiary;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrimary() {
        return Utils.keepAfterTwo(primary);
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getSecondary() {
        return Utils.keepAfterTwo(secondary);
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getTertiary() {
        return Utils.keepAfterTwo(tertiary);
    }

    public void setTertiary(String tertiary) {
        this.tertiary = tertiary;
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
