package ru.job4j.clone;

public class TestObjects implements Cloneable {
    int num;
    InnerObject innerObj;

    public static void main(String[] args) throws CloneNotSupportedException {
        TestObjects testObj1 = new TestObjects();
        testObj1.num = 5;
        InnerObject innerObj = new InnerObject();
        innerObj.num = 15;
        testObj1.innerObj = innerObj;
        TestObjects testObj2 = testObj1.clone();
        testObj2.num = 25;
        testObj2.innerObj.num = 35;
        System.out.println("Исходный класс: " + testObj1.num);
        System.out.println("Исходный класс: " + testObj1.innerObj.num);
        System.out.println("Скопированный класс: " + testObj2.num);
        System.out.println("Скопированный класс: " + testObj2.innerObj.num);
    }

    @Override
    public TestObjects clone() {
        try {
            TestObjects clone = (TestObjects) super.clone();
            clone.innerObj = innerObj.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

