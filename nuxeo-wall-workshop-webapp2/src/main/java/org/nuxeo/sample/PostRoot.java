/**
 *
 */

package org.nuxeo.sample;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentModelList;
import org.nuxeo.ecm.webengine.forms.FormData;
import org.nuxeo.ecm.webengine.model.WebContext;
import org.nuxeo.ecm.webengine.model.WebObject;
import org.nuxeo.ecm.webengine.model.impl.ModuleRoot;
import org.nuxeo.workshop.wall.api.WallPost;

/**
 * The root entry for the WebEngine module.
 *
 * @author dmetzler
 */
@Path("/wall")
@Produces("text/html;charset=UTF-8")
@WebObject(type = "PostRoot")
public class PostRoot extends ModuleRoot {

	@GET
	public Object doGet() {
		return getView("index");
	}

	@GET
	@Produces("application/json;charset=UTF-8")
	public Object doGetJson() {
		return getView("indexjson");
	}

	@POST
	public Object doPost() throws ClientException {
		WebContext ctx = getContext();
		CoreSession session = ctx.getCoreSession();
		FormData form = ctx.getForm();
		DocumentModel doc = session.createDocumentModel(
				"/default-domain/workspaces/", form.getString("title"), "Post");
		doc.getAdapter(WallPost.class).setDescription(form.getString("postcontent"));
		doc = session.createDocument(doc);
		session.save();
		return redirect(getPath());
	}

	public List<WallPost> getPosts() throws ClientException {

		CoreSession session = getContext().getCoreSession();
		DocumentModelList query = session.query("SELECT * FROM Post");
		List<WallPost> result = new ArrayList<WallPost>();
		for(DocumentModel doc : query) {
			result.add(doc.getAdapter(WallPost.class));
		}
		return result;
	}
}
