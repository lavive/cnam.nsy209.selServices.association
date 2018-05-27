package cnam.nsy209.selServices.association.client.resources;

import com.google.gwt.core.client.GWT;


/** 
 * 
 * Class to manage ressources
 * 
 * @author lavive
 *
 */

public class Res {

	/* get resources */
	private static Resources resources = GWT.create(Resources.class);
	
	public static Resources getResources() {
		return resources;
	}
	
	/* get version */
	private static Version version = GWT.create(Version.class);
	
	public static Version getVersion() {
		return version;
	}
}
