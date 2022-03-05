package com.yomahub.liteflow.test.parsecustom;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.entity.data.DefaultSlot;
import com.yomahub.liteflow.entity.data.LiteflowResponse;
import com.yomahub.liteflow.property.LiteflowConfig;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 非spring环境的自定义xml parser单元测试
 * @author bryan.zhang
 * @since 2.5.7
 */
public class CustomParserXmlTest extends BaseTest {

    private static FlowExecutor flowExecutor;

    @BeforeClass
    public static void init(){
        LiteflowConfig config = new LiteflowConfig();
        config.setRuleSource("com.yomahub.liteflow.test.parsecustom.parser.CustomXmlFlowParser");
        flowExecutor = FlowExecutor.loadInstance(config);
    }

    //测试springboot场景的自定义json parser
    @Test
    public void testXmlCustomParser() {
        LiteflowResponse<DefaultSlot> response = flowExecutor.execute2Resp("chain1", "args");
        Assert.assertTrue(response.isSuccess());
    }
}
