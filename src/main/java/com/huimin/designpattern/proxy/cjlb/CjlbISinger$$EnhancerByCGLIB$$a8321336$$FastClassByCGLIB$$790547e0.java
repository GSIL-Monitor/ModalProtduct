package com.huimin.designpattern.proxy.cjlb;

import java.lang.reflect.InvocationTargetException;

import org.springframework.cglib.core.Signature;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.reflect.FastClass;

public class CjlbISinger$$EnhancerByCGLIB$$a8321336$$FastClassByCGLIB$$790547e0
extends FastClass {
    public CjlbISinger$$EnhancerByCGLIB$$a8321336$$FastClassByCGLIB$$790547e0(Class class_) {
        super(class_);
    }

    public int getIndex(Signature signature) {
        String string = signature.toString();
        switch (string.hashCode()) {
            case -1985778473: {
                if (!string.equals("CGLIB$sing$0()V")) break;
                return 16;
            }
            case -1882565338: {
                if (!string.equals("CGLIB$equals$1(Ljava/lang/Object;)Z")) break;
                return 15;
            }
            case -1870561232: {
                if (!string.equals("CGLIB$findMethodProxy(Lorg/springframework/cglib/core/Signature;)Lorg/springframework/cglib/proxy/MethodProxy;")) break;
                return 11;
            }
            case -1745842178: {
                if (!string.equals("setCallbacks([Lorg/springframework/cglib/proxy/Callback;)V")) break;
                return 14;
            }
            case -1641413109: {
                if (!string.equals("newInstance([Lorg/springframework/cglib/proxy/Callback;)Ljava/lang/Object;")) break;
                return 6;
            }
            case -1457535688: {
                if (!string.equals("CGLIB$STATICHOOK1()V")) break;
                return 20;
            }
            case -1411842725: {
                if (!string.equals("CGLIB$hashCode$3()I")) break;
                return 19;
            }
            case -1310345955: {
                if (!string.equals("eat()V")) break;
                return 21;
            }
            case -1034266769: {
                if (!string.equals("CGLIB$SET_STATIC_CALLBACKS([Lorg/springframework/cglib/proxy/Callback;)V")) break;
                return 10;
            }
            case -1025895669: {
                if (!string.equals("CGLIB$SET_THREAD_CALLBACKS([Lorg/springframework/cglib/proxy/Callback;)V")) break;
                return 9;
            }
            case -988317324: {
                if (!string.equals("newInstance([Ljava/lang/Class;[Ljava/lang/Object;[Lorg/springframework/cglib/proxy/Callback;)Ljava/lang/Object;")) break;
                return 4;
            }
            case -508378822: {
                if (!string.equals("clone()Ljava/lang/Object;")) break;
                return 3;
            }
            case 610042816: {
                if (!string.equals("newInstance(Lorg/springframework/cglib/proxy/Callback;)Ljava/lang/Object;")) break;
                return 5;
            }
            case 1132856532: {
                if (!string.equals("getCallbacks()[Lorg/springframework/cglib/proxy/Callback;")) break;
                return 12;
            }
            case 1246779367: {
                if (!string.equals("setCallback(ILorg/springframework/cglib/proxy/Callback;)V")) break;
                return 7;
            }
            case 1306468936: {
                if (!string.equals("CGLIB$toString$2()Ljava/lang/String;")) break;
                return 18;
            }
            case 1364367423: {
                if (!string.equals("getCallback(I)Lorg/springframework/cglib/proxy/Callback;")) break;
                return 13;
            }
            case 1800494055: {
                if (!string.equals("CGLIB$clone$4()Ljava/lang/Object;")) break;
                return 17;
            }
            case 1826985398: {
                if (!string.equals("equals(Ljava/lang/Object;)Z")) break;
                return 0;
            }
            case 1913648695: {
                if (!string.equals("toString()Ljava/lang/String;")) break;
                return 1;
            }
            case 1984935277: {
                if (!string.equals("hashCode()I")) break;
                return 2;
            }
            case 2094464646: {
                if (!string.equals("sing()V")) break;
                return 8;
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
                        return 1;
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
                        return 0;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case -1053468136: {
                if (!string2.equals("getCallbacks")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 12;
                    }
                }
                break;
            }
            case -124978609: {
                if (!string2.equals("CGLIB$equals$1")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 1: {
                        arrclass2 = arrclass2;
                        if (!arrclass2[0].getName().equals("java.lang.Object")) break block0;
                        return 15;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case -60403779: {
                if (!string2.equals("CGLIB$SET_STATIC_CALLBACKS")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 1: {
                        arrclass2 = arrclass2;
                        if (!arrclass2[0].getName().equals("[Lorg.springframework.cglib.proxy.Callback;")) break block0;
                        return 10;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case -29025555: {
                if (!string2.equals("CGLIB$hashCode$3")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 19;
                    }
                }
                break;
            }
            case 100184: {
                if (!string2.equals("eat")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 21;
                    }
                }
                break;
            }
            case 3530383: {
                if (!string2.equals("sing")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 8;
                    }
                }
                break;
            }
            case 85179481: {
                if (!string2.equals("CGLIB$SET_THREAD_CALLBACKS")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 1: {
                        arrclass2 = arrclass2;
                        if (!arrclass2[0].getName().equals("[Lorg.springframework.cglib.proxy.Callback;")) break block0;
                        return 9;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 94756189: {
                if (!string2.equals("clone")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 3;
                    }
                }
                break;
            }
            case 147696667: {
                if (!string2.equals("hashCode")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 2;
                    }
                }
                break;
            }
            case 161998109: {
                if (!string2.equals("CGLIB$STATICHOOK1")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 20;
                    }
                }
                break;
            }
            case 495524492: {
                if (!string2.equals("setCallbacks")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 1: {
                        arrclass2 = arrclass2;
                        if (!arrclass2[0].getName().equals("[Lorg.springframework.cglib.proxy.Callback;")) break block0;
                        return 14;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 518224350: {
                if (!string2.equals("CGLIB$sing$0")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 16;
                    }
                }
                break;
            }
            case 1154623345: {
                if (!string2.equals("CGLIB$findMethodProxy")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 1: {
                        arrclass2 = arrclass2;
                        if (!arrclass2[0].getName().equals("org.springframework.cglib.core.Signature")) break block0;
                        return 11;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 1543336189: {
                if (!string2.equals("CGLIB$toString$2")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 18;
                    }
                }
                break;
            }
            case 1811874389: {
                if (!string2.equals("newInstance")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 1: {
                        arrclass2 = arrclass2;
                        String string3 = arrclass2[0].getName();
                        switch (string3.hashCode()) {
                            case -1997738671: {
                                if (!string3.equals("[Lorg.springframework.cglib.proxy.Callback;")) break block0;
                                return 6;
                            }
                            case 1364160985: {
                                if (!string3.equals("org.springframework.cglib.proxy.Callback")) break block0;
                                return 5;
                            }
                            default: {
                                break;
                            }
                        }
                        break block0;
                    }
                    case 3: {
                        arrclass2 = arrclass2;
                        if (!arrclass2[0].getName().equals("[Ljava.lang.Class;")) break block0;
                        arrclass2 = arrclass2;
                        if (!arrclass2[1].getName().equals("[Ljava.lang.Object;")) break block0;
                        arrclass2 = arrclass2;
                        if (!arrclass2[2].getName().equals("[Lorg.springframework.cglib.proxy.Callback;")) break block0;
                        return 4;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 1817099975: {
                if (!string2.equals("setCallback")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 2: {
                        arrclass2 = arrclass2;
                        if (!arrclass2[0].getName().equals("int")) break block0;
                        arrclass2 = arrclass2;
                        if (!arrclass2[1].getName().equals("org.springframework.cglib.proxy.Callback")) break block0;
                        return 7;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 1905679803: {
                if (!string2.equals("getCallback")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 1: {
                        arrclass2 = arrclass2;
                        if (!arrclass2[0].getName().equals("int")) break block0;
                        return 13;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 1951977610: {
                if (!string2.equals("CGLIB$clone$4")) break;
                arrclass2 = arrclass2;
                switch (arrclass2.length) {
                    case 0: {
                        return 17;
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
        CjlbISinger$$EnhancerByCGLIB$$a8321336 cjlbISinger$$EnhancerByCGLIB$$a8321336 = (CjlbISinger$$EnhancerByCGLIB$$a8321336)((Object)object);
        try {
            switch (n) {
                case 0: {
                    return new Boolean(cjlbISinger$$EnhancerByCGLIB$$a8321336.equals(arrobject[0]));
                }
                case 1: {
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336.toString();
                }
                case 2: {
                    return new Integer(cjlbISinger$$EnhancerByCGLIB$$a8321336.hashCode());
                }
                case 3: {
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336.clone();
                }
                case 4: {
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336.newInstance((Class[])arrobject[0], (Object[])arrobject[1], (Callback[])arrobject[2]);
                }
                case 5: {
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336.newInstance((Callback)arrobject[0]);
                }
                case 6: {
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336.newInstance((Callback[])arrobject[0]);
                }
                case 7: {
                    cjlbISinger$$EnhancerByCGLIB$$a8321336.setCallback(((Number)arrobject[0]).intValue(), (Callback)arrobject[1]);
                    return null;
                }
                case 8: {
                    cjlbISinger$$EnhancerByCGLIB$$a8321336.sing();
                    return null;
                }
                case 9: {
                    CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$SET_THREAD_CALLBACKS((Callback[])arrobject[0]);
                    return null;
                }
                case 10: {
                    CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$SET_STATIC_CALLBACKS((Callback[])arrobject[0]);
                    return null;
                }
                case 11: {
                    return CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$findMethodProxy((Signature)arrobject[0]);
                }
                case 12: {
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336.getCallbacks();
                }
                case 13: {
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336.getCallback(((Number)arrobject[0]).intValue());
                }
                case 14: {
                    cjlbISinger$$EnhancerByCGLIB$$a8321336.setCallbacks((Callback[])arrobject[0]);
                    return null;
                }
                case 15: {
                    return new Boolean(cjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$equals$1(arrobject[0]));
                }
                case 16: {
                    cjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$sing$0();
                    return null;
                }
                case 17: {
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$clone$4();
                }
                case 18: {
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$toString$2();
                }
                case 19: {
                    return new Integer(cjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$hashCode$3());
                }
                case 20: {
                    CjlbISinger$$EnhancerByCGLIB$$a8321336.CGLIB$STATICHOOK1();
                    return null;
                }
                case 21: {
                    cjlbISinger$$EnhancerByCGLIB$$a8321336.sing();
                    return null;
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
        	CjlbISinger$$EnhancerByCGLIB$$a8321336 cjlbISinger$$EnhancerByCGLIB$$a8321336;
            switch (n) {
                case 0: {
                    cjlbISinger$$EnhancerByCGLIB$$a8321336 = new CjlbISinger$$EnhancerByCGLIB$$a8321336((Integer)arrobject[0]);
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336;
                }
                case 1: {
                    cjlbISinger$$EnhancerByCGLIB$$a8321336 = new CjlbISinger$$EnhancerByCGLIB$$a8321336();
                    return cjlbISinger$$EnhancerByCGLIB$$a8321336;
                }
            }
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
        throw new IllegalArgumentException("Cannot find matching method/constructor");
    }

    public int getMaxIndex() {
        return 21;
    }
}