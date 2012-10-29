package org.nuxeo.workshop.wall.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.RuntimeFeature;
import org.nuxeo.workshop.wall.api.SayService;

import com.google.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features(RuntimeFeature.class)
@Deploy({ "nuxeo-wall-workshop-core2",
		"nuxeo-wall-workshop-core2-test:sayservice-test-contribution.xml" })
public class SayXPTest {

	@Inject
	SayService service;

	@Test
	public void sayHelloSaysHelloDamien() throws Exception {
		assertEquals("Hello Damien !", service.sayHello());
	}
}
