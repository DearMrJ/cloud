package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author lynch
 * @date 2020/3/13 14:46
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT"; // eureka中的服务名称

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    //手写的负载均衡策略依赖注入
    @Resource
    private LoadBalancer loadBalancer;

    @PostMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
//        //传递参数使用HashMap 无效， 需要使用MultiValueMap
//        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
//        params.add("serial", payment.getSerial());
//        //postForObject(url, object request(requestMap), responseType)
//        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", params, CommonResult.class);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        //getForObject(url, responseType)
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult getPaymentWithId(@PathVariable("id") Long id) {
        //getForObject(url, responseType)
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentWithCustomedLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if (null == instances || CollectionUtils.isEmpty(instances) || instances.size() <= 0) {
            return null;
        }
        ServiceInstance ins = loadBalancer.instances(instances);
        URI uri = ins.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);

    }

}
