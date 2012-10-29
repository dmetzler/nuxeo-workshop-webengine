package org.nuxeo.workshop.wall;

import org.nuxeo.runtime.model.ComponentInstance;
import org.nuxeo.runtime.model.DefaultComponent;
import org.nuxeo.workshop.wall.api.SayService;

public class SayServiceImpl extends DefaultComponent implements SayService {

	private String name = "World";

	@Override
	public String sayHello() {
		return "Hello " + name + " !";
	}

	@Override
	public void registerContribution(Object contribution,
			String extensionPoint, ComponentInstance contributor)
			throws Exception {
		if("name".equals(extensionPoint)) {
			NameExtensionDescriptor desc = (NameExtensionDescriptor) contribution;
			name = desc.getName();
		}
	}

}
