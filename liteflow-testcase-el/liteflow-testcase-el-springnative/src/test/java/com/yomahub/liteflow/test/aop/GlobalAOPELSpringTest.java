package com.yomahub.liteflow.test.aop;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.slot.DefaultContext;
import com.yomahub.liteflow.spring.ComponentScanner;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 切面场景单元测试
 *
 * @author zendwang
 * @since 2.8.0
 */

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:/aop/application-global.xml")
public class GlobalAOPELSpringTest extends BaseTest {

	@Resource
	private FlowExecutor flowExecutor;

	// 测试全局AOP，串行场景
	@Test
	public void testGlobalAopS() {
		LiteflowResponse response = flowExecutor.execute2Resp("chain1", "it's a request");
		DefaultContext context = response.getFirstContextBean();
		Assert.assertTrue(response.isSuccess());
		Assert.assertEquals("before_after", context.getData("a"));
		Assert.assertEquals("before_after", context.getData("b"));
		Assert.assertEquals("before_after", context.getData("c"));
		Assert.assertEquals("before_after", context.getData("d"));
		Assert.assertEquals("before_after", context.getData("e"));
	}

	// 测试全局AOP，并行场景
	@Test
	public void testGlobalAopP() {
		LiteflowResponse response = flowExecutor.execute2Resp("chain2", "it's a request");
		DefaultContext context = response.getFirstContextBean();
		Assert.assertTrue(response.isSuccess());
		Assert.assertEquals("before_after", context.getData("a"));
		Assert.assertEquals("before_after", context.getData("b"));
		Assert.assertEquals("before_after", context.getData("c"));
		Assert.assertEquals("before_after", context.getData("d"));
		Assert.assertEquals("before_after", context.getData("e"));
	}

	@Test
	public void testGlobalAopException() {
		LiteflowResponse response = flowExecutor.execute2Resp("chain3", "it's a request");
		DefaultContext context = response.getFirstContextBean();
		Assert.assertFalse(response.isSuccess());
		Assert.assertEquals("before_after", context.getData("a"));
		Assert.assertEquals("before_after", context.getData("b"));
		Assert.assertEquals("before_after", context.getData("c"));
		Assert.assertEquals("before_after", context.getData("f"));
	}

	@AfterClass
	public static void cleanScanCache() {
		BaseTest.cleanScanCache();
		ComponentScanner.cmpAroundAspect = null;
	}

}
