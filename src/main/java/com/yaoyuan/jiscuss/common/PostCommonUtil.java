package com.yaoyuan.jiscuss.common;

import com.yaoyuan.jiscuss.entity.custom.PostCustom;
import org.springframework.beans.BeanUtils;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.common
 * @Description:
 * @date 2020/9/10 15:47
 */
public class PostCommonUtil {


    public static List<PostCustom> getNewPostsObjCustom(List<PostCustom> postCustomList) {
        List<PostCustom> mainList = new ArrayList<>();
        Map<String, Object> postMap = new LinkedHashMap<>();
        for(PostCustom mapObj : postCustomList){
            if(null == mapObj.getParentId() ){
                mainList.add(mapObj);
            }else{
                List<PostCustom> tempList = new ArrayList<>();
                if(postMap.containsKey(String.valueOf(mapObj.getParentId()))){
                    tempList = (List<PostCustom>) postMap.get(String.valueOf(mapObj.getParentId()));
                    tempList.add(mapObj);
                    postMap.put(String.valueOf(mapObj.getParentId()),tempList);
                }else{
                    tempList.add(mapObj);
                    postMap.put(String.valueOf(mapObj.getParentId()),tempList);
                }
            }
        }
        List<PostCustom> mainListResult = new ArrayList<>();
        for(PostCustom mapObj : mainList){
            if(postMap.containsKey(String.valueOf(mapObj.getId()))){
                PostCustom newObj = new PostCustom();
                BeanUtils.copyProperties(mapObj , newObj);
                newObj.setChild((List<PostCustom>) postMap.get(String.valueOf(mapObj.getId())));
                mainListResult.add(newObj);
            }else{
                mainListResult.add(mapObj);
            }
        }

        return mainListResult;
    }

    // Clob类型转换成String类型
    public static String clobToString(final Clob clob) {

        if (clob == null) {
            return null;
        }

        Reader is = null;
        try {
            is = clob.getCharacterStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(is);

        String str = null;
        try {
            str = br.readLine();    // 读取第一行
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();
        while (str != null) {    // 如果没有到达流的末尾，则继续读取下一行
            sb.append(str);
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String returnString = sb.toString();

        return returnString;
    }
}
