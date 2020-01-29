package mtc;

public interface Matcher<T> {
	boolean match(T t1,T t2);
	boolean check(T t,Object value);
}
