package com.akjava.gwt.wiki.client.ui;

import com.akjava.gwt.wiki.client.TextInsertTarget;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class AnchorInput extends HorizontalPanel{
TextInsertTarget target;
	public AnchorInput(TextInsertTarget ta){
		this.target=ta;
		Button bt=new Button("A",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String url=Window.prompt("URL", "http://");
				if(url!=null){
					target.tagText("<a href='"+url+"'>","</a>");
				}
			}
		});
		add(bt);
		 bt.setSize(ButtonSize.SMALL);
		
		}
	
}
