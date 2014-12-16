

package com.weibo.learn.hadoop;
/**
 * Parent.java V1.1
 * @Author:June
 * @Date: 2014年12月16日 上午11:48:31
 * @Description:TODO
 */
public class Parent {
	private static String staticParentVar = "STATIC VARIBAL";
	
	static {
		System.out.println(staticParentVar);
		System.out.println("static block");
	}
	
	private String parentVar = "VARIBAL";
	
	{
		System.out.println(parentVar);
		System.out.println("init block");
	}
	
	public Parent() {
		System.out.println("constructor");
	}
}

