package com.yaoyuan.jiscuss.common;
import com.yaoyuan.jiscuss.entity.Posts;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author yaoyuan2.chu
 * @Title:
 * @Package com.yaoyuan.jiscuss.common
 * @Description:
 * @date 2020/8/17 14:51
 */
@Data
public class Node {

    public Node() {

    }

    private Integer id;

    private Integer discussionId;

    private Integer number;

    private Date time;

    private Integer userId;

    private String type;

    private String content;

    private Integer parentId;

    private Date editTime;

    private Integer editUserId;

    private String ipAddress;

    private String copyright;

    private Integer isApproved;

    private Integer createId;

    private Date createTime;
    //下一条回复
    private List<Node> nextNodes = new ArrayList<Node>();


    /**
     * 将单个node添加到链表中
     *
     * @param list
     * @param node
     * @return
     */
    public static boolean addNode(List<Node> list, Node node) {
        for (Node node1 : list) {   //循环添加
            if (node1.getId() .equals(node.getParentId()) ) {   //判断留言的上一段是都是这条留言
                node1.getNextNodes().add(node);   //是，添加，返回true;
                System.out.println("添加了一个");
                return true;
            } else {     //否则递归继续判断
                if (node1.getNextNodes().size() != 0) {
                    if (Node.addNode(node1.getNextNodes(), node)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 将查出来的lastId不为null的回复都添加到第一层Node集合中
     *
     * @param firstList
     * @param thenList
     * @return
     */
    public static List addAllNode(List<Node> firstList, List<Posts> thenList) {
        while (thenList.size() != 0) {
            int size = thenList.size();
            for (int i = 0; i < size; i++) {
                Node node = new Node();
                BeanUtils.copyProperties(thenList.get(i), node);
                if (Node.addNode(firstList, node)) {
                    thenList.remove(i);
                    i--;
                    size--;
                }
            }
        }
        return firstList;
    }

    //打印
    public static void show(List<Node> list) {
        for (Node node : list) {
            System.out.println(node.getUserId() + " 用户回复了你：" + node.getContent());
            if (node.getNextNodes().size() != 0) {
                Node.show(node.getNextNodes());
            }
        }
    }


}