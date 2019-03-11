package cn.cityworks.MessageProvider.domain.index;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class GDP implements Serializable {

    private Date date;
    private String total;
    private String perCapita;
    private String primary;
    private String secondary;
    private String tertiary;

    @JsonFormat(pattern="yyyy",timezone = "GMT+8")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTotal() {
        return Utils.keepAfterTwo(total);
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPerCapita() {
        return Utils.keepAfterTwo(perCapita);
    }

    public void setPerCapita(String perCapita) {
        this.perCapita = perCapita;
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
