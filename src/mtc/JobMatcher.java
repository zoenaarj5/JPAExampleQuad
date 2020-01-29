package mtc;

import biz.Job;

public enum JobMatcher implements Matcher<Job> {
	NAME,DESCRIPTION,DEADLINE;

	@Override
	public boolean match(Job t1, Job t2) {
		switch(this) {
		case DESCRIPTION:
			return t1.getDescription().toUpperCase().equals(t2.getDescription().toUpperCase());
		case NAME:
			return t1.getName().toUpperCase().equals(t2.getName().toUpperCase());
		case DEADLINE:
			return t1.getDeadline().equals(t2.getDeadline());
		default:
			return false;
		
		}
	}

	@Override
	public boolean check(Job t, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

}
