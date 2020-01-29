package mtc;

import biz.Company;

public enum CompanyMatcher implements Matcher<Company> {
	FOUNDING_DATE,AGE,NAME,DESCRIPTION;

	@Override
	public boolean match(Company t1, Company t2) {
		switch(this) {
		case AGE:
			return t1.getAge()==t2.getAge();
		case DESCRIPTION:
			return t1.getDescription().toUpperCase().equals(t2.getDescription().toUpperCase());
		case FOUNDING_DATE:
			return t1.getFoundingDate().equals(t2.getFoundingDate());
		case NAME:
			return t1.getName().toUpperCase().equals(t2.getName().toUpperCase());
		default:
			return false;
		}
	}

	@Override
	public boolean check(Company t, Object value) {
		switch(this) {
		case AGE:
			return Integer.valueOf(t.getAge()).equals(value);
		case DESCRIPTION:
			return t.getDescription().toUpperCase().equals(value);
		case FOUNDING_DATE:
			return t.getFoundingDate().equals(value);
		case NAME:
			return t.getName().toUpperCase().equals(value);
		default:
			return false;
		
		}
	}

}
