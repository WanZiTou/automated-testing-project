package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools {
	/**
	 * This method is for judge the string null or not null
	 * 
	 * @author Young
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		return (str == null ? true : false);
	}

	/**
	 * This method is for judge the string is empty or not
	 * 
	 * @author Young
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str.equals("") ? true : false);
	}

	/**
	 * This method is for judge null or empty
	 * 
	 * @author Young
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		return (isNull(str) || isEmpty(str));
	}

	/**
	 * This method is for get the matcher string
	 * 
	 * @author Young
	 * @param source
	 * @param rex
	 * @return
	 */
	public static String getMatch(String source, String rex) {
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) {
			return source.substring(matcher.start(), matcher.end());
		}
		return null;

	}
	/**
	 * This method is for get the matcher string
	 * 
	 * @author Young
	 * @param source
	 * @param rex
	 * @return
	 */
	public static int getMatchPage(String source, String rex) {
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) {
			return Integer.parseInt(matcher.group(1));
		}
		return 0;

	}
	/**
	 * get the match group
	 * 
	 * @author Young
	 * @param source
	 * @param rex
	 * @param groupIndex
	 * @return
	 */
	public static String getMatchGroup(String source, String rex, int groupIndex) {
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) {
			return matcher.group(groupIndex);
		}
		return null;

	}

	/**
	 * This method is for replaceAll the string
	 * 
	 * @author Young
	 * @param source
	 * @param rex
	 * @param replaceBy
	 */
	public static void replaceAll(String source, String rex, String replaceBy) {
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) {
			matcher.replaceAll(replaceBy);
		}
	}

	/**
	 * This method is for judge is match 
	 * @author Young
	 * @param source
	 * @param rex
	 * @return
	 */
	public static boolean isMatch(String source, String rex) {
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(source);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		
	
		String testStr = "1 / 17690页";  
		Pattern p = Pattern.compile("/ (.*)页");  
		Matcher m = p.matcher(testStr);  
		while(m.find()){  
		System.out.println(m.group(1));  
		}
	}
}
