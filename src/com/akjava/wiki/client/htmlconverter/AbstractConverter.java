/*
 * Created on 2005/09/04
 * Author aki@akjava.com
 * License Apache2.0 or Common Public License
 */
package com.akjava.wiki.client.htmlconverter;

import com.akjava.wiki.client.core.DocumentConverter;
import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.core.NodeConverter;

/**
 * 
 *
 */
public abstract class AbstractConverter implements NodeConverter{
    
    /* (non-Javadoc)
     * @see org.jpn.xucker.wiki.NodeConverter#convertChildren(org.jpn.xucker.wiki.Node)
     */
    public String convertChildren(Node node,String value) {
        // TODO Auto-generated method stub
        return value;
    }

    protected String option;
    public void setNextOption(String option){
    	this.option=option;
    }
    protected DocumentConverter docConverter;
	@Override
	public void setDocumentConverter(DocumentConverter docConverter) {
		this.docConverter=docConverter;
	}
  
    
}
