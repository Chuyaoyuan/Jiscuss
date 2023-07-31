package com.yaoyuan.jiscuss.common;

import com.yaoyuan.jiscuss.entity.custom.PostCustom;
import org.springframework.beans.BeanUtils;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yaoyuan2.chu
 * @Title: 工具类
 * @Package com.yaoyuan.jiscuss.common
 * @Description: 通用工具类
 * @date 2020/9/10 15:47
 */
public class PostCommonUtil {

    public static List<PostCustom> getNewPostsObjMap(List<Map<String, Object>> posts) {
        List<PostCustom> postCustomList = new ArrayList<>();
        for (Map<String, Object> mapObj : posts) {
            PostCustom postCustom = new PostCustom();
            postCustom.setId(Integer.parseInt(String.valueOf(mapObj.get("id"))));
            postCustom.setParentId(mapObj.get("parent_id") != null ? Integer.parseInt(String.valueOf(mapObj.get("parent_id"))) : null);
            if (null != mapObj.get("create_time")) {
                postCustom.setCreateTime((Date) mapObj.get("create_time"));
            }
            String content = "";
            if (mapObj.get("content") != null) {
                if (mapObj.get("content") instanceof Clob) {
                    Clob clob = (Clob) mapObj.get("content");
                    content = PostCommonUtil.clobToString(clob);
                } else if (mapObj.get("content") instanceof String) {
                    content = String.valueOf(mapObj.get("content"));
                }
            }
            postCustom.setContent(content);
            String avatar = "";
            if (mapObj.get("create_avatar") != null) {
                if (mapObj.get("create_avatar") instanceof Clob) {
                    Clob clob = (Clob) mapObj.get("create_avatar");
                    avatar = PostCommonUtil.clobToString(clob);
                } else if (mapObj.get("create_avatar") instanceof String) {
                    avatar = String.valueOf(mapObj.get("create_avatar"));
                }
            }
            postCustom.setAvatar(avatar);
            postCustom.setUsername(mapObj.get("create_username") != null ? String.valueOf(mapObj.get("create_username")) : null);
            postCustom.setRealname(mapObj.get("create_realname") != null ? String.valueOf(mapObj.get("create_realname")) : null);
            String avatarReply = "";
            if (mapObj.get("user_avatar") != null) {
                if (mapObj.get("user_avatar") instanceof Clob) {
                    Clob clob = (Clob) mapObj.get("user_avatar");
                    avatarReply = PostCommonUtil.clobToString(clob);
                } else if (mapObj.get("user_avatar") instanceof String) {
                    avatarReply = String.valueOf(mapObj.get("user_avatar"));
                }
            }
            postCustom.setAvatarReply(avatarReply);
            postCustom.setUsernameReply(mapObj.get("user_username") != null ? String.valueOf(mapObj.get("user_username")) : null);
            postCustom.setRealnameReply(mapObj.get("user_realname") != null ? String.valueOf(mapObj.get("user_realname")) : null);

            postCustomList.add(postCustom);
        }
        return postCustomList;
    }

    /**
     * 获取post
     * @param postCustomList
     * @return List<PostCustom>
     */
    public static List<PostCustom> getNewPostsObjCustom(List<PostCustom> postCustomList) {
        List<PostCustom> mainList = new ArrayList<>();
        Map<String, Object> postMap = new LinkedHashMap<>();
        for (PostCustom mapObj : postCustomList) {
            if (null == mapObj.getParentId()) {
                mainList.add(mapObj);
            } else {
                List<PostCustom> tempList = new ArrayList<>();
                if (postMap.containsKey(String.valueOf(mapObj.getParentId()))) {
                    tempList = (List<PostCustom>) postMap.get(String.valueOf(mapObj.getParentId()));
                    tempList.add(mapObj);
                    postMap.put(String.valueOf(mapObj.getParentId()), tempList);
                } else {
                    tempList.add(mapObj);
                    postMap.put(String.valueOf(mapObj.getParentId()), tempList);
                }
            }
        }
        List<PostCustom> mainListResult = new ArrayList<>();
        for (PostCustom mapObj : mainList) {
            if (postMap.containsKey(String.valueOf(mapObj.getId()))) {
                PostCustom newObj = new PostCustom();
                BeanUtils.copyProperties(mapObj, newObj);
                newObj.setChild((List<PostCustom>) postMap.get(String.valueOf(mapObj.getId())));
                mainListResult.add(newObj);
            } else {
                mainListResult.add(mapObj);
            }
        }
        return mainListResult;
    }

    /**
     * Clob类型转换成String类型
     * @param clob
     * @return
     */
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
