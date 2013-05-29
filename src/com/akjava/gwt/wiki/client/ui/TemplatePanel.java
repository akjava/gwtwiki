package com.akjava.gwt.wiki.client.ui;

import java.util.List;

import com.akjava.gwt.lib.client.HeaderAndValue;
import com.akjava.gwt.lib.client.StorageControler;
import com.akjava.gwt.lib.client.StorageDataList;
import com.github.gwtbootstrap.client.ui.Label;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TemplatePanel extends HorizontalPanel {

	
	StorageDataList controler=new StorageDataList(new StorageControler(),"template");
	private TextArea inputText;
	private TextBox inputName;
	private int currentId=-1;
	private VerticalPanel templateList;
	public TemplatePanel(){
		
		VerticalPanel main=new VerticalPanel();
		VerticalPanel list=new VerticalPanel();
		list.setWidth("200px");
		
		add(main);
		add(list);
		
		
		HorizontalPanel controler=new HorizontalPanel();
		inputName = new TextBox();
		controler.add(inputName);
		main.add(controler);
		
		Button newBt=new Button("new");
		newBt.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				doNew();
			}
		});
		
		
		Button bt=new Button("save");
		bt.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				doSave();
			}
		});
		controler.add(bt);
		controler.add(newBt);
		
		//inputText = new TextA
		inputText = new TextArea();
		inputText.setSize("600px", "600px");
		main.add(inputText);
		templateList = new VerticalPanel();
		list.add(templateList);
		
		updateList();
		
		
	}
	
	
	protected void doNew() {
		//TODO confirm
		currentId=-1;
		inputName.setText("");
		inputText.setText("");
	}


	protected void doSave() {
		if(inputName.getText().isEmpty()){
			return;
		}
		if(inputText.getText().isEmpty()){
			return;
		}
		if(currentId==-1){
		currentId=controler.addData(inputName.getText(), inputText.getText());
		updateList();
		}else{
			controler.updateData(currentId, inputName.getText(), inputText.getText());
		}
	}


	private void updateList() {
		templateList.clear();
		List<HeaderAndValue> dataList=controler.getDataList();
		for(HeaderAndValue data:dataList){
			final HeaderAndValue cdata=data;
			Label label=new Label(data.getHeader());
			label.setWidth("100%");
			label.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					inputName.setText(cdata.getHeader());
					inputText.setText(cdata.getData());
					currentId=cdata.getId();
				}
			});
			templateList.add(label);
		}
	}


	public interface Storeable{
		public String getHeader();
		public String getBody();
	
		public void setHeader(String header);
		public void setBody(String body);
	}
	
}
