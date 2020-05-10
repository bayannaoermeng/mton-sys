package com.mton.web.controller.fileresource;

import com.marathon.config.SystemConfig;
import com.marathon.domain.MrtonResource;
import com.marathon.qvo.OfficeFileAclVO;
import com.marathon.qvo.OfficeFileSaveBackQO;
import com.marathon.qvo.OfficeFileSaveBackVO;
import com.marathon.service.IMrtonResourceService;
import com.marathon.service.IOfficeToolService;
import com.mton.common.base.AjaxResult;
import com.mton.common.json.JSON;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cuiguangqiang
 * @version OfficeToolController, v0.1 2020/2/4 16:20
 * @description Office文档工具，查看，编辑操作 集成毕升Office(https://bishengoffice.com/)
 */

@Controller
@RequestMapping("/office")
public class OfficeToolController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(OfficeToolController.class);

    @Autowired
    private IMrtonResourceService mrtonResourceService;

    @Autowired
    private IOfficeToolService officeToolService;

    @Autowired
    private SystemConfig systemConfig;

    /**
     * 查看文档
     * @param fileId
     * @return
     */
    @RequestMapping("link/view/{fileId}")
    @ResponseBody
    public AjaxResult view(@PathVariable("fileId") String fileId){

//        Integer userId = Math.toIntExact(getUserId());

        Integer userId = 1;

        String url = officeToolService.getLink(fileId,userId,"openPreview");

        return AjaxResult.success("成功",url);
    }

    /**
     * 编辑文档
     * @param fileId
     * @return
     */
    @RequestMapping("link/edit/{fileId}")
    @ResponseBody
    public AjaxResult edit(@PathVariable("fileId") String fileId){

//        Integer userId = Math.toIntExact(getUserId());

        Integer userId = 1;

        String url = officeToolService.getLink(fileId,userId,"openEditor");

        return AjaxResult.success("成功",url);
    }

    @RequestMapping("fileAcl/{fileId}/{userId}")
    @ResponseBody
    public OfficeFileAclVO fileAcl(@PathVariable("fileId") String fileId,@PathVariable("userId") String userId){

        return officeToolService.fileAcl(fileId,userId);

    }

    @RequestMapping("file/download")
    @ApiOperation(value = "下载文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileId",value = "文件id",required = true)
    })
    public void fileDownload(String fileId, HttpServletResponse response, HttpServletRequest request) {

        MrtonResource fileResource =  mrtonResourceService.selectMrtonResourceById(Integer.valueOf(fileId));
        String fileName = fileResource.getResourceName();
        String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf('/') + 1);
        try {
            String relavateFilePath=fileResource.getResourceUrl();
            String filePath = systemConfig.getTaskDocDir() + relavateFilePath;
            log.info("接收到编辑文件下载请求【{}】",filePath);
            response.setCharacterEncoding(CharsetKit.UTF8);
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    @RequestMapping("file/saveBack")
    @ResponseBody
    public OfficeFileSaveBackVO saveBack(@RequestBody OfficeFileSaveBackQO qo){

        try {
            log.info("收到文件回存请求【{}】", JSON.marshal(qo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("文件名【{}】fetchUrl【{}】",qo.getDocId(),qo.getData().getDocURL());

        return officeToolService.saveBack(qo);

    }
}
