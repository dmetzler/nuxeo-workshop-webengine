
package org.nuxeo.workshop.wall.test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.common.utils.FileUtils;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.PathRef;
import org.nuxeo.ecm.core.api.impl.blob.FileBlob;
import org.nuxeo.ecm.core.test.CoreFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.workshop.wall.api.WallPost;

import com.google.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features({CoreFeature.class})
@Deploy({ "nuxeo-wall-workshop-core2",
		"studio.extensions.nxworld-46-nuxeo-world" })
public class PostDocTest {

	private static final int ONE = 1;
	@Inject
	CoreSession session;

	@Test
	public void iCanCreateAPost() throws Exception {
		DocumentModel doc = session.createDocumentModel("/", "myPost", "Post");
		doc.setPropertyValue("dc:title", "My Cool Post");
		doc = session.createDocument(doc);
		session.save();

		doc = session.getDocument(new PathRef("/myPost"));
		assertEquals("My Cool Post", doc.getTitle());

	}

	@Test
	public void IcanGetAPostAdapterOnMyDocument() throws Exception {
		DocumentModel doc = session.getDocument(new PathRef("/myPost"));
		assertNotNull(doc);

		WallPost post = doc.getAdapter(WallPost.class);
		assertNotNull(post);

	}

	@Test
	public void bindinAFilesCreateAChildren() throws Exception {
		DocumentModel doc = session.createDocumentModel("/", "myPost2", "Post");
		doc.setPropertyValue("dc:title", "My Cool second Post");
		doc.getAdapter(WallPost.class).bind(new FileBlob(new File(FileUtils
				.getResourcePathFromContext("test.txt"))));
		doc = session.createDocument(doc);
		session.save();

		assertEquals(ONE,session.getChildren(new PathRef("/myPost2")).size());
	}

}
