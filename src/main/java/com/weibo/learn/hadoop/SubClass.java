

package com.weibo.learn.hadoop;


/**
 * SubClass.java V1.1
 * @Author:June
 * @Date: 2014年12月16日 下午1:37:49
 * @Description:TODO
 */
public class SubClass extends Parent {

	private static String staticSubVar = "subclass static varivable";
	
	static {
		System.out.println(staticSubVar);
		System.out.println("sub static block");
	}

	private String subVar = "subclass varivable";
	
	{
		System.out.println(subVar);
		System.out.println("sub init block");
	}
	
	public SubClass() {
		System.out.println("subclass constructor");
	}
	
	
	public static void main( String [] args)
	{
		System.out.println("test start");
		new SubClass();
	}

}

