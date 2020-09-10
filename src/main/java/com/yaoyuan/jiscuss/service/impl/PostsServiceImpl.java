package com.yaoyuan.jiscuss.service.impl;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.util.*;

import com.yaoyuan.jiscuss.common.Node;
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
    public List findPostCustomById(Integer id) {
        //查询id为1且parentId为null的评论
        List<Map<String, Object>> firstposts = postsRepository.findAllByDIdAndparentIdNull(id);

        List<PostCustom> firstpostCustomList = PostCommonUtil.getNewPostsObjMap(firstposts);

//        List<PostCustom> firstpostCustomListNew = PostCommonUtil.getNewPostsObjCustom(firstpostCustomList);

        //查询id为1且parentId不为null的评论
        List<Map<String, Object>> thenposts = postsRepository.findAllByDIdAndparentIdNotNull(id);

        List<PostCustom> thenpostCustomList = PostCommonUtil.getNewPostsObjMap(thenposts);

//        List<PostCustom> thenpostCustomListNew = PostCommonUtil.getNewPostsObjCustom(thenpostCustomList);



        //新建一个Node集合。
        ArrayList<Node> nodes = new ArrayList<>();
        //将第一层评论都添加都Node集合中
        for (PostCustom post : firstpostCustomList) {
            Node node = new Node();
            BeanUtils.copyProperties(post, node);
            nodes.add(node);
        }
        //将回复添加到对应的位置
        List list = Node.addAllNode(nodes, thenpostCustomList);
        System.out.println();
        //打印回复链表
        Node.show(list);




//        List<Map<String, Object>> posts = postsRepository.findPostCustomById(id);
//
//        List<PostCustom> postCustomList = PostCommonUtil.getNewPostsObjMap(posts);
//
//        List<PostCustom> postCustomListNew = PostCommonUtil.getNewPostsObjCustom(postCustomList);

        return list;
    }


    @Override
    public Post insert(Post post) {
        return postsRepository.save(post);
    }
}
