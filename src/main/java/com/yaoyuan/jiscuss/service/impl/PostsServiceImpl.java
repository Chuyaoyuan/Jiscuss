package com.yaoyuan.jiscuss.service.impl;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.util.*;

import com.yaoyuan.jiscuss.common.PostCommonUtil;
import com.yaoyuan.jiscuss.entity.Discussion;
import com.yaoyuan.jiscuss.entity.custom.DiscussionCustom;
import com.yaoyuan.jiscuss.entity.custom.PostCustom;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yaoyuan.jiscuss.entity.Post;
import com.yaoyuan.jiscuss.repository.PostsRepository;
import com.yaoyuan.jiscuss.service.IPostsService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class PostsServiceImpl implements IPostsService {
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public List<Post> getAllList() {
        return postsRepository.findAll();
    }

    @Override
    public List<Post> findOneBy(Integer id) {

        List<Post> posts = postsRepository.findOneBy(id);
        return posts;
    }

    @Override
    public Post findOneByid(Integer id) {
        Post post =new Post();
        post.setId(id);
        Example<Post> example = Example.of(post);
        Optional<Post> postRes = postsRepository.findOne(example);
        return postRes.get();
    }

    @Override
    public List<PostCustom> findPostCustomById(Integer id) {

        List<Map<String, Object>> posts = postsRepository.findPostCustomById(id);
//        List<Map<String, Object>> postsObjNew = this.getNewPostsObj(posts);

        List<PostCustom> postCustomList = new ArrayList<>();
        for(Map<String, Object> mapObj : posts){
            PostCustom postCustom = new PostCustom();
            postCustom.setId(Integer.parseInt(String.valueOf(mapObj.get("id"))));
            postCustom.setParentId(mapObj.get("parent_id") != null ? Integer.parseInt(String.valueOf(mapObj.get("parent_id"))) : null);
            if(null !=  mapObj.get("create_time")){
                postCustom.setCreateTime((Date) mapObj.get("create_time"));
            }
            String content = "";
            if(mapObj.get("content") != null){
                Clob clob = (Clob) mapObj.get("content");
                content = PostCommonUtil.clobToString(clob);
            }
            postCustom.setContent(content);
            String avatar = "";
            if(mapObj.get("create_avatar") != null){
                Clob clob = (Clob) mapObj.get("create_avatar");
                avatar = PostCommonUtil.clobToString(clob);
            }
            postCustom.setAvatar(avatar);
            postCustom.setUsername(mapObj.get("create_username") != null ? String.valueOf(mapObj.get("create_username")): null);
            postCustom.setRealname(mapObj.get("create_realname") != null ? String.valueOf(mapObj.get("create_realname")): null);
            String avatarReply = "";
            if(mapObj.get("user_avatar") != null){
                Clob clob = (Clob) mapObj.get("user_avatar");
                avatarReply = PostCommonUtil.clobToString(clob);
            }
            postCustom.setAvatarReply(avatarReply);
            postCustom.setUsernameReply(mapObj.get("user_username") != null ? String.valueOf(mapObj.get("user_username")): null);
            postCustom.setRealnameReply(mapObj.get("user_realname") != null ? String.valueOf(mapObj.get("user_realname")): null);

            postCustomList.add(postCustom);
        }

        List<PostCustom> postCustomListNew = PostCommonUtil.getNewPostsObjCustom(postCustomList);

        return postCustomListNew;
    }

   @Override
    public List<Post> findAllByDIdAndparentIdNull(Integer dId) {
        List<Post> posts = postsRepository.findAllByDIdAndparentIdNull(dId);
        return posts;
    }

    @Override
    public List<Post> findAllByDIdAndparentIdNotNull(Integer dId) {
        List<Post> posts = postsRepository.findAllByDIdAndparentIdNotNull(dId);
        return posts;
    }


    @Override
    public Post insert(Post post) {
        return postsRepository.save(post);
    }
}
