/**
 *  Class get in GitHub
 *  
 *  because java.util.Observable do not work with GWT
 */
package cnam.nsy209.selServices.association.client.view.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author rohit
 * 
 */
@SuppressWarnings("serial")
public class Observable implements Serializable {
	@SuppressWarnings("rawtypes")
	private List observers;

	/**
	 * Add an Observer
	 * 
	 * @param observer
	 *            Add Observer who is interested in this Observable
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addObserver(Observer observer) {
		if (observers == null) {
			observers = new ArrayList();
		}
		observers.add(observer);
	}

	/**
	 * Remove an Observer
	 * 
	 * @param observer
	 *            Remove Observer who is no longer interested in this Observable
	 */
	public void removeObserver(Observer observer) {
		if (observers != null) {
			observers.remove(observer);
		}
	}

	/**
	 * Notify all the Observer of a change
	 * 
	 */
	public void notifyObservers() {
		notifyObservers(null);
	}

	/**
	 * Notify all the Observer of a change along with an Hint Object
	 * 
	 * @param hint
	 *            Hint to the Observers as to what they should do.
	 */
	@SuppressWarnings("rawtypes")
	public void notifyObservers(Object hint) {
		if (observers != null) {
			Iterator iter = this.observers.iterator();
			while (iter.hasNext()) {
				Observer observer = (Observer) iter.next();
				observer.update(this, hint);
			}
		}
	}

}