package cnam.nsy209.selServices.association.client.asyncCallback;

import com.google.gwt.core.client.GWT;

import cnam.nsy209.selServices.association.client.services.AssociationService;
import cnam.nsy209.selServices.association.client.services.AssociationServiceAsync;
import cnam.nsy209.selServices.association.client.services.AuthenticationService;
import cnam.nsy209.selServices.association.client.services.AuthenticationServiceAsync;
import cnam.nsy209.selServices.association.client.services.CategoriesService;
import cnam.nsy209.selServices.association.client.services.CategoriesServiceAsync;
import cnam.nsy209.selServices.association.client.services.MembersService;
import cnam.nsy209.selServices.association.client.services.MembersServiceAsync;
import cnam.nsy209.selServices.association.client.services.MessagesService;
import cnam.nsy209.selServices.association.client.services.MessagesServiceAsync;
import cnam.nsy209.selServices.association.client.services.SuppliesDemandsService;
import cnam.nsy209.selServices.association.client.services.SuppliesDemandsServiceAsync;
import cnam.nsy209.selServices.association.client.services.TransactionsService;
import cnam.nsy209.selServices.association.client.services.TransactionsServiceAsync;

/** 
 * 
 * Class to manage all services call
 * 
 * @author lavive
 *
 */
public class ServicesProxy {

	/* instances of services proxy */
	private static AuthenticationServiceAsync authenticationService = GWT.create(AuthenticationService.class);
	private static AssociationServiceAsync associationService = GWT.create(AssociationService.class);
	private static CategoriesServiceAsync categoriesService = GWT.create(CategoriesService.class);
	private static MembersServiceAsync membersService = GWT.create(MembersService.class);
	private static MessagesServiceAsync messagesService = GWT.create(MessagesService.class);
	private static SuppliesDemandsServiceAsync suppliesDemandsService = GWT.create(SuppliesDemandsService.class);
	private static TransactionsServiceAsync transactionsService = GWT.create(TransactionsService.class);
	
	
	/* get instances of services proxy */
	public static AuthenticationServiceAsync getAuthenticationService() {
		if(authenticationService == null) authenticationService = GWT.create(AuthenticationService.class);
		return authenticationService;
	}
	public static AssociationServiceAsync getAssociationService() {
		if(associationService == null) associationService = GWT.create(AssociationService.class);
		return associationService;
	}
	public static CategoriesServiceAsync getCategoriesService() {
		if(categoriesService == null) categoriesService = GWT.create(CategoriesService.class);
		return categoriesService;
	}
	public static MembersServiceAsync getMembersService() {
		if(membersService == null) membersService = GWT.create(MembersService.class);
		return membersService;
	}
	public static MessagesServiceAsync getMessagesService() {
		if(messagesService == null) messagesService = GWT.create(MessagesService.class);
		return messagesService;
	}
	public static SuppliesDemandsServiceAsync getSuppliesDemandsService() {
		if(suppliesDemandsService == null) suppliesDemandsService = GWT.create(SuppliesDemandsService.class);
		return suppliesDemandsService;
	}
	public static TransactionsServiceAsync getTransactionsService() {
		if(transactionsService == null) transactionsService = GWT.create(TransactionsService.class);
		return transactionsService;
	}
	
}
