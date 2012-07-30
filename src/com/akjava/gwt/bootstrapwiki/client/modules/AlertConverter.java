package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.htmlconverter.AbstractConverter;
import com.akjava.wiki.client.htmlconverter.LineFolderConverter;

/**
 * support class name
 * @author aki
 *
 */
public class AlertConverter extends AbstractConverter{

	@Override
	public boolean canConvert(Node node) {
		if(node instanceof AlertCommand){
			return true;
		}
		return false;
	}

	@Override
	public String toFooter(Node node) {
		// TODO Auto-generated method stub
		return "</div>";
	}

	@Override
	public String toHeader(Node node) {
		String type=getType(node);
		String ret="<div";
					ret+=" class='alert alert-"+type+"'";
				ret+=">";
				System.out.println("type:"+type);
				//for next <p>
				if(type.equals("info")){
				System.out.println("doc-converter:"+docConverter);
				docConverter.addNodeConverterOption(LineFolderConverter.class, "<i class='icon-comment-alt'></i> ");
				}
		return ret;
	}
	
	public String getType(Node node){
		if(node.getAttributes().length>0){
			return node.getAttributes()[0];
		}else{
			return "info";
		}
	}

}
