package cnam.nsy209.selServices.association.client.validators.helper;

/**
 * 
 * Enum to tag input Field
 *
 */

public enum EnumField {
	ASSOCIATION_ID("association id"),
	ASSOCIATION_PASSWORD("association password"),
	ASSOCIATION_NAME("association name"),
	ASSOCIATION_ADDRESS("association address"),
	ASSOCIATION_POSTAL_CODE("association postal code"),
	ASSOCIATION_TOWN("association town"),
	ASSOCIATION_EMAIL("association email"),
	ASSOCIATION_CELL_NUMBER("association cell number"),
	ASSOCIATION_PHONE_NUMBER("association phone number"),
	ASSOCIATION_WEB_SITE("association web site"),
	CATEGORY("category"),
	MEMBER_PASSWORD("member password"),
	MEMBER_NAME("member name"),
	MEMBER_FORNAME("member forname"),
	MEMBER_ADDRESS("member address"),
	MEMBER_POSTAL_CODE("member postal code"),
	MEMBER_TOWN("member town"),
	MEMBER_EMAIL("member email"),
	MEMBER_CELL_NUMBER("member cell number"),
	MEMBER_PHONE_NUMBER("member phone number"),
	MEMBER_NAME_RESEARCH("member name research"),
	MEMBER_FORNAME_RESEARCH("member forname research"),
	MEMBER_ADDRESS_RESEARCH("member address research"),
	MEMBER_POSTAL_CODE_RESEARCH("member postal code research"),
	MEMBER_TOWN_RESEARCH("member town research"),
	MEMBER_CELL_NUMBER_RESEARCH("member cell number research"),
	AMOUNT("amount"),
	FAST_MESSAGE_TEXT("fast message text"),
	FAST_MESSAGE_TITLE("fast message title");

	String wording;
	
	EnumField(String wording){
		this.wording = wording;
	}
	
	public String getWording() {
		return this.wording;
	}
	
	public static EnumField getByWording(String wording) {
		for(EnumField enumField : values()) {
			if(enumField.getWording().equals(wording))
				return enumField;
		}
		return null;
	}
}
