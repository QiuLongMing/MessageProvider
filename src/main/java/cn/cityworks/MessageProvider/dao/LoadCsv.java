package cn.cityworks.MessageProvider.dao;

import cn.cityworks.MessageProvider.domain.index.*;
import cn.cityworks.MessageProvider.domain.majorProject.*;
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
public class LoadCsv {

    @Value("${spring.csvdatasource}")
    private String dataFile;

    /**
     * 获取外贸信息
     * @return
     */
    public Map<String,ExportTrade> getExportTrade() {
        String filePath = dataFile + "ExportTrade.csv";
        Map<String,ExportTrade> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                ExportTrade obj = new ExportTrade();
                obj.setDate(Utils.StringToDate(data[0],"yyyy")); //存入
                obj.setTotalExportImportVolume(data[1]);
                obj.setTotalExport(data[2]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取GDP信息
     * @return
     */
    public Map<String,GDP> getGDP() {
        String filePath = dataFile + "GDP.csv";
        Map<String,GDP> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                GDP obj = new GDP();
                obj.setDate(Utils.StringToDate(data[0],"yyyy")); //存入
                obj.setTotal(data[1]);
                obj.setPrimary(data[2]);
                obj.setSecondary(data[3]);
                obj.setTertiary(data[4]);
                obj.setPerCapita(data[12]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取农林牧渔信息
     * @return
     */
    public Map<String,Agricultural> getAgricultural() {
        String filePath = dataFile + "Agricultural.csv";
        Map<String,Agricultural> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                Agricultural obj = new Agricultural();
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
     * 获取固定资产投资信息
     * @return
     */
    public Map<String,FixedInvestments> getFixedInvestments() {
        String filePath = dataFile + "FixedInvestments.csv";
        Map<String,FixedInvestments> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                FixedInvestments obj = new FixedInvestments();
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
     * 获取消费品零售总额信息
     * @return
     */
    public Map<String,RetailSales> getRetailSales() {
        String filePath = dataFile + "RetailSales.csv";
        Map<String,RetailSales> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                RetailSales obj = new RetailSales();
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
     * 获取工业信息
     * @return
     */
    public Map<String,Industrial> getIndustrial() {
        String filePath = dataFile + "Industrial.csv";
        Map<String,Industrial> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                Industrial obj = new Industrial();
                obj.setDate(Utils.StringToDate(data[0],"yyyy")); //存入
                obj.setTotal(data[1]);
                if(data.length>=4) {
                    obj.setAboveDesignatedSize(data[3]);
                }
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取一般公共预算信息信息
     * @return
     */
    public Map<String,Financial> getFinancial() {
        String filePath = dataFile + "Financial.csv";
        Map<String,Financial> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                Financial obj = new Financial();
                obj.setDate(Utils.StringToDate(data[0],"yyyy")); //存入
                obj.setTotalPublicBudgetRevenue(data[1]);
                obj.setPublicBudgetRevenue(data[2]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取一般公共预算信息信息
     * @return
     */
    public Map<String,PCDI> getPCDI() {
        String filePath = dataFile + "PCDI.csv";
        Map<String,PCDI> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                PCDI obj = new PCDI();
                obj.setDate(Utils.StringToDate(data[0],"yyyy")); //存入
                obj.setTowner(data[1]);
                obj.setCountry(data[2]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取项目总体信息
     * @return
     */
    public Map<String,ProjectTotal> getProjectTotal() {
        String filePath = dataFile + "ProjectTotal.csv";
        Map<String,ProjectTotal> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                ProjectTotal obj = new ProjectTotal();
                obj.setOnDuty(data[0]); //存入
                obj.setTotalNum(data[1]);
                obj.setTotalInvestment(data[2]);
                obj.setYearPlanInvestment(data[3]);
                obj.setInvestmentCompleted(data[4]);
                obj.setInvestmentCompletedRate(data[5]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取项目在建信息
     * @return
     */
    public Map<String,ProjectInProgress> getProjectInProgress() {
        String filePath = dataFile + "ProjectInProgress.csv";
        Map<String,ProjectInProgress> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                ProjectInProgress obj = new ProjectInProgress();
                obj.setOnDuty(data[0]); //存入
                obj.setTotalNum(data[1]);
                obj.setYearPlanInvestment(data[2]);
                obj.setInvestmentCompleted(data[3]);
                obj.setInvestmentCompletedRate(data[4]);
                obj.setPlanCompleted(data[5]);
                obj.setActuallyCompleted(data[6]);
                obj.setCompletedRate(data[7]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取项目计划信息
     * @return
     */
    public Map<String,ProjectPlan> getProjectPlan() {
        String filePath = dataFile + "ProjectPlan.csv";
        Map<String,ProjectPlan> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                ProjectPlan obj = new ProjectPlan();
                obj.setOnDuty(data[0]); //存入
                obj.setTotalNum(data[1]);
                obj.setYearPlanInvestment(data[2]);
                obj.setInvestmentCompleted(data[3]);
                obj.setInvestmentCompletedRate(data[4]);
                obj.setActualStart(data[5]);
                obj.setActualStartRate(data[6]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取项目计划信息
     * @return
     */
    public Map<String,ProjectPrepare> getProjectPrepare() {
        String filePath = dataFile + "ProjectPrepare.csv";
        Map<String,ProjectPrepare> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                ProjectPrepare obj = new ProjectPrepare();
                obj.setOnDuty(data[0]); //存入
                obj.setTotalNum(data[1]);
                obj.setTotalInvestment(data[2]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取项目投资比例
     * @return
     */
    public Map<String,ProjectInInvestmentProportion> getProjectInInvestmentProportion() {
        String filePath = dataFile + "ProjectInInvestmentProportion.csv";
        Map<String,ProjectInInvestmentProportion> map = new LinkedHashMap<>();
        try {
            InputStream inputStream = new FileInputStream(filePath);
            CsvReader csvReader = new CsvReader(inputStream,Charset.forName("UTF-8")); // 创建CSV读对象
            csvReader.readHeaders();// 读表头
            while (csvReader.readRecord()) {
                String[] data = csvReader.getRawRecord().split(","); //切割
                ProjectInInvestmentProportion obj = new ProjectInInvestmentProportion();
                obj.setType(data[0]); //存入
                obj.setTotalInvestment(data[1]);
                obj.setInvestmentRate(data[2]);
                map.put(data[0],obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
