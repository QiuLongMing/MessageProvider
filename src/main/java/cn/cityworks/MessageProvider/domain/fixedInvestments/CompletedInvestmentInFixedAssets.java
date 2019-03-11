package cn.cityworks.MessageProvider.domain.fixedInvestments;

import cn.cityworks.MessageProvider.utils.Utils;

import java.io.Serializable;

/**
 * 固定资产投资完成额
 */
public class CompletedInvestmentInFixedAssets implements Serializable {

    private String location;
    private String total;
    private String project;
    private String RealEstate;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTotal() {
        return Utils.keepAfterTwo(total);
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getProject() {
        return Utils.keepAfterTwo(project);
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRealEstate() {
        return Utils.keepAfterTwo(RealEstate);
    }

    public void setRealEstate(String realEstate) {
        RealEstate = realEstate;
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
