package com.jason.se.simple.matcher;

public class CihMatcher {
	public static void main(String[] args) {
//		String num = "010-80808080";
//		System.out.println(num.matches("0\\d{2}-\\d*"));
		
		System.out.println(htmlFilterDecode("<iframe src=\"http://www.slideshare.net/slideshow/embed_code/6387437\" width=\"427\" height=\"356\" frameborder=\"0\" marginwidth=\"0\" marginheight=\"0\" scrolling=\"no\" style=\"border:1px solid #CCC;border-width:1px 1px 0;margin-bottom:5px\" allowfullscreen webkitallowfullscreen mozallowfullscreen> </iframe> <div style=\"margin-bottom:5px\"> <strong> <a href=\"http://www.slideshare.net/onemonkey/junit-6387437\" title=\"JUnit源码分析\" target=\"_blank\">JUnit源码分析</a> </strong> from <strong><a href=\"http://www.slideshare.net/onemonkey\" target=\"_blank\">onemonkey</a></strong> </div>"));
	}

	public static String htmlFilterDecode(String url) {
		url = url.replaceAll( "&","&amp;")
				.replaceAll("<","&lt;")
				.replaceAll(">","&gt;")
				.replaceAll( "\'","&apos;")
				.replaceAll( "\"","&quot;")
				.replaceAll( " ","&nbsp;")
				.replaceAll( "@","&copy;");
				//.replaceAll("?","&reg;" );
		System.out.println("filterDecodeurl" + url);
		return url;
	}
}
