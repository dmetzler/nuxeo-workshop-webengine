/**
 * 
 */

package org.nuxeo.workshop.wall.api;

import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.adapter.DocumentAdapterFactory;

/**
 * @author dmetzler
 */
public class WallPostFactory implements DocumentAdapterFactory {

    @Override
    public Object getAdapter(DocumentModel doc, Class<?> itf) {
        if (doc.hasSchema("dublincore")){
            return new WallPost(doc);
        }else{
            return null;
        }
    }
}
