package com.mton.web.controller.marathon.word;

import com.google.common.collect.Maps;
import com.marathon.service.office.WordTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.Map;

/**
 * @author cuiguangqiang
 * @version WordTaskController, v0.1 2020/5/4 7:38
 * @description 类说明
 */
@RestController
@RequestMapping("/word")
public class WordTaskController {

    @Autowired
    private WordTaskService wordTaskService;

    @RequestMapping("/render/{taskId}")
    public String genWordDocument(@PathVariable String taskId, ServletRequest request){
        Map<String,Object> map = WebUtils.getParametersStartingWith(request, "s_");

        Map<String,String> dataMap = Maps.newHashMap();
        for (Map.Entry<String,Object> entry :map.entrySet()){
            dataMap.put(entry.getKey(), (String) entry.getValue());
        }
       return wordTaskService.genWordDoc(taskId,dataMap);
    }

}
