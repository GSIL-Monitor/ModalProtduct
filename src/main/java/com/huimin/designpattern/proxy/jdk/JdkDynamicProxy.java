package com.huimin.designpattern.proxy.jdk;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.huimin.designpattern.proxy.ISinger;
import com.huimin.designpattern.proxy.MySinger;

import sun.misc.ProxyGenerator;
/**
 * jdk中的动态代理通过反射类Proxy和InvocationHandler回调接口实现，
 * 要求委托类必须实现一个接口，只能对该类接口中定义的方法实现代理，
 * 这在实际编程中有一定的局限性。
 * @author zhuliang
 *
 * @Date 2018年11月21日下午4:30:13
 */
public class JdkDynamicProxy implements InvocationHandler{

	private Object proxy;
	public JdkDynamicProxy(Object proxy) {
		this.proxy = proxy;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始执行方法");
		Object result = method.invoke(this.proxy, args);
		System.out.println("执行方法完成");
		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(proxy.getClass().getClassLoader(), proxy.getClass().getInterfaces(), this);
	}
	
	public static void main(String[] args) throws Exception {
	    Object object = new JdkDynamicProxy( new MySinger()).getProxy();
	    ISinger iSinger = (ISinger) object;
	    Class<? extends ISinger> clazz = iSinger.getClass();
		System.out.println(clazz);
	    System.out.println(clazz.getSuperclass());
	    Class<?>[] interfaces = clazz.getInterfaces();
	    for (Class<?> class1 : interfaces) {
	    	System.out.println(class1);
		}
	    Method[] methods = clazz.getDeclaredMethods();
	    for (Method method : methods) {
			System.out.println(method.getName());
		}
	    iSinger.sing();
//	    Object object = new JdkDynamicProxy( new CjlbISinger()).getProxy();
//	    CjlbISinger iSinger = (CjlbISinger) object;
//	    Class<? extends CjlbISinger> clazz = iSinger.getClass();
//	    System.out.println(clazz);
//	    System.out.println(clazz.getSuperclass());
//	    Class<?>[] interfaces = clazz.getInterfaces();
//	    for (Class<?> class1 : interfaces) {
//	    	System.out.println(class1);
//	    }
//	    Method[] methods = clazz.getDeclaredMethods();
//	    for (Method method : methods) {
//	    	System.out.println(method.getName());
//	    }
//	    iSinger.sing();
//        ISinger2 iSinger2 = (ISinger2) object;
//        iSinger2.eat();
	    
	    
	    byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "TestProxyGen", MySinger.class.getInterfaces());       
        FileOutputStream fos = new FileOutputStream("E:\\myself\\jar\\cjlb\\动态代理cglib\\TestProxyGen.class");
        fos.write(proxyClassFile);
        fos.flush();
        fos.close();
	}
	
	
}
