package mtc;

import biz.Person;

public enum PersonMatcher implements Matcher<Person>{
	ID,USER_NAME,EMAIL,PASSWORD,FIRST_NAME,LAST_NAME;

	@Override
	public boolean match(Person t1, Person t2) {
		switch(this) {
		case EMAIL:
			return t1.getEmail().toUpperCase().equals(t2.getEmail().toUpperCase());
		case FIRST_NAME:
			return t1.getFirstName().toUpperCase().equals(t2.getFirstName().toUpperCase());
		case ID:
			return t1.getId()==t2.getId();
		case LAST_NAME:
			return t1.getLastName().toUpperCase().equals(t2.getLastName().toUpperCase());
		case PASSWORD:
			return t1.getPassword().toUpperCase().equals(t2.getPassword().toUpperCase());
		case USER_NAME:
			return t1.getUserName().toUpperCase().equals(t2.getUserName().toUpperCase());
		default:
			return false;
			
		}
	}

	@Override
	public boolean check(Person t, Object value) {
		switch(this) {
		case EMAIL:
			return t.getEmail().toUpperCase().equals(((String)value).toUpperCase());
		case FIRST_NAME:
			return t.getFirstName().toUpperCase().equals(((String)value).toUpperCase());
		case ID:
			return Long.valueOf(t.getId()).equals(value);
		case LAST_NAME:
			return t.getLastName().toUpperCase().contentEquals(((String)value).toUpperCase());
		case PASSWORD:
			return t.getPassword().toUpperCase().equals(((String)value).toUpperCase());
		case USER_NAME:
			return t.getUserName().toUpperCase().contentEquals(((String)value).toUpperCase());
		default:
			return false;
			
		}
	}

}
