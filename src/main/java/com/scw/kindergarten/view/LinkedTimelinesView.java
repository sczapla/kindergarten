package com.scw.kindergarten.view;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;
import org.springframework.stereotype.Component;

@Component("linkedTimelinesView")
@ViewScoped
public class LinkedTimelinesView {
	private TimelineModel modelFirst;  // model of the first timeline  
 
    @PostConstruct
    public void init() {
        createFirstTimeline();
    }
 
    private void createFirstTimeline() {
        modelFirst = new TimelineModel();
 
        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.AUGUST, 22, 17, 30, 0);
        modelFirst.add(new TimelineEvent(new Task("Mail from boss", "images/timeline/mail.png", false), cal.getTime()));
 
        cal.set(2015, Calendar.AUGUST, 23, 23, 0, 0);
        modelFirst.add(new TimelineEvent(new Task("Call back my boss", "images/timeline/callback.png", false), cal.getTime()));
 
        cal.set(2015, Calendar.AUGUST, 24, 21, 45, 0);
        modelFirst.add(new TimelineEvent(new Task("Travel to Spain", "images/timeline/location.png", false), cal.getTime()));
 
        cal.set(2015, Calendar.AUGUST, 26, 0, 0, 0);
        Date startWork = cal.getTime();
        cal.set(2015, Calendar.SEPTEMBER, 2, 0, 0, 0);
        Date endWork = cal.getTime();
        modelFirst.add(new TimelineEvent(new Task("Do homework", "../favicon/germany.png", true), startWork, endWork));
 
        cal.set(2015, Calendar.AUGUST, 28, 0, 0, 0);
        modelFirst.add(new TimelineEvent(new Task("Create memo", "images/timeline/memo.png", false), cal.getTime()));
 
        cal.set(2015, Calendar.AUGUST, 31, 0, 0, 0);
        Date startReport = cal.getTime();
        cal.set(2015, Calendar.SEPTEMBER, 3, 0, 0, 0);
        Date endReport = cal.getTime();
        modelFirst.add(new TimelineEvent(new Task("Create report", "../favicon/poland.png", true), startReport, endReport));
    }
    
    public TimelineModel getModelFirst() {
		return modelFirst;
	}

	public void setModelFirst(TimelineModel modelFirst) {
		this.modelFirst = modelFirst;
	}

	public class Task implements Serializable {
    	 
        private String title;
        private String imagePath;
        private boolean period;
 
        public Task(String title, String imagePath, boolean period) {
            this.title = title;
            this.imagePath = imagePath;
            this.period = period;
        }
 
        public String getTitle() {
            return title;
        }
 
        public String getImagePath() {
            return imagePath;
        }
 
        public boolean isPeriod() {
            return period;
        }
    }
}
