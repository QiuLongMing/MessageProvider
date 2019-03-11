package cn.cityworks.MessageProvider.domain.index;

import cn.cityworks.MessageProvider.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Date;

/**
 * 进出口数据
 */
public class ExportTrade implements Serializable {

    @JsonProperty(value = "年份")
    private Date date;
    @JsonProperty(value = "进出口总额")
    private String totalExportImportVolume;
    @JsonProperty(value = "出口总额")
    private String totalExport;


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

    public String getTotalExportImportVolume() {
        return Utils.keepAfterTwo(totalExportImportVolume);
    }

    public void setTotalExportImportVolume(String totalExportImportVolume) {
        this.totalExportImportVolume = totalExportImportVolume;
    }

    public String getTotalExport() {
        return Utils.keepAfterTwo(totalExport);
    }

    public void setTotalExport(String totalExport) {
        this.totalExport = totalExport;
    }
}
