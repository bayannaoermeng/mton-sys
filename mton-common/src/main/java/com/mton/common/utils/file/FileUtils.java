package com.mton.common.utils.file;

import com.mton.common.support.CharsetKit;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件处理工具类
 *
 * @author mton
 */
@Slf4j
public class FileUtils {

    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+";

    /**
     * 将文件转为OutputStream
     *
     * @param filePath 文件路径
     * @param os 输出流
     * @throws IOException 异常
     */
    public static void writeBytes(String filePath, OutputStream os) throws IOException {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException(filePath);
            }
            try(FileInputStream fis =  new FileInputStream(file)){
                byte[] b = new byte[1024];
                int length;
                while ((length = fis.read(b)) > 0) {
                    os.write(b, 0, length);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e1) {
                    log.error(e1.getMessage(), e1);
                }
            }
        }
    }

    /**
     * 删除文件
     *
     * @param filePath 文件
     * @return 结果
     */
    public static boolean deleteFile(String filePath) {
        boolean flag = true;
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (IOException e) {
            log.error("删除文件失败!", e);
            flag = false;
        }
        return flag;
    }

    /**
     * 文件名称验证
     *
     * @param filename 文件名称
     * @return true 正常 false 非法
     */
    public static boolean isValidFilename(String filename){
        return filename.matches(FILENAME_PATTERN);
    }

    public static String setFileDownloadHeader(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        final String agent = request.getHeader("USER-AGENT");
        String filename = fileName;
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, CharsetKit.UTF8);
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            filename = new String(fileName.getBytes(), "ISO8859-1");
        } else if (agent.contains("Chrome")) {
            // google浏览器
            filename = URLEncoder.encode(filename, CharsetKit.UTF8);
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, CharsetKit.UTF8);
        }
        return filename;
    }


    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String savePath) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File file = new File(savePath);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }
    }



    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
