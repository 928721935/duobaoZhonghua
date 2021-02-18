package com.jida.common.util;

import com.jida.common.constant.StaticConstant;

public class CheckParamUtl {
    public static boolean checkNoName(String name){
        if (!StaticConstant.NO_NAME.equals(name)) {
            return false;
        }
        return true;
    }
}
