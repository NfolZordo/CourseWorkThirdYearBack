package com.course.work.user;

import org.springframework.core.convert.converter.Converter;

public class AllUserInfoConverter {

    public static AllUserInfo convert(Object[] source) {
        AllUserInfo allUserInfo = new AllUserInfo();
        allUserInfo.setId((Integer) source[0]);
        allUserInfo.setEmail((String) source[1]);
        allUserInfo.setRole((String) source[2]);
        allUserInfo.setFirstName((String) source[3]);
        allUserInfo.setLastName((String) source[4]);
        allUserInfo.setPhoneNumber((Integer) source[5]);
        return allUserInfo;
    }
}