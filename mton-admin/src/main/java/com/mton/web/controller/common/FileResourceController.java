package com.mton.web.controller.common;

import com.google.common.base.Strings;
import com.marathon.domain.MrtonResource;
import com.marathon.domain.MrtonResourceExample;
import com.marathon.mapper.MrtonResourceMapper;
import com.mton.common.base.AjaxResult;
import com.mton.common.config.Global;
import com.mton.common.utils.file.FileUploadUtils;
import com.mton.framework.config.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/fileresource")
public class FileResourceController {

    private final ServerConfig serverConfig;

    @Autowired
    private MrtonResourceMapper mrtonResourceMapper;

    @Autowired
    public FileResourceController(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public MrtonResource add(@RequestParam("file") MultipartFile file, String activityId) throws IOException {
        MrtonResource fileResource = new MrtonResource();
        if (!file.isEmpty()) {
            String filename = file.getOriginalFilename();

            // 上传文件路径
            String filePath = Global.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            if (!Strings.isNullOrEmpty(activityId)) {
                fileResource.setProcId(activityId);
            }
            fileResource.setResourceName(filename);
            fileResource.setResourceUrl(fileName);
            mrtonResourceMapper.insertSelective(fileResource);
        }
        return fileResource;
    }

    @RequestMapping("/deleteFile")
    @ResponseBody
    public AjaxResult deleteFile(@RequestBody MrtonResource fileResource) {
        try {
            Files.delete(Paths.get(Global.getUploadPath() + File.separator + fileResource.getResourceUrl()));
            mrtonResourceMapper.deleteByPrimaryKey(fileResource.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AjaxResult.success();
    }
}
