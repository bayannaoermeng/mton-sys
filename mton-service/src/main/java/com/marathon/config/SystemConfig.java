package com.marathon.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author cuiguangqiang
 * @version SystemConfig, v0.1 2020/5/10 17:21
 * @description 类说明
 */
@Component
@Data
public class SystemConfig {

    //文档模板路径
    @Value("${task.template.dir}")
    private String taskTemplateDir;

    //生成的文档存放路径
    @Value("${task.document.dir}")
    private String taskDocDir;

}
