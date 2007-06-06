package com.retroduction.carma.core.runner.events;

import java.util.Vector;

import com.retroduction.carma.core.runner.events.IEvent;
import com.retroduction.carma.core.runner.events.IEventListener;

public class EventListenerMock implements IEventListener {

	private Vector<IEvent> events = new Vector<IEvent>();
	
	public void notifyEvent(IEvent event) {
		events.add(event);
	}

	public Vector<IEvent> getEvents() {
		return events;
	}
	
	public void destroy() {
	}

}