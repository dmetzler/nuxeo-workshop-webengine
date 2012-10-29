/**
 *
 */

package org.nuxeo.workshop.wall.api;

import java.util.Calendar;
import java.util.List;
import java.io.Serializable;

import org.nuxeo.ecm.core.api.ClientException;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.Blob;
import org.nuxeo.ecm.core.api.impl.blob.FileBlob;
import org.nuxeo.ecm.core.api.model.PropertyException;
import org.nuxeo.externalresource.ExternalResource;

/**
 * @author dmetzler
 */
public class WallPost {

    protected final DocumentModel doc;

    public WallPost(DocumentModel doc) {
        this.doc = doc;
    }

    public void save(CoreSession session) throws ClientException {
        session.saveDocument(doc);
    }

    public String getId() {
        return doc.getId();
    }

    public String getTitle() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:title");
    }

    public void setTitle(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:title", value);
    }

    public String getDescription() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:description");
    }

    public void setDescription(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:description", value);
    }

    public String getRights() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:rights");
    }

    public void setRights(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:rights", value);
    }

    public String getSource() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:source");
    }

    public void setSource(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:source", value);
    }

    public String getCoverage() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:coverage");
    }

    public void setCoverage(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:coverage", value);
    }

    public String getFormat() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:format");
    }

    public void setFormat(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:format", value);
    }

    public String getLanguage() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:language");
    }

    public void setLanguage(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:language", value);
    }

    public String getCreator() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:creator");
    }

    public void setCreator(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:creator", value);
    }

    public Calendar getCreated() throws PropertyException, ClientException {
        return (Calendar)doc.getPropertyValue("dc:created");
    }

    public void setCreated(Calendar value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:created", value);
    }

    public Calendar getModified() throws PropertyException, ClientException {
        return (Calendar)doc.getPropertyValue("dc:modified");
    }

    public void setModified(Calendar value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:modified", value);
    }

    public Calendar getIssued() throws PropertyException, ClientException {
        return (Calendar)doc.getPropertyValue("dc:issued");
    }

    public void setIssued(Calendar value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:issued", value);
    }

    public Calendar getValid() throws PropertyException, ClientException {
        return (Calendar)doc.getPropertyValue("dc:valid");
    }

    public void setValid(Calendar value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:valid", value);
    }

    public Calendar getExpired() throws PropertyException, ClientException {
        return (Calendar)doc.getPropertyValue("dc:expired");
    }

    public void setExpired(Calendar value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:expired", value);
    }

    public String[] getSubjects() throws PropertyException, ClientException {
        return (String[])doc.getPropertyValue("dc:subjects");
    }

    public void setSubjects(String[] value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:subjects", value);
    }

    public String[] getContributors() throws PropertyException, ClientException {
        return (String[])doc.getPropertyValue("dc:contributors");
    }

    public void setContributors(String[] value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:contributors", value);
    }

    public String getLastContributor() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:lastContributor");
    }

    public void setLastContributor(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:lastContributor", value);
    }

    public String getNature() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:nature");
    }

    public void setNature(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:nature", value);
    }

    public String getPublisher() throws PropertyException, ClientException {
        return (String)doc.getPropertyValue("dc:publisher");
    }

    public void setPublisher(String value) throws PropertyException, ClientException {
        doc.setPropertyValue("dc:publisher", value);
    }

	public void bind(Blob blob) throws ClientException {
		doc.setPropertyValue("file:content", (Serializable) blob);
	}

	public String getHtml() {
		return new ExternalResource(doc).getHTML();
	}

}
