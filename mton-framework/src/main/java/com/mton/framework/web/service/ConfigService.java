package com.mton.framework.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mton.system.service.ISysConfigService;

/**
 * RuoYi首创 html调用 thymeleaf 实现参数管理
 *
 * @author mton
 */
@Service("config")
public class ConfigService {

    private final ISysConfigService sysConfigService;

    @Autowired
    public ConfigService(ISysConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数名称
     * @return 参数键值
     */
    public String getKey(String configKey) {
        return sysConfigService.selectConfigByKey(configKey);
    }
}
