package com.huimin.designpattern.proxy.cjlb;

import java.lang.reflect.Method;

import org.springframework.cglib.core.ReflectUtils;
import org.springframework.cglib.core.Signature;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Factory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.huimin.designpattern.proxy.CjlbISinger;

public class CjlbISinger$$EnhancerByCGLIB$$a8321336 extends CjlbISinger implements Factory{
//	private boolean CGLIB$BOUND;
//    public static Object CGLIB$FACTORY_DATA;
//    private static final ThreadLocal CGLIB$THREAD_CALLBACKS;
//    private static final Callback[] CGLIB$STATIC_CALLBACKS;
//    private MethodInterceptor CGLIB$CALLBACK_0;
//    private static Object CGLIB$CALLBACK_FILTER;
//    private static final Method CGLIB$sing$0$Method;
//    private static final MethodProxy CGLIB$sing$0$Proxy;
//    private static final Object[] CGLIB$emptyArgs;
//    private static final Method CGLIB$equals$1$Method;
//    private static final MethodProxy CGLIB$equals$1$Proxy;
//    private static final Method CGLIB$toString$2$Method;
//    private static final MethodProxy CGLIB$toString$2$Proxy;
//    private static final Method CGLIB$hashCode$3$Method;
//    private static final MethodProxy CGLIB$hashCode$3$Proxy;
//    private static final Method CGLIB$clone$4$Method;
//    private static final MethodProxy CGLIB$clone$4$Proxy;
    private boolean CGLIB$BOUND;
    public static Object CGLIB$FACTORY_DATA;
    private static  ThreadLocal CGLIB$THREAD_CALLBACKS;
    private static  Callback[] CGLIB$STATIC_CALLBACKS;
    private MethodInterceptor CGLIB$CALLBACK_0;
    private static Object CGLIB$CALLBACK_FILTER;
    private static  Method CGLIB$sing$0$Method;
    private static  MethodProxy CGLIB$sing$0$Proxy;
    private static  Object[] CGLIB$emptyArgs;
    private static  Method CGLIB$equals$1$Method;
    private static  MethodProxy CGLIB$equals$1$Proxy;
    private static  Method CGLIB$toString$2$Method;
    private static  MethodProxy CGLIB$toString$2$Proxy;
    private static  Method CGLIB$hashCode$3$Method;
    private static  MethodProxy CGLIB$hashCode$3$Proxy;
    private static  Method CGLIB$clone$4$Method;
    private static  MethodProxy CGLIB$clone$4$Proxy;
    static {
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$STATICHOOK1();
    }
    static void CGLIB$STATICHOOK1() {
        try {
			CGLIB$THREAD_CALLBACKS = new ThreadLocal();
			CGLIB$emptyArgs = new Object[0];
			Class<?> class_ = Class.forName("com.huimin.designpattern.proxy.CjlbISinger$$EnhancerByCGLIB$$a8321336");
			Class<?> class_2 = Class.forName("java.lang.Object");
			Method[] arrmethod = ReflectUtils.findMethods((String[])new String[]{"equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "clone", "()Ljava/lang/Object;"}, (Method[])class_2.getDeclaredMethods());
			CGLIB$equals$1$Method = arrmethod[0];
			CGLIB$equals$1$Proxy = MethodProxy.create(class_2, class_, (String)"(Ljava/lang/Object;)Z", (String)"equals", (String)"CGLIB$equals$1");
			CGLIB$toString$2$Method = arrmethod[1];
			CGLIB$toString$2$Proxy = MethodProxy.create(class_2, class_, (String)"()Ljava/lang/String;", (String)"toString", (String)"CGLIB$toString$2");
			CGLIB$hashCode$3$Method = arrmethod[2];
			CGLIB$hashCode$3$Proxy = MethodProxy.create(class_2, class_, (String)"()I", (String)"hashCode", (String)"CGLIB$hashCode$3");
			CGLIB$clone$4$Method = arrmethod[3];
			CGLIB$clone$4$Proxy = MethodProxy.create(class_2, class_, (String)"()Ljava/lang/Object;", (String)"clone", (String)"CGLIB$clone$4");
			class_2 = Class.forName("com.huimin.designpattern.proxy.CjlbISinger");
			CGLIB$sing$0$Method = ReflectUtils.findMethods((String[])new String[]{"sing", "()V"}, (Method[])class_2.getDeclaredMethods())[0];
			CGLIB$sing$0$Proxy = MethodProxy.create(class_2, class_, (String)"()V", (String)"sing", (String)"CGLIB$sing$0");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
    }

    final void CGLIB$sing$0() {
        super.sing();
    }

    public final void sing() {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BIND_CALLBACKS((Object)this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            try {
				Object object = methodInterceptor.intercept((Object)this, CGLIB$sing$0$Method, CGLIB$emptyArgs, CGLIB$sing$0$Proxy);
			} catch (Throwable e) {
				e.printStackTrace();
			}
            return;
        }
        super.sing();
    }

    final boolean CGLIB$equals$1(Object object) {
        return super.equals(object);
    }

    public final boolean equals(Object object) {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BIND_CALLBACKS((Object)this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            Object object2;
			try {
				object2 = methodInterceptor.intercept((Object)this, CGLIB$equals$1$Method, new Object[]{object}, CGLIB$equals$1$Proxy);
				return object2 == null ? false : (Boolean)object2;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return super.equals(object);
    }

    final String CGLIB$toString$2() {
        return super.toString();
    }

    public final String toString() {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BIND_CALLBACKS((Object)this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            try {
				return (String)methodInterceptor.intercept((Object)this, CGLIB$toString$2$Method, CGLIB$emptyArgs, CGLIB$toString$2$Proxy);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return super.toString();
    }

    final int CGLIB$hashCode$3() {
        return super.hashCode();
    }

    public final int hashCode() {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BIND_CALLBACKS((Object)this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            Object object;
			try {
				object = methodInterceptor.intercept((Object)this, CGLIB$hashCode$3$Method, CGLIB$emptyArgs, CGLIB$hashCode$3$Proxy);
				return object == null ? 0 : ((Number)object).intValue();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return super.hashCode();
    }

    final Object CGLIB$clone$4() throws CloneNotSupportedException {
        return super.clone();
    }

    protected final Object clone() throws CloneNotSupportedException {
        MethodInterceptor methodInterceptor = this.CGLIB$CALLBACK_0;
        if (methodInterceptor == null) {
            CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BIND_CALLBACKS((Object)this);
            methodInterceptor = this.CGLIB$CALLBACK_0;
        }
        if (methodInterceptor != null) {
            try {
				return methodInterceptor.intercept((Object)this, CGLIB$clone$4$Method, CGLIB$emptyArgs, CGLIB$clone$4$Proxy);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return super.clone();
    }

    public static MethodProxy CGLIB$findMethodProxy(Signature signature) {
        String string = signature.toString();
        switch (string.hashCode()) {
            case -508378822: {
                if (!string.equals("clone()Ljava/lang/Object;")) break;
                return CGLIB$clone$4$Proxy;
            }
            case 1826985398: {
                if (!string.equals("equals(Ljava/lang/Object;)Z")) break;
                return CGLIB$equals$1$Proxy;
            }
            case 1913648695: {
                if (!string.equals("toString()Ljava/lang/String;")) break;
                return CGLIB$toString$2$Proxy;
            }
            case 1984935277: {
                if (!string.equals("hashCode()I")) break;
                return CGLIB$hashCode$3$Proxy;
            }
            case 2094464646: {
                if (!string.equals("sing()V")) break;
                return CGLIB$sing$0$Proxy;
            }
        }
        return null;
    }

    public CjlbISinger$$EnhancerByCGLIB$$a8321336(Integer n) {
    	super(n);
        CjlbISinger$$EnhancerByCGLIB$$a8321336 cjlbISinger$$EnhancerByCGLIB$$a8321336 = this;
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BIND_CALLBACKS((Object)cjlbISinger$$EnhancerByCGLIB$$a8321336);
    }

    public CjlbISinger$$EnhancerByCGLIB$$a8321336() {
        CjlbISinger$$EnhancerByCGLIB$$a8321336 cjlbISinger$$EnhancerByCGLIB$$a8321336 = this;
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BIND_CALLBACKS((Object)cjlbISinger$$EnhancerByCGLIB$$a8321336);
    }

    public static void CGLIB$SET_THREAD_CALLBACKS(Callback[] arrcallback) {
        CGLIB$THREAD_CALLBACKS.set(arrcallback);
    }

    public static void CGLIB$SET_STATIC_CALLBACKS(Callback[] arrcallback) {
        CGLIB$STATIC_CALLBACKS = arrcallback;
    }

    private static final void CGLIB$BIND_CALLBACKS(Object object) {
        CjlbISinger$$EnhancerByCGLIB$$a8321336 cjlbISinger$$EnhancerByCGLIB$$a8321336 = (CjlbISinger$$EnhancerByCGLIB$$a8321336)((Object)object);
        if (!cjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BOUND) {
            cjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BOUND = true;
            Object object2 = CGLIB$THREAD_CALLBACKS.get();
            if (object2 != null || (object2 = CGLIB$STATIC_CALLBACKS) != null) {
                cjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$CALLBACK_0 = (MethodInterceptor)((Callback[])object2)[0];
            }
        }
    }

    public Object newInstance(Callback[] arrcallback) {
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$SET_THREAD_CALLBACKS(arrcallback);
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$SET_THREAD_CALLBACKS(null);
        return new CjlbISinger$$EnhancerByCGLIB$$a8321336();
    }

    public Object newInstance(Callback callback) {
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$SET_THREAD_CALLBACKS(new Callback[]{callback});
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$SET_THREAD_CALLBACKS(null);
        return new CjlbISinger$$EnhancerByCGLIB$$a8321336();
    }

    public Object newInstance(Class[] arrclass, Object[] arrobject, Callback[] arrcallback) {
        CjlbISinger$$EnhancerByCGLIB$$a8321336 cjlbISinger$$EnhancerByCGLIB$$a8321336;
        block4 : {
            CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$SET_THREAD_CALLBACKS(arrcallback);
            Class[] arrclass2 = arrclass;
            Class[] arrclass3 = arrclass2;
            switch (arrclass2.length) {
                case 0: {
                    cjlbISinger$$EnhancerByCGLIB$$a8321336 = new CjlbISinger$$EnhancerByCGLIB$$a8321336();
                    break block4;
                }
                case 1: {
                    arrclass3 = arrclass3;
                    if (!arrclass3[0].getName().equals("java.lang.Integer")) break;
                    cjlbISinger$$EnhancerByCGLIB$$a8321336 = new CjlbISinger$$EnhancerByCGLIB$$a8321336((Integer)arrobject[0]);
                    break block4;
                }
                default: {
                    break;
                }
            }
            throw new IllegalArgumentException("Constructor not found");
        }
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$SET_THREAD_CALLBACKS(null);
        return cjlbISinger$$EnhancerByCGLIB$$a8321336;
    }

    public Callback getCallback(int n) {
        MethodInterceptor methodInterceptor;
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BIND_CALLBACKS((Object)this);
        switch (n) {
            case 0: {
                methodInterceptor = this.CGLIB$CALLBACK_0;
                break;
            }
            default: {
                methodInterceptor = null;
            }
        }
        return methodInterceptor;
    }

    public void setCallback(int n, Callback callback) {
        switch (n) {
            case 0: {
                this.CGLIB$CALLBACK_0 = (MethodInterceptor)callback;
                break;
            }
        }
    }

    public Callback[] getCallbacks() {
        CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$BIND_CALLBACKS((Object)this);
        CjlbISinger$$EnhancerByCGLIB$$a8321336 cjlbISinger$$EnhancerByCGLIB$$a8321336 = this;
        return new Callback[]{this.CGLIB$CALLBACK_0};
    }

    public void setCallbacks(Callback[] arrcallback) {
        Callback[] arrcallback2 = arrcallback;
        Callback[] arrcallback3 = arrcallback2;
        CjlbISinger$$EnhancerByCGLIB$$a8321336 cjlbISinger$$EnhancerByCGLIB$$a8321336 = this;
        this.CGLIB$CALLBACK_0 = (MethodInterceptor)arrcallback2[0];
    }

}
