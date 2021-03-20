package com.cloud.sentinel.common;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class BlockHandlerClass {
    //TODO* 必须为static才ok,参数返回值一样
    public static String blockHandler(String arg1,
                               String arg2,
                               String arg3,
                               BlockException exception){
        return "blockHandler..."+ arg1 + arg2 + arg3 +exception;
    }
//    public static String blockHandler(BlockException exception){
//        return "blockHandler..."+ exception;
//    }
}
