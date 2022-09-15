package com.yomahub.liteflow.test.parser;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@TestPropertySource(value = "classpath:/parser/application-springEL.properties")
@SpringBootTest(classes = SpringELSupportELDeclSpringbootTest.class)
@EnableAutoConfiguration
@ComponentScan({"com.yomahub.liteflow.test.parser.cmp"})
public class SpringELSupportELDeclSpringbootTest extends BaseTest {

    @Resource
    private FlowExecutor flowExecutor;

    //测试springEL的解析情况
    @Test
    public void testSpringELParser() {
        LiteflowResponse response = flowExecutor.execute2Resp("chain11", "arg");
        Assert.assertTrue(response.isSuccess());
    }
}
