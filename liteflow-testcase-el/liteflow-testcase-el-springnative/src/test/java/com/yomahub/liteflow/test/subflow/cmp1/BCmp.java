package com.yomahub.liteflow.test.subflow.cmp1;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("b")
public class BCmp extends NodeComponent {

	@Override
	public void process() {
		System.out.println("Bcomp executed!");
	}

}
