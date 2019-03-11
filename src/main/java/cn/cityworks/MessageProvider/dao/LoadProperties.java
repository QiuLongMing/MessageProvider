package cn.cityworks.MessageProvider.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Repository
public class LoadProperties {

    @Value("${spring.csvdatasource}")
    private String dataFile;

    public String getData(String file,String proName){
        Properties prop = new Properties();
        String result = null;
        try{
            InputStream in = new BufferedInputStream(new FileInputStream(dataFile+file+".properties"));
            prop.load(new InputStreamReader(in, "utf-8"));     ///加载属性列表
            result = prop.getProperty(proName);
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return result;
    }

}
