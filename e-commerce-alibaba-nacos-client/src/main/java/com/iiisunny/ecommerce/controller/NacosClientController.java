package com.iiisunny.ecommerce.controller;

import com.iiisunny.ecommerce.service.NacosClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/nacos-client")
public class NacosClientController {

    private static final Logger LOG = LoggerFactory.getLogger(NacosClientService.class);

    private final NacosClientService nacosClientService;

    public NacosClientController(NacosClientService nacosClientServicel) {
        this.nacosClientService = nacosClientServicel;
    }

    /**
     * <h2>根据 service id 获取服务所有的实例信息</h2>
     * @param serviceId 服务ID
     * @return 服务列表
     */
    @RequestMapping(value = "/service-instance", method = RequestMethod.GET)
    public List<ServiceInstance> logNacosClientINfo(@RequestParam(defaultValue = "e-commerce-nacos-client") String serviceId){

        LOG.error("我啊嗷嗷啊啊");
        LOG.info("coming in log nacos client info: [{}]", serviceId);
        return nacosClientService.getNacosClientInfo(serviceId);
    }
}
