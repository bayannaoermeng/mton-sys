package com.marathon.service.thirdpartystaff.impl;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.marathon.domain.Mrton3PartyStaff;
import com.marathon.domain.Mrton3PartyStaffExample;
import com.marathon.domain.MrtonProcWorkflow;
import com.marathon.domain.MrtonResource;
import com.marathon.domain.workflow.WorkflowBusiness;
import com.marathon.domain.workflow.WorkflowLink;
import com.marathon.domain.workflow.WorkflowLinkExample;
import com.marathon.domain.workflow.WorkflowNode;
import com.marathon.mapper.*;
import com.marathon.qvo.ceremony.Mrton3PartyStaffVO;
import com.marathon.service.IMrtonResourceService;
import com.marathon.service.thirdpartystaff.IMrton3PartyStaffService;
import com.marathon.service.workflow.IWorkFlowService;
import net.bytebuddy.asm.Advice;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.xmlgraphics.util.uri.CommonURIResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.marathon.service.workflow.WorkFlowEnum.WORK_FLOW_ANCHOR;

/**
 * @author cuiguangqiang
 * @version Mrton3PartyStaffServiceImpl, v0.1 2020/5/16 15:02
 * @description 类说明
 */
@Service
public class Mrton3PartyStaffServiceImpl implements IMrton3PartyStaffService {

    @Autowired
    private Mrton3PartyStaffMapper mrton3PartyStaffMapper;

    @Autowired
    private IMrtonResourceService mrtonResourceService;

    @Autowired
    private WorkflowLinkMapper linkMapper;

    @Autowired
    private WorkflowBusinessMapper businessMapper;

    @Autowired
    private WorkflowNodeMapper nodeMapper;

    @Autowired
    private MrtonProcWorkflowMapper procWorkflowMapper;


    @Override
    public int insertMrton3PartyStaff(Mrton3PartyStaff mrton3PartyStaff) {
        return mrton3PartyStaffMapper.insertSelective(mrton3PartyStaff);
    }

    @Override
    public Mrton3PartyStaffVO selectMrton3PartyStaffById(Integer id) {
        Mrton3PartyStaffVO vo = new Mrton3PartyStaffVO();
        Mrton3PartyStaff mrton3PartyStaff = mrton3PartyStaffMapper.selectByPrimaryKey(id);
        try {
            BeanUtils.copyProperties(vo, mrton3PartyStaff);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String resourceId = mrton3PartyStaff.getResumePath();
        if (!Strings.isNullOrEmpty(resourceId)) {
            MrtonResource resource = mrtonResourceService.selectMrtonResourceById(Integer.valueOf(resourceId));
            vo.setResumeResource(resource);
        }
        return vo;
    }

    @Override
    public int updateMrton3PartyStaff(Mrton3PartyStaff mrton3PartyStaff) {
        return mrton3PartyStaffMapper.updateByPrimaryKeySelective(mrton3PartyStaff);
    }

    @Override
    public int deleteMrton3PartyStaffByIds(String ids) {
        Mrton3PartyStaff staff = mrton3PartyStaffMapper.selectByPrimaryKey(Integer.valueOf(ids));
        if (!Strings.isNullOrEmpty(staff.getResumePath())) {
            //物理文件删除
            mrtonResourceService.deleteMrtonResourceByIds(staff.getResumePath());
        }
        return mrton3PartyStaffMapper.deleteByPrimaryKey(Integer.valueOf(ids));
    }

    @Override
    public List<Mrton3PartyStaffVO> selectByProcId(String procid) {
        Mrton3PartyStaffExample staff = new Mrton3PartyStaffExample();
        staff.or().andProcIdEqualTo(procid);
        List<Mrton3PartyStaff> lstStaff = mrton3PartyStaffMapper.selectByExample(staff);
        return Lists.transform(lstStaff, new Function<Mrton3PartyStaff, Mrton3PartyStaffVO>() {
            @Override
            public Mrton3PartyStaffVO apply(Mrton3PartyStaff mrton3PartyStaff) {
                Mrton3PartyStaffVO vo = new Mrton3PartyStaffVO();
                try {
                    BeanUtils.copyProperties(vo, mrton3PartyStaff);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                vo.setMasterStr(vo.getMaster() == 1 ? "供应商" : "备选");
                return vo;
            }
        });
    }

    @Override
    public void setMaster(String id) {
        Mrton3PartyStaff staff = this.selectMrton3PartyStaffById(Integer.valueOf(id));
        String procId = staff.getProcId();

        //先全部置成0
        Mrton3PartyStaff partyStaff = new Mrton3PartyStaff();
        partyStaff.setMaster(0);
        Mrton3PartyStaffExample example = new Mrton3PartyStaffExample();
        example.or().andProcIdEqualTo(procId);
        mrton3PartyStaffMapper.updateByExampleSelective(partyStaff, example);

        //单独置成1
        partyStaff.setMaster(1);
        partyStaff.setId(Integer.valueOf(id));
        this.updateMrton3PartyStaff(partyStaff);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void apply(String procId) {

        Integer workFlowId = WORK_FLOW_ANCHOR.getCode();

        //所有的流程节点
        WorkflowLinkExample example = new WorkflowLinkExample();
        example.or().andWorkflowIdEqualTo(workFlowId);
        List<WorkflowLink> lstLink = linkMapper.selectByExample(example);

        //第一个节点
        Integer prenode = lstLink.get(0).getWorkflowLinkPrenode();
        WorkflowNode node = nodeMapper.selectByPrimaryKey(prenode);

        //记录业务
        WorkflowBusiness business = new WorkflowBusiness();
        business.setWorkflowId(workFlowId);
//        business.setBusinessId(procId);
        business.setNodeId(prenode);
        business.setSuggestion(node.getNodeName());
        businessMapper.insertSelective(business);

        //待处理节点信息
        MrtonProcWorkflow procWorkflow = new MrtonProcWorkflow();
        procWorkflow.setProcId(procId);
        procWorkflow.setNodeId(lstLink.get(0).getWorkflowLinkNextnode());
        procWorkflowMapper.insertSelective(procWorkflow);
    }
}
