package com.marathon.service.ceremony.impl;

import com.marathon.MrtonProcEnum;
import com.marathon.domain.MrtonProcCfg;
import com.marathon.domain.MrtonProcCfgExample;
import com.marathon.domain.MrtonProcInfo;
import com.marathon.mapper.MrtonProcCfgMapper;
import com.marathon.mapper.MrtonProcInfoMapper;
import com.marathon.qvo.OrgChartDataVO;
import com.marathon.service.ceremony.ICeremonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * @author cuiguangqiang
 * @version CeremonyServiceImpl, v0.1 2020/4/27 9:41
 * @description 类说明
 */
@Service
public class CeremonyServiceImpl implements ICeremonyService {

    @Autowired
    private MrtonProcCfgMapper mrtonProcCfgMapper;

    @Autowired
    private MrtonProcInfoMapper mrtonProcInfoMapper;

    @Override
    public OrgChartDataVO getData(MrtonProcEnum mrtonProcEnum) {

        MrtonProcCfgExample example = new MrtonProcCfgExample();
        example.or().andProcNameEqualTo(mrtonProcEnum.getName());
        List<MrtonProcCfg> lstProcCfg = mrtonProcCfgMapper.selectByExample(example);
        if (lstProcCfg.size() == 1) {
            MrtonProcCfg cfg = lstProcCfg.get(0);
            return recursiveTree(cfg.getProcId());
        }

        throw new IllegalArgumentException("无数据。。。。。。。。");
    }

    public OrgChartDataVO recursiveTree(String procId) {
        OrgChartDataVO vo = new OrgChartDataVO();
        MrtonProcCfg cfg = mrtonProcCfgMapper.selectByPrimaryKey(procId);
        vo.setName(cfg.getProcName());
        vo.setTitle("状态：新建");
        vo.setSeq(cfg.getProcSeq() == null ? 1 : cfg.getProcSeq());

        MrtonProcInfo mrtonProcInfo = new MrtonProcInfo();
        mrtonProcInfo.setProcId(procId);
        List<MrtonProcInfo>infoList = mrtonProcInfoMapper.selectMrtonProcInfoList(mrtonProcInfo);
        if(infoList.size() == 1){
            vo.setId(infoList.get(0).getId());
        }

        MrtonProcCfgExample example = new MrtonProcCfgExample();
        example.or().andParentProcIdEqualTo(procId);
        List<MrtonProcCfg> lstCfg = mrtonProcCfgMapper.selectByExample(example);
        for (MrtonProcCfg child : lstCfg) {
            OrgChartDataVO node = recursiveTree(child.getProcId()); //递归
            vo.getChildren().add(node);
        }
        vo.getChildren().sort(new Comparator<OrgChartDataVO>() {
            @Override
            public int compare(OrgChartDataVO o1, OrgChartDataVO o2) {
                return o1.getSeq() - o2.getSeq();
            }
        });
        return vo;
    }
}
