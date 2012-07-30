package com.akjava.wiki.client.parser;

import com.akjava.gwt.bootstrapwiki.client.modules.LineContainer;
import com.akjava.wiki.client.core.Element;
import com.akjava.wiki.client.core.LineParser;

public class LineContainerParser implements LineParser {
	private LineContainer container;
	public LineContainerParser(LineContainer container){
		this.container=container;
	}
	@Override
	public boolean canParse(String line) {
		// break at element breakup
		return true;
	}

	@Override
	public Element parse(Element element, String line) {
		container.addLine(line);
		return element;
	}

}
