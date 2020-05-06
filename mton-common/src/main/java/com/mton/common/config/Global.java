package com.mton.common.config;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.mton.common.utils.YamlUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局配置类
 *
 * @author mton
 */
@Slf4j
public class Global {

    private static final String NAME = "application.yml" ;

    private static final String CONFIG_KEY= "mton.profile";

    /**
     * 当前对象实例
     */
    private static Global global = null;

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = new HashMap<>();

    private Global() {
    }

    /**
     * 静态工厂方法 获取当前对象实例 多线程安全单例模式(使用双重同步锁)
     */

    public static synchronized Global getInstance() {
        if (global == null) {
            synchronized (Global.class) {
                if (global == null) {
                    global = new Global();
                }
            }
        }
        return global;
    }

    /**
     * 获取配置
     */
    private static String getConfig(String key) {
        String value = map.get(key);
        if (value == null) {
            Map<?, ?> yamlMap;
            try {
                yamlMap = YamlUtil.loadYaml(NAME);
                value = String.valueOf(YamlUtil.getProperty(yamlMap, key));
                map.put(key, value != null ? value : StrUtil.EMPTY);
            } catch (Exception e) {
                log.error("获取全局配置异常 {}" , key);
            }
        }
        return value;
    }

    /**
     * 获取项目名称
     */
    public static String getName() {
        return Convert.toStr(getConfig("mton.name"), "mrton");
    }

    /**
     * 获取项目版本
     */
    public static String getVersion() {
        return Convert.toStr(getConfig("mton.version"), "3.4.0");
    }

    /**
     * 获取版权年份
     */
    public static String getCopyrightYear() {
        LocalDate now = LocalDate.now();
        return String.valueOf(now.getYear());
    }

    /**
     * 获取ip地址开关
     */
    public static Boolean isAddressEnabled() {
        return Convert.toBool(getConfig("mton.addressEnabled"));
    }

    /**
     * 是否开启演示实例
     */
    public static Boolean isDemoEnabled() {
        return Convert.toBool(getConfig("mton.demoEnabled"), false);
    }

    /**
     * 获取文件上传路径
     */
    public static String getProfile() {
        return getConfig(CONFIG_KEY);
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath() {
        return getConfig(CONFIG_KEY) + "avatar/" ;
    }

    /**
     * 获取下载上传路径
     */
    public static String getDownloadPath() {
        return getConfig(CONFIG_KEY) + "download/" ;
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath(){
        return getConfig(CONFIG_KEY) + "upload/";
    }

}
