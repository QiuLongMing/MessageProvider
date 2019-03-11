package cn.cityworks.MessageProvider.domain.fixedInvestments;

import cn.cityworks.MessageProvider.utils.Utils;

import java.io.Serializable;
import java.util.Date;

/**
 * 房地产开发投资情况
 */
public class RealEstateDevelopmentInvestment implements Serializable {

    private Date date;
    private String stateOwned;
    private String collectiveOwned;
    private String otherOwned;
    private String housesForBusinessUse;
    private String residence;
    private String officBuilding;
    private String other;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStateOwned() {
        return Utils.keepAfterTwo(stateOwned);
    }

    public void setStateOwned(String stateOwned) {
        this.stateOwned = stateOwned;
    }

    public String getCollectiveOwned() {
        return Utils.keepAfterTwo(collectiveOwned);
    }

    public void setCollectiveOwned(String collectiveOwned) {
        this.collectiveOwned = collectiveOwned;
    }

    public String getOtherOwned() {
        return Utils.keepAfterTwo(otherOwned);
    }

    public void setOtherOwned(String otherOwned) {
        this.otherOwned = otherOwned;
    }

    public String getHousesForBusinessUse() {
        return Utils.keepAfterTwo(housesForBusinessUse);
    }

    public void setHousesForBusinessUse(String housesForBusinessUse) {
        this.housesForBusinessUse = housesForBusinessUse;
    }

    public String getResidence() {
        return Utils.keepAfterTwo(residence);
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getOfficBuilding() {
        return Utils.keepAfterTwo(officBuilding);
    }

    public void setOfficBuilding(String officBuilding) {
        this.officBuilding = officBuilding;
    }

    public String getOther() {
        return Utils.keepAfterTwo(other);
    }

    public void setOther(String other) {
        this.other = other;
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
