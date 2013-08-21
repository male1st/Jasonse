package com.jason.se.simple.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Snippet {
	public static void main(String[] args) {
		DynamicProxyInvocationHandler dy = new DynamicProxyInvocationHandler();
		System.out.println(dy);
	}
}

class DynamicProxyInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(proxy.getClass().getSimpleName());
		return null;
	}

}