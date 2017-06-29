package com.scw.kindergarten.view;

import javax.annotation.PostConstruct;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.springframework.stereotype.Component;

@Component("dashboardView")
public class DashboardView {

	private DashboardModel model;

	@PostConstruct
	public void init() {
		model = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
		DashboardColumn column2 = new DefaultDashboardColumn();
		// DashboardColumn column3 = new DefaultDashboardColumn();
		column1.addWidget("sports");
		column2.addWidget("finance");
		column2.addWidget("lifestyle");
		column2.addWidget("weather");
		column1.addWidget("politics");
		model.addColumn(column1);
		model.addColumn(column2);
		// model.addColumn(column3);
	}

	public DashboardModel getModel() {
		return model;
	}

	public void setModel(DashboardModel model) {
		this.model = model;
	}

}
