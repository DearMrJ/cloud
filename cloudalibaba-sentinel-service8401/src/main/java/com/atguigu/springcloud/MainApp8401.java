package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lynch
 * @date 2020/4/3 17:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainApp8401 {

    public static void main(String[] args) throws Exception {
//        init();
        SpringApplication.run(MainApp8401.class, args);
    }

//    private static void init() throws Exception {
//        String remoteAddress = "localhost:8848";
//        String groupId = "DEFAULT_GROUP";
//        String dataId = "cloudalibaba-sentinel-service";
//        Converter<String, List<FlowRule>> parser = source -> JSON.parseObject(source,new TypeReference<List<FlowRule>>() {});
//        ReadableDataSource<String, List<FlowRule>> nacosDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId, parser);
//        FlowRuleManager.register2Property(nacosDataSource.getProperty());
//    }

}