package com.huimin.designpattern.proxy.cjlb;

import java.lang.reflect.InvocationTargetException;

import org.springframework.cglib.core.Signature;
import org.springframework.cglib.reflect.FastClass;

import com.huimin.designpattern.proxy.CjlbISinger;

public class CjlbISinger$$FastClassByCGLIB$$c3850ae1 extends FastClass{
	public CjlbISinger$$FastClassByCGLIB$$c3850ae1(Class class_) {
        super(class_);
    }

    public int getIndex(Signature signature) {
        String string = signature.toString();
        switch (string.hashCode()) {
            case -1310345955: {
                if (!string.equals("eat()V")) break;
                return 1;
            }
            case 1826985398: {
                if (!string.equals("equals(Ljava/lang/Object;)Z")) break;
                return 2;
            }
            case 1913648695: {
                if (!string.equals("toString()Ljava/lang/String;")) break;
                return 3;
            }
            case 1984935277: {
                if (!string.equals("hashCode()I")) break;
                return 4;
            }
            case 2094464646: {
                if (!string.equals("sing()V")) break;
                return 0;
            }
        }
        return -1;
    }

    public int getIndex(String string, Class[] arrclass) {
        String string2 = string;
        Class[] arrclass2 = arrclass;
        block0 : switch (string2.hashCode()) {
            case -1776922004: {
                if (!string2.equals("toString")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 3;
                    }
                }
                break;
            }
            case -1295482945: {
                if (!string2.equals("equals")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 1: {
                        arrclass2 = arrclass2;
                        if (!arrclass2[0].getName().equals("java.lang.Object")) break block0;
                        return 2;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 100184: {
                if (!string2.equals("eat")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 1;
                    }
                }
                break;
            }
            case 3530383: {
                if (!string2.equals("sing")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 0;
                    }
                }
                break;
            }
            case 147696667: {
                if (!string2.equals("hashCode")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 4;
                    }
                }
                break;
            }
            default: {
                break;
            }
        }
        return -1;
    }

    public int getIndex(Class[] arrclass) {
        Class[] arrclass2 = arrclass;
        Class[] arrclass3 = arrclass2;
        switch (arrclass2.length) {
            case 0: {
                return 1;
            }
            case 1: {
                arrclass3 = arrclass3;
                if (!arrclass3[0].getName().equals("java.lang.Integer")) break;
                return 0;
            }
            default: {
                break;
            }
        }
        return -1;
    }

    public Object invoke(int n, Object object, Object[] arrobject) throws InvocationTargetException {
        CjlbISinger cjlbISinger = (CjlbISinger)object;
        try {
            switch (n) {
                case 0: {
                    cjlbISinger.sing();
                    return null;
                }
                case 1: {
                    cjlbISinger.eat();
                    return null;
                }
                case 2: {
                    return new Boolean(cjlbISinger.equals(arrobject[0]));
                }
                case 3: {
                    return cjlbISinger.toString();
                }
                case 4: {
                    return new Integer(cjlbISinger.hashCode());
                }
            }
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    public Object newInstance(int n, Object[] arrobject) throws InvocationTargetException {
        try {
        	CjlbISinger cjlbISinger;
            switch (n) {
            case 0: {
                cjlbISinger = new CjlbISinger((Integer)arrobject[0]);
                return cjlbISinger;
            }
            case 1: {
                cjlbISinger = new CjlbISinger();
                return cjlbISinger;
            }
            }
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    public int getMaxIndex() {
        return 4;
    }
}
