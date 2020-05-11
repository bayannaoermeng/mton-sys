/*
 *  Copyright 2007-2008, Plutext Pty Ltd.
 *   
 *  This file is part of docx4j.

    docx4j is licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 

    You may obtain a copy of the License at 

        http://www.apache.org/licenses/LICENSE-2.0 

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

 */

package com.marathon.service.office;

import com.google.common.io.Files;
import org.apache.fop.apps.FOUserAgent;
import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.convert.out.fo.renderers.FORendererApacheFOP;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.model.fields.FieldUpdater;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.OutputStream;

/**
 * word转pdf工具类
 */
public class Word2PdfService {

    // For demo/debugging purposes, save the intermediate XSL FO
    // Don't do this in production!
    static boolean saveFO;

    public static String convert(String inputfilepath) throws Exception {
        // Document loading (required)
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(new java.io.File(inputfilepath));

        // Set up font mapper (optional)
        Mapper fontMapper = new IdentityPlusMapper();

        //進行中文字體兼容處理
        fontMapper.put("微软雅黑", PhysicalFonts.get("Microsoft Yahei"));
        fontMapper.put("黑體", PhysicalFonts.get("SimHei"));
        fontMapper.put("楷體", PhysicalFonts.get("KaiTi"));
        fontMapper.put("隸書", PhysicalFonts.get("LiSu"));
        fontMapper.put("宋體", PhysicalFonts.get("SimSun"));
        fontMapper.put("宋體擴展", PhysicalFonts.get("simsun-extB"));
        fontMapper.put("新宋體", PhysicalFonts.get("NSimSun"));
        fontMapper.put("仿宋", PhysicalFonts.get("FangSong"));
        fontMapper.put("仿宋_GB2312", PhysicalFonts.get("FangSong_GB2312"));
        fontMapper.put("幼圓", PhysicalFonts.get("YouYuan"));
        fontMapper.put("華文宋體", PhysicalFonts.get("STSong"));
        fontMapper.put("華文仿宋", PhysicalFonts.get("STFangsong"));
        fontMapper.put("華文中宋", PhysicalFonts.get("STZhongsong"));
        fontMapper.put("華文行楷", PhysicalFonts.get("STXingkai"));

        wordMLPackage.setFontMapper(fontMapper);

        // .. the FOSettings object
        FOSettings foSettings = Docx4J.createFOSettings();
        if (saveFO) {
            foSettings.setFoDumpFile(new java.io.File(inputfilepath + ".fo"));
        }
        foSettings.setWmlPackage(wordMLPackage);

        FOUserAgent foUserAgent = FORendererApacheFOP.getFOUserAgent(foSettings);
        // configure foUserAgent as desired
        foUserAgent.setTitle("my title");

//	    foUserAgent.getRendererOptions().put("pdf-a-mode", "PDF/A-1b");
        // is easier than
//		foSettings.setApacheFopConfiguration(apacheFopConfiguration);

        // PDF/A-1a, PDF/A-2a and PDF/A-3a require accessibility to be enabled
        // see further https://stackoverflow.com/a/54587413/1031689
//	    foUserAgent.setAccessibility(true); // suppress "missing language information" messages from FOUserAgent .processEvent


        // Document format:
        // The default implementation of the FORenderer that uses Apache Fop will output
        // a PDF document if nothing is passed via
        // foSettings.setApacheFopMime(apacheFopMime)
        // apacheFopMime can be any of the output formats defined in org.apache.fop.apps.MimeConstants eg org.apache.fop.apps.MimeConstants.MIME_FOP_IF or
        // FOSettings.INTERNAL_FO_MIME if you want the fo document as the result.
        //foSettings.setApacheFopMime(FOSettings.INTERNAL_FO_MIME);

        // exporter writes to an OutputStream.
        String ext = Files.getFileExtension(inputfilepath);
        String outputfilepath = inputfilepath.replaceAll(ext, "pdf");
        OutputStream os = new java.io.FileOutputStream(outputfilepath);

        // Specify whether PDF export uses XSLT or not to create the FO
        // (XSLT takes longer, but is more complete).

        // Don't care what type of exporter you use
        Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

        // Prefer the exporter, that uses a xsl transformation
        // Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

        // Prefer the exporter, that doesn't use a xsl transformation (= uses a visitor)
        // .. faster, but not yet at feature parity
        // Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_NONXSL);

        // Clean up, so any ObfuscatedFontPart temp files can be deleted
        if (wordMLPackage.getMainDocumentPart().getFontTablePart() != null) {
            wordMLPackage.getMainDocumentPart().getFontTablePart().deleteEmbeddedFontTempFiles();
        }
        // This would also do it, via finalize() methods
        foSettings = null;
        wordMLPackage = null;

        return outputfilepath;
    }
}