package com.marathon.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author cuiguangqiang
 * @version BishengConfig, v0.1 2020/5/10 17:19
 * @description 类说明
 */
@Component
@Data
public class BishengConfig {

    @Value("${office.editorCaller}")
    private String editorCaller;

    @Value("${office.editorHost}")
    private String editorHost;

}
