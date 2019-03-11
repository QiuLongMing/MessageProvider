package cn.cityworks.MessageProvider.domain.index;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 城乡居民可支配收入
 */
public class PCDI implements Serializable {

    private Date date;
    private String towner;
    private String country;


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

    public String getTowner() {
        return Utils.keepAfterTwo(towner);
    }

    public void setTowner(String towner) {
        this.towner = towner;
    }

    public String getCountry() {
        return Utils.keepAfterTwo(country);
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
