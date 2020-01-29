package mtc;

import biz.Application;

public enum ApplicationMatcher implements Matcher<Application>{
	ID,SENDING_DATE,RECEIVING_DATE,ACCEPTANCE_DATE,SIGNING_DATE,SENT,RECEIVED,ACCEPTED,SIGNED;

	@Override
	public boolean match(Application t1, Application t2) {
		switch(this) {
		case ACCEPTANCE_DATE:
			return t1.getAcceptanceDate().equals(t2.getAcceptanceDate());
		case ACCEPTED:
			return t1.isAccepted()==t2.isAccepted();
		case ID:
			return t1.getId()==t2.getId();
		case RECEIVED:
			return t1.isReceived()==t2.isReceived();
		case RECEIVING_DATE:
			return t1.getReceivingDate().equals(t2.getReceivingDate());
		case SENDING_DATE:
			return t1.getSendingDate().equals(t2.getSendingDate());
		case SENT:
			return t1.isSent()==t2.isSent();
		case SIGNED:
			return t1.isSigned()==t2.isSigned();
		case SIGNING_DATE:
			return t1.getSigningDate().equals(t2.getSigningDate());
		default:
			return false;
		
		}
	}

	@Override
	public boolean check(Application t, Object value) {
		switch(this) {
		case ACCEPTANCE_DATE:
			return t.getAcceptanceDate().equals(value);
		case ACCEPTED:
			return Boolean.valueOf(t.isAccepted()).equals(value);
		case ID:
			return Long.valueOf(t.getId()).equals(value);
		case RECEIVED:
			return Boolean.valueOf(t.isReceived()).equals(value);
		case RECEIVING_DATE:
			return t.getReceivingDate().equals(value);
		case SENDING_DATE:
			return t.getSendingDate().equals(value);
		case SENT:
			return Boolean.valueOf(t.isSent()).equals(value);
		case SIGNED:
			return Boolean.valueOf(t.isSigned()).equals(value);
		case SIGNING_DATE:
			return t.getSigningDate().equals(value);
		default:
			return false;
		
		}
	}
}
