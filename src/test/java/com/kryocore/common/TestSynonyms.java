package com.kryocore.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSynonyms {
    public static String getJsonResult(int status, String msg, Object data){

        // ['1','2','3']
        Map<String, Object> resultMap=new HashMap<String, Object>();

        resultMap.put("纸上谈兵终觉浅恶搞恐惧", status);
        resultMap.put("一款搭载华为车联网技术的标致雪铁龙集团新车型在华为公司展台展出", msg);
        resultMap.put("前几天发现，这个方法在linux系统下没用，希望大家注意一下", data);
        return JSONObject.toJSONString(resultMap,SerializerFeature.WriteMapNullValue);
//        return JSONObject.toJSONString(resultMap);
    }

    public static void main(String[] args) {
        System.out.println(getJsonResult(1, "success", "woshishiui"));


        String str = "['1','2','3']";
        List t = JSONObject.parseArray(str);
        System.out.println(t.size());

        for(int i = 0;i<t.size();i++){
            System.out.println(t.get(i));
        }
    }


}
