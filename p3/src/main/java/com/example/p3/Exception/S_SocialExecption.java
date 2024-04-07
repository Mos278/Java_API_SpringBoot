package com.example.p3.Exception;

import com.example.p3.Entity.Social;

public class S_SocialExecption extends BaseException {
    public S_SocialExecption(String code){
        super("Service Social Execption: " + code);
    }

    public static S_SocialExecption SocialNotFund(){
        return new S_SocialExecption("Social not found");
    }


    public static S_SocialExecption UserNotFound(){
        return new S_SocialExecption("User not found");
    }

    public static S_SocialExecption SocialNull(){
        return new S_SocialExecption("Social is null");
    }
}
