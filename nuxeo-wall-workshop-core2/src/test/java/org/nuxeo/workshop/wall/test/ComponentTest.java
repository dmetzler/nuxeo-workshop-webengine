package org.nuxeo.workshop.wall.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.runtime.api.Framework;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.RuntimeFeature;
import org.nuxeo.workshop.wall.api.SayService;

@RunWith(FeaturesRunner.class)
@Features(RuntimeFeature.class)
@Deploy("nuxeo-wall-workshop-core2")
public class ComponentTest {

	@Test
	public void iCanGetTheRuntime() throws Exception {
		assertNotNull(Framework.getRuntime());
	}

	@Test
	public void iHaveMyComponentDeployed() throws Exception {
		assertNotNull(Framework.getRuntime().getComponent("hello-component"));
	}

	@Test
	public void aServiceHelloSaysHello() throws Exception {
		SayService service = Framework.getService(SayService.class);
		assertNotNull(service);

		assertEquals("Hello World !", service.sayHello());
	}


}
