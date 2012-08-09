package com.akjava.gwt.bootstrapwiki.client.modules;

import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.htmlconverter.AbstractConverter;

/**
 * support class name
 * @author aki
 *
 */
public class DivClassConverter extends AbstractConverter{

	@Override
	public boolean canConvert(Node node) {
		if(node instanceof DivCommand){
			return true;
		}
		return false;
	}

	@Override
	public String toFooter(Node node) {
		// TODO Auto-generated method stub
		return "</div>"+(isPretty()?LINE_SEPARATOR:"");
	}

	@Override
	public String toHeader(Node node) {
		String ret="<div";
				if(node.getAttributes().length>0){
					ret+=" class='"+node.getAttributes()[0]+"'";
				}
				ret+=">"+(isPretty()?LINE_SEPARATOR:"");
		return ret;
	}

}
