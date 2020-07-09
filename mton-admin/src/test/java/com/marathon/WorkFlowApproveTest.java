package com.marathon;

import com.marathon.qvo.WorkflowApproveQO;
import com.marathon.service.thirdpartystaff.IMrton3PartyStaffService;
import com.marathon.service.workflow.IWorkFlowService;
import com.mton.MrtonApplication;
import com.mton.system.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cuiguangqiang
 * @version WorkFlowApproveTest, v0.1 2020/6/18 10:37
 * @description 类说明
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MrtonApplication.class)
public class WorkFlowApproveTest {

    @Autowired
    private IMrton3PartyStaffService staffService;

    @Autowired
    private IWorkFlowService workFlowService;

    @Test
    public void testApprove() {
        long userId = 1;
        staffService.apply("d2a4c158-cdb6-4e7d-a2b5-e732d3fa018b", userId);

        WorkflowApproveQO qo = new WorkflowApproveQO();
        qo.setProcId("d2a4c158-cdb6-4e7d-a2b5-e732d3fa018b");
        qo.setRemark("拒绝");
        qo.setApproveResult(0);

        SysUser user = new SysUser();
        user.setUserId(Long.valueOf("1"));
        workFlowService.approve(qo, user);
    }
}
