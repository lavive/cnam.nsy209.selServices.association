package cnam.nsy209.selServices.association.client.view.helper;

/**
 * 
 * To re implement Observer/Observable pattern
 * 
 * because java.util.Observer do not work with GWT
 *
 */

public interface Observer {

	public void update(Observable observable, Object object);
}
