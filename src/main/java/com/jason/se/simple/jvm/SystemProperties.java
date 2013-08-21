package com.jason.se.simple.jvm;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class SystemProperties {
	public static void main(String[] args) {
		Properties syspr = System.getProperties();
		Iterator<?> it = syspr.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> map = extracted(it);
			System.out.println(map.getKey() + ":" + map.getValue());
		}
	}

	@SuppressWarnings("unchecked")
	private static Entry<String, String> extracted(Iterator<?> it) {
		return (Map.Entry<String, String>) it.next();
	}
}
