package com.huimin.designpattern.proxy.cjlb;
import java.lang.reflect.Method;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.huimin.designpattern.proxy.CjlbISinger;

/**
 * cglib实现
      使用cglib[Code Generation Library]实现动态代理，
      并不要求委托类必须实现接口，底层采用asm字节码生成框架生成代理类的字节码，
      下面通过一个例子看看使用CGLib如何实现动态代理。
      
      
      
jdk和cglib动态代理实现的区别
1、jdk动态代理生成的代理类和委托类实现了相同的接口；
2、cglib动态代理中生成的字节码更加复杂，生成的代理类是委托类的子类，且不能处理被final关键字修饰的方法；
3、jdk采用反射机制调用委托类的方法，cglib采用类似索引的方式直接调用委托类方法；
 * @author zhuliang
 *
 * @Date 2018年11月21日下午4:30:52
 */
public class CjlibDynamicProxy implements MethodInterceptor{

	private Object proxy;
	public CjlibDynamicProxy(Object proxy) {
		this.proxy = proxy;
	}


	public Object getProxy() {
		Enhancer enhancer = new Enhancer();  
		enhancer.setSuperclass(proxy.getClass());  
		enhancer.setCallback(this);  
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("开始执行方法");
		method.invoke(proxy, args);
		methodProxy.invoke(proxy, args);
	//	method.invoke(object, args);
		Object result = methodProxy.invokeSuper(object, args);
		System.out.println("执行方法完成");
		return result;
	}
	public static void main(String[] args) throws Exception {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\myself\\jar\\cjlb\\cglibJar");
		CjlbISinger cjlbISinger = (CjlbISinger) new CjlibDynamicProxy( new CjlbISinger(1)).getProxy();
		Class<? extends CjlbISinger> clazz = cjlbISinger.getClass();
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
		cjlbISinger.sing();
		//cjlbISinger.eat();;
		
//		System.out.println(System.getProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY));
//		ISinger iSinger = (ISinger) new CjlbDynamicProxy( new MySinger()).getProxy();
//		Class<? extends ISinger> clazz = iSinger.getClass();
//		System.out.println(clazz);
//		System.out.println(clazz.getSuperclass());
//		Class<?>[] interfaces = clazz.getInterfaces();
//		for (Class<?> class1 : interfaces) {
//			System.out.println(class1);
//		}
//		Method[] methods = clazz.getDeclaredMethods();
//		for (Method method : methods) {
//			System.out.println(method.getName());
//		}
//		iSinger.sing();
//        ISinger2 iSinger2 = (ISinger2) object;
//        iSinger2.eat();
	}
	
	
}
