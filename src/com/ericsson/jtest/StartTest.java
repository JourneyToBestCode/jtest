package com.ericsson.jtest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class StartTest {

    public void getTest(String className) throws InstantiationException {
        Class<?> testClass = getclass(className);

        Method[] testMethods = null;
        try {

            testMethods = testClass.getMethods();
        } catch (Exception e) {

            System.out.println("Error: " + e.toString());
        }


        try {
            Object test = testClass.newInstance();
            System.out.println("Method.... ");
            for (Method testMethod : testMethods) {
                if (isTestMethod(testMethod)) {
                    System.out.println(testMethod);
                    testMethod.invoke(test, (Object[]) new Class[0]);
                }
            }
        } catch (InvocationTargetException e) {
            System.out.println("Failed to invoke method:" + e.getTargetException().toString());

        } catch (IllegalAccessException e) {
            System.out.println("Failed to invoke method:" + e.toString());

        }


    }

    private Class<?> getclass(String className) {
        if (className.length() <= 0) {
            // /
        }
        Class<?> testClass = null;
        try {
            testClass = loadSuiteClass(className);
            System.out.println("Test \"" + testClass + "\"");
        } catch (ClassNotFoundException e) {
            String clazz = e.getMessage();
            if (clazz == null) {
                clazz = className;
            }
            System.out.println("Class not found \"" + clazz + "\"");

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());

        }
        return testClass;
    }

    private boolean isTestMethod(Method m) {
        return m.getParameterTypes().length == 0 && m.getName().startsWith("test") && m.getReturnType().equals(Void.TYPE);
    }
    protected Class<?> loadSuiteClass(String suiteClassName) throws ClassNotFoundException {
        return Class.forName(suiteClassName);
    }

}
