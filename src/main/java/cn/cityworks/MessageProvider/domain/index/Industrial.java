package cn.cityworks.MessageProvider.domain.index;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 工业
 */
public class Industrial implements Serializable {

    private Date date;
    private String total;
    private String aboveDesignatedSize;

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

    public String getAboveDesignatedSize() {
        return Utils.keepAfterTwo(aboveDesignatedSize);
    }

    public void setAboveDesignatedSize(String aboveDesignatedSize) {
        this.aboveDesignatedSize = aboveDesignatedSize;
    }
}
