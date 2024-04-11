package com.example.p3.Exception;

public class TestException extends BaseException {
    public TestException(String code){
        super("Test Error : " + code);
    }

    public static TestException testerr(){
        return new TestException("test error");
    }
}
