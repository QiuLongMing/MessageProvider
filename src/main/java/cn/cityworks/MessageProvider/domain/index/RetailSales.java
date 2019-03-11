package cn.cityworks.MessageProvider.domain.index;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 消费品零售总额
 */
public class RetailSales implements Serializable {

    @JsonProperty(value = "年份")
    private Date date;
    @JsonProperty(value = "消费品零售总额")
    private String total;

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

    public String getTotal() {
        return Utils.keepAfterTwo(total);
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
