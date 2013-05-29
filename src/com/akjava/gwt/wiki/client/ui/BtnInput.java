package com.akjava.gwt.wiki.client.ui;

import com.akjava.gwt.wiki.client.TextInsertTarget;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.DropdownButton;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.resources.ButtonSize;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class BtnInput extends HorizontalPanel{
TextInsertTarget target;
	public BtnInput(TextInsertTarget ta){
		this.target=ta;
		
		
		final ListBox list=new ListBox();
		list.setWidth("80px");
		list.addItem("bt-type");
		list.addItem("primary");
		list.addItem("info");
		
		list.addItem("success");
		list.addItem("warning");
		list.addItem("danger");
		list.addItem("inverse");
		list.setSelectedIndex(0);
		add(list);
		
		final ListBox size=new ListBox();
		size.setWidth("90px");
		size.addItem("bt-size");
		size.addItem("large");
		size.addItem("small");
		size.addItem("mini");
		size.setSelectedIndex(0);
		add(size);
		
		final ListBox plus=new ListBox();
		plus.setWidth("90px");
		plus.addItem("plus-txt");
		plus.addItem("space>>"," &raquo;");
		plus.addItem(">>","&raquo;");
		plus.setSelectedIndex(0);
		add(plus);
		
		
		Button bt=new Button("Btn",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String url=Window.prompt("URL", "http://");
				if(url!=null){
					String options="";
					
					if(list.getSelectedIndex()!=0){
						options+=" "+list.getItemText(list.getSelectedIndex());
					}
					
					if(size.getSelectedIndex()!=0){
						options+=" "+size.getItemText(size.getSelectedIndex());
					}
					String plusText="";
					if(plus.getSelectedIndex()!=0){
						plusText=plus.getValue(plus.getSelectedIndex());
					}
					target.tagText("<btn href='"+url+"'"+options+">",plusText+"</btn>");
				}
			}
		});
		add(bt);
		bt.setSize(ButtonSize.SMALL);
		
		
		}
	
}
