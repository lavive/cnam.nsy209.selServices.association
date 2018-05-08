package cnam.nsy209.selServices.association.client.internationalization;

import com.google.gwt.i18n.client.Constants;

/**
 * 
 * Constants Internationalization
 *
 */
public interface AssociationConstants extends Constants {
	
	/* authentication page */
	
	@DefaultStringValue("Authentication")
	String authentication();
	
	@DefaultStringValue("Login")
	String login();

	@DefaultStringValue("Password")
	String password();
	
	@DefaultStringValue("Validate")
	String validate();
	
	/* menu page */
	
	@DefaultStringValue("Home")
	String home();
	
	@DefaultStringValue("Members")
	String members();

	@DefaultStringValue("Supplies/Demands")
	String suppliesDemands();
	
	@DefaultStringValue("Messages")
	String messages();
	
	@DefaultStringValue("Categories")
	String categories();
	
	@DefaultStringValue("Particulars")
	String particulars();
	
	@DefaultStringValue("Transaction")
	String transaction();
	
	/* fast message page */
	
	@DefaultStringValue("Send")
	String send();	
	
	@DefaultStringValue("Subject")
	String subject();	
	
	@DefaultStringValue("Body")
	String body();	
	
	/* person table column title */
	
	@DefaultStringValue("Forname")
	String forname();	
	
	@DefaultStringValue("Name")
	String name();	
	
	@DefaultStringValue("Address")
	String address();	
	
	@DefaultStringValue("Postal_Code")
	String postalCode();	
	
	@DefaultStringValue("Town")
	String town();	
	
	@DefaultStringValue("Email")
	String email();	
	
	@DefaultStringValue("Cell_Number")
	String cellNumber();	
	
	@DefaultStringValue("Phone_Number")
	String phoneNumber();		
	
	@DefaultStringValue("Web_Site")
	String webSite();
	
	@DefaultStringValue("Delete")
	String delete();
	
	@DefaultStringValue("Look")
	String look();
	
	/* wealthSheet table column title */
	
	@DefaultStringValue("Creditor")
	String creditor();	
	
	@DefaultStringValue("Debtor")
	String debtor();	
	
	@DefaultStringValue("Supply/Demand")
	String supplyDemand();	
	
	@DefaultStringValue("Amount")
	String amount();	
	
	@DefaultStringValue("Account")
	String account();	
	
	/* supply demand table column title */	
	
	@DefaultStringValue("Category")
	String category();
	
	@DefaultStringValue("Description")
	String description();
	
	@DefaultStringValue("Emitter")
	String emitter();
	
	/* message table column title */	
	
	@DefaultStringValue("Date")
	String date();
	
	@DefaultStringValue("Title")
	String title();
	
	@DefaultStringValue("Statement")
	String statement();
	
	/* DTO Display/edit */
	
	@DefaultStringValue("Card")
	String card();
	
	@DefaultStringValue("Edit")
	String edit();
	
	@DefaultStringValue("Update")
	String update();
	
	@DefaultStringValue("WealthSheet")
	String wealthSheet();
	
	@DefaultStringValue("Reset")
	String reset();
	
	
	/* Confirm dialog */
	
	@DefaultStringValue("Confirm")
	String confirm();
	
	@DefaultStringValue("Cancel")
	String cancel();
	
	@DefaultStringValue("OK")
	String ok();
	
	/* Horizontal Menus */
	
	@DefaultStringValue("Supplies")
	String supplies();
	
	@DefaultStringValue("Demands")
	String demands();
	
	
	/* Menu Member */
	
	@DefaultStringValue("Search")
	String search();
	
	@DefaultStringValue("Add")
	String add();
	
	@DefaultStringValue("Back")
	String back();
	
	/* Colors */
	@DefaultStringValue("DeepSkyBlue")
	String backgroundColor();
	
	
	

}
