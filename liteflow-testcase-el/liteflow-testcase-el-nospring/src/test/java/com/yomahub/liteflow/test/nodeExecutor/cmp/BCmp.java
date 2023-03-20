/**
 * <p>Title: liteflow</p>
 * <p>Description: 轻量级的组件式流程框架</p>
 * @author Bryan.Zhang
 * @email weenyc31@163.com
 * @Date 2020/4/1
 */
package com.yomahub.liteflow.test.nodeExecutor.cmp;

import com.yomahub.liteflow.core.NodeComponent;

public class BCmp extends NodeComponent {

	private int flag = 0;

	@Override
	public void process() {
		System.out.println("BCmp executed!");
		if (flag < 2) {
			flag++;
			throw new RuntimeException("demo exception");
		}
	}

}
