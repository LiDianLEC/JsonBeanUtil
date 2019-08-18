package jerry.jsonbeans.myutils2.models;

import java.sql.Timestamp;

public class test {
	public static void main(String[] args) {
		
		Package package1 = Timestamp.class.getPackage();
		System.out.println(package1.toString());
		String simpleName = Timestamp.class.getSimpleName();
		System.out.println(simpleName);
		String canonicalName = Timestamp.class.getCanonicalName();
		System.out.println(canonicalName);
	}
}
