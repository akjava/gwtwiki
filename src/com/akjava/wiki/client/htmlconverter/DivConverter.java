package com.akjava.wiki.client.htmlconverter;

import com.akjava.wiki.client.core.Node;
import com.akjava.wiki.client.modules.SimpleCommand;

public class DivConverter extends AbstractConverter{

	@Override
	public boolean canConvert(Node node) {
		if(node instanceof SimpleCommand){
			SimpleCommand c=(SimpleCommand)node;
			return c.getName().equals("div");
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
		// TODO Auto-generated method stub
		return "<div>";
	}

}
