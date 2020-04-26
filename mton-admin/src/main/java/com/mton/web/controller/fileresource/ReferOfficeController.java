package com.mton.web.controller.fileresource;

import com.marathon.domain.MrtonProcCfgResource;
import com.marathon.mapper.MrtonProcCfgResourceMapper;
import com.marathon.qvo.OfficeFileAclVO;
import com.marathon.service.IReferOfficeService;
import com.mton.common.config.Global;
import com.mton.common.support.CharsetKit;
import com.mton.common.utils.file.FileUtils;
import com.mton.framework.web.base.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cuiguangqiang
 * @version OfficeToolController, v0.1 2020/2/4 16:20
 * @description 参考文件查看操作集成毕升Office(https://bishengoffice.com/)
 */

@Controller
@RequestMapping("/referoffice")
public class ReferOfficeController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(ReferOfficeController.class);

    @Autowired
    private MrtonProcCfgResourceMapper mrtonProcCfgResourceMapper;

    @Autowired
    private IReferOfficeService referOfficeService;

    @RequestMapping("fileAcl/{fileId}/{userId}")
    @ResponseBody
    public OfficeFileAclVO fileAcl(@PathVariable("fileId") String fileId,@PathVariable("userId") String userId){

        return referOfficeService.fileAcl(fileId,userId);

    }

    @RequestMapping("file/download")
    @ApiOperation(value = "下载文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileId",value = "文件id",required = true)
    })
    public void fileDownload(String fileId, HttpServletResponse response, HttpServletRequest request) {
        MrtonProcCfgResource fileResource =  mrtonProcCfgResourceMapper.selectByPrimaryKey(Integer.valueOf(fileId));
        String fileName = fileResource.getResourceName();
        String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf('/') + 1);
        try {
            String relavateFilePath=fileResource.getResourceUrl();
            String filePath = Global.getUploadPath() + relavateFilePath;
            log.info("接收到参考文件下载请求【{}】",filePath);
            response.setCharacterEncoding(CharsetKit.UTF8);
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }
}
