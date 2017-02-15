package org.myteacher.util;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;


/**
 * Created by wgt on 17-2-3.
 */
public class RefMethodTool {

    private static Logger Log = Logger.getLogger(RefMethodTool.class);
    private static String result ;
    private static Class c ;
    private static Method method;
    public static String methodIvoke(String data,String classinfo, String methodname) {


        try{
            c = Class.forName(classinfo);
            Log.debug("Class c is "+c);

            Object object = c.newInstance();
            Log.debug("Object is "+object);

            method = c.getDeclaredMethod(methodname,String.class);
            Log.debug("method "+method);

            result= (String) method.invoke(object, data);
            Log.debug("result "+result);

        }catch (Exception e){

            Log.error("system error "+e);

        }

       return result;
    }
}
