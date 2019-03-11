package cn.cityworks.MessageProvider.dao;

import cn.cityworks.MessageProvider.domain.fixedInvestments.*;
import cn.cityworks.MessageProvider.domain.index.*;
import cn.cityworks.MessageProvider.domain.majorProject.ProjectInProgress;
import cn.cityworks.MessageProvider.domain.majorProject.ProjectPlan;
import cn.cityworks.MessageProvider.domain.majorProject.ProjectPrepare;
import cn.cityworks.MessageProvider.domain.majorProject.ProjectTotal;
import cn.cityworks.MessageProvider.utils.Utils;
import com.csvreader.CsvReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 读取Csv中的数据
 */
@Repository
public class LoadFixedInvestments {

    @Value("${spring.csvdatasource}")
    private String dataFile;

    /**
     * 获取固定资产投资完成额信息
     * @return
     */
    public Map<String,CompletedInvestmentInFixedAssets> getCompletedInvestmentInFixedAssets() {
        String filePath = dataFile + "CompletedInvestmentInFixedAssets.csv";
        Map<String,CompletedInvestmentInFixedAssets> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                CompletedInvestmentInFixedAssets obj = new CompletedInvestmentInFixedAssets();
                obj.setLocation(data[0]); //存入
                obj.setTotal(data[1]);
                obj.setProject(data[2]);
                obj.setRealEstate(data[3]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取项目投资完成情况
     * @return
     */
    public Map<String,ProjectInvestmentCompletionStatus> getProjectInvestmentCompletionStatus() {
        String filePath = dataFile + "ProjectInvestmentCompletionStatus.csv";
        Map<String,ProjectInvestmentCompletionStatus> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                ProjectInvestmentCompletionStatus obj = new ProjectInvestmentCompletionStatus();
                obj.setDate(Utils.StringToDate(data[0],"yyyy")); //存入
                obj.setPrimary(data[1]);
                obj.setSecondary(data[2]);
                obj.setTertiary(data[3]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取三次产业固定资产投资
     * @return
     */
    public Map<String,ThreeIndustrialFixedAssetsInvestment> getThreeIndustrialFixedAssetsInvestment() {
        String filePath = dataFile + "ThreeIndustrialFixedAssetsInvestment.csv";
        Map<String,ThreeIndustrialFixedAssetsInvestment> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                ThreeIndustrialFixedAssetsInvestment obj = new ThreeIndustrialFixedAssetsInvestment();
                obj.setDate(Utils.StringToDate(data[0],"yyyy")); //存入
                obj.setTotal(data[1]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取房地产开发投资情况
     * @return
     */
    public Map<String,RealEstateDevelopmentInvestment> getRealEstateDevelopmentInvestment() {
        String filePath = dataFile + "RealEstateDevelopmentInvestment.csv";
        Map<String,RealEstateDevelopmentInvestment> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                RealEstateDevelopmentInvestment obj = new RealEstateDevelopmentInvestment();
                obj.setDate(Utils.StringToDate(data[0],"yyyy")); //存入
                obj.setStateOwned(data[1]);
                obj.setCollectiveOwned(data[2]);
                obj.setOtherOwned(data[3]);
                obj.setHousesForBusinessUse(data[4]);
                obj.setResidence(data[5]);
                obj.setOfficBuilding(data[6]);
                obj.setOther(data[7]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取房地产开发指标
     * @return
     */
    public Map<String,IndicatorsOfRealEstateDevelopment> getIndicatorsOfRealEstateDevelopment() {
        String filePath = dataFile + "IndicatorsOfRealEstateDevelopment.csv";
        Map<String,IndicatorsOfRealEstateDevelopment> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                IndicatorsOfRealEstateDevelopment obj = new IndicatorsOfRealEstateDevelopment();
                obj.setName(data[0]); //存入
                obj.setTotal(data[1]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取房地产开发财务指标
     * @return
     */
    public Map<String,RealEstateDevelopmentFinancialIndicators> getRealEstateDevelopmentFinancialIndicators() {
        String filePath = dataFile + "RealEstateDevelopmentFinancialIndicators.csv";
        Map<String,RealEstateDevelopmentFinancialIndicators> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                RealEstateDevelopmentFinancialIndicators obj = new RealEstateDevelopmentFinancialIndicators();
                obj.setName(data[0]); //存入
                obj.setEnterpriseNum(data[1]);
                obj.setEmployeesNum(data[2]);
                obj.setProperty(data[3]);
                obj.setCurrentAsset(data[4]);
                obj.setDebtAccumulated(data[5]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
