package cn.cityworks.MessageProvider.domain.fixedInvestments;

import cn.cityworks.MessageProvider.utils.Utils;

import java.io.Serializable;
import java.util.Date;

/**
 * 三次产业固定资产投资
 */
public class ThreeIndustrialFixedAssetsInvestment implements Serializable {

    private Date date;
    private String total;

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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
