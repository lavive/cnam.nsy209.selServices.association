package cnam.nsy209.selServices.association.client.internationalization;

import com.google.gwt.i18n.client.Messages;

/**
 * 
 * Messages internationalization
 *
 */

public interface AssociationMessages extends Messages {
	
	/* authentication page */
	
	@DefaultMessage("Network Error")
	String associationNameError();
	
	@DefaultMessage("Wrong login or password")
	String authenticationWrong();
	
	@DefaultMessage("The call failed on the server, see server log for details")
	String netWorkError();
	
	/* fast message page */
	
	@DefaultMessage("Fast Message")
	String fastMessage();
	
	/* no input message */
	
	@DefaultMessage("No Member Input")
	String noMember();	
	
	@DefaultMessage("No Supply Input")
	String noSupply();	
	
	@DefaultMessage("No Demand Input")
	String noDemand();	
	
	@DefaultMessage("No Category Input")
	String noCategory();	
	
	@DefaultMessage("No Message Input")
	String noMessage();	
	
	@DefaultMessage("No Transaction Input")
	String noTransaction();	
	
	@DefaultMessage("No Member corresponding to research criteria")
	String noMemberResult();	
	
	/* Confirm dialog */
	
	@DefaultMessage("Are you sure?")
	String sure();
	
	/* Horizontal Menus */
	
	@DefaultMessage("Member Home")
	String homeMember();
	
	@DefaultMessage("Member Edit")
	String editMember();
	
	@DefaultMessage("Member Search")
	String searchMember();
	
	@DefaultMessage("Member Card")
	String cardMember();
	
	@DefaultMessage("Member Search Result")
	String resultMember();
	
	@DefaultMessage("Transactions List")
	String transactions();
	
	@DefaultMessage("Transaction Add")
	String addTransaction();
	
	@DefaultMessage("New Category Adding")
	String addCategory();
	
	@DefaultMessage("Association datas")
	String associationDatas();
	
	@DefaultMessage("Association datas Update")
	String associationDatasUpdate();
	
	@DefaultMessage("All Members Messages")
	String messagesMembers();
	
	/* Title */
	
	@DefaultMessage("Research Criteria")
	String researchCriteria();
	
	/* input error message */
	
	@DefaultMessage("Field must not be empty!")
	String emptyError();
	
	@DefaultMessage("There must be less than 200 characters!")
	String less200Error();
	
	@DefaultMessage("There must be less than 100 characters!")
	String less100Error();
	
	@DefaultMessage("There must be less than 50 characters!")
	String less50Error();
	
	@DefaultMessage("There must be more than 8 characters!")
	String more8Error();
	
	@DefaultMessage("Field must be a number with 2 digits max after comma!")
	String bigDecimalError();
	
	@DefaultMessage("Postal Code is not well formed!")
	String postalCodeError();
	
	@DefaultMessage("Phone Number is not well formed!")
	String phoneNumberError();
	
	@DefaultMessage("Email is not well formed!")
	String emailError();
	
	@DefaultMessage("The input must be a number!")
	String numberError();
	
	/* dialog box message */
	
	@DefaultMessage("Message has been well saved")
	String messageSaved();
	
	@DefaultMessage("Message can not have been saved, try again!")
	String messageNotSaved();
	
	@DefaultMessage("New Datas have been well saved")
	String dataSaved();
	
	@DefaultMessage("New Datas can not have been saved, try again!")
	String dataNotSaved();
	
	@DefaultMessage("Datas can not have been sended, try again!")
	String dataNotSended();
	
	/* exceptions */
	
	@DefaultMessage("alReady exists, please try a different one!")
	String alReadyExist();
	
	@DefaultMessage("Element to delete has not been found in DataBase!")
	String notFound();
	
	@DefaultMessage("Element to add has not to be empty!")
	String empty();
	
	@DefaultMessage("Member has to be the creditor or the debtor of the transaction")
	String creditorDebtor();
	
	@DefaultMessage("Supply Demand origin member has to be the creditor or the debtor of the transaction")
	String memberCreditorDebtor();
	
	@DefaultMessage("the creditor or the debtor of the transaction have to be different")
	String differentCreditorDebtor();
	
	@DefaultMessage("Origin member is the creditor, the transaction has to be for a supply")
	String creditorSupply();
	
	@DefaultMessage("Origin member is the debtor, the transaction has to be for a demand")
	String debtorDemand();
	
	/* confirm message */
	
	@DefaultMessage("Association has been well updated")
	String updateAssociationConfirm();

	@DefaultMessage("Category has been well added")
	String addCategoryConfirm();

	@DefaultMessage("Member has been well added")
	String addMemberConfirm();

	@DefaultMessage("Member has been well updated")
	String updateMemberConfirm();

	@DefaultMessage("Message has been well saved")
	String addMessageConfirm();

	@DefaultMessage("Transaction has been well saved")
	String addTransactionConfirm();

}
