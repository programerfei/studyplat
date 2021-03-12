package com.study.studyplatform.utils;

import java.util.UUID;

public class UuidCode {

    //生成激活码
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    //生成用户8位id
    public static String[] chars = new String[] { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0", "1", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9" };


    public static String shortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }
}
