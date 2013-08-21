package com.jason.se.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/**
* @ClassName: SerializebleCloneable
* @Description: TODO
(
创建并返回此对象的一个副本。“副本”的准确含义可能依赖于对象的类。这样做的目的是，对于任何对象 x，表达式： 
x.clone() != x为 true，表达式： 
x.clone().getClass() == x.getClass()也为 true，但这些并非必须要满足的要求。一般情况下： 
x.clone().equals(x)为 true，但这并非必须要满足的要求。 
按照惯例，返回的对象应该通过调用 super.clone 获得。如果一个类及其所有的超类（Object 除外）都遵守此约定，则 x.clone().getClass() == x.getClass()。
)
* @author Jason Chiu:CIHUnKnown@Gmail.com
* @date 2013-8-13 上午01:34:23
* 
*/
public class SerializebleCloneable {
	
	@Test
	public void test() throws CloneNotSupportedException {
		SimpleClone simple = new SimpleClone();
		simple.setName("name");
		simple.setAge(1);
		DeepClone dep=new DeepClone();
		dep.setWigth(33);
		dep.setYue("zzzzzzzzzz");
		simple.setDeepClone(dep);
		SimpleClone spc = (SimpleClone) simple.clone();
		System.out.println(spc.getDeepClone()==simple.getDeepClone());
		
		System.out.println(simple.getDeepClone().getYue());
	}
}

/**
* @ClassName: SimpleClone
* @Description: TODO(..)
* @author Jason Chiu:CIHUnKnown@Gmail.com
* @date 2013-8-13 上午01:34:35
* 
*/
class SimpleClone implements Cloneable,Serializable{
	private static final long serialVersionUID = -6871280366046089108L;
	private String name;
	private int age;
	private DeepClone deepClone;
	
	public DeepClone getDeepClone() {
		return deepClone;
	}

	public void setDeepClone(DeepClone deepClone) {
		this.deepClone = deepClone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//Object为浅Clone
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	//Serializable为深度Clone
	protected Object deepClone() throws Exception{
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(this);
		ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		return ois.readObject();
	}
}

class DeepClone{
	private String yue;
	private int wigth;
	public String getYue() {
		return yue;
	}
	public void setYue(String yue) {
		this.yue = yue;
	}
	public int getWigth() {
		return wigth;
	}
	public void setWigth(int wigth) {
		this.wigth = wigth;
	}
	
} 
