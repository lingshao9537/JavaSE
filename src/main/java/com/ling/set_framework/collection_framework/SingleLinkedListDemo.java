package com.ling.set_framework.collection_framework;

import java.util.LinkedList;

/**
 * @Author wanglz
 * @create 2022/3/4 14:04
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {

        SingleLinkedList linkedList = new SingleLinkedList();

        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode node5 = new HeroNode(5, "时迁", "鼓上蚤");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node6 = new HeroNode(5, "时迁", "鼓上蚤");

        linkedList.addAsc(node4);
        linkedList.addAsc(node1);
        linkedList.addAsc(node5);
        linkedList.addAsc(node2);
        linkedList.addAsc(node3);
        linkedList.addAsc(node6);

        linkedList.remove(node2);
        linkedList.removeById(8);

        linkedList.addByIndex(1, node4);

        linkedList.removeByIndex(2);


        linkedList.list();

    }
}

class SingleLinkedList {
    // 设置头结点
    private HeroNode headNode = new HeroNode(0, "", "");

    /**
     * 按照添加顺序添加
     * 目的是找到要插入的temp
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = headNode.getNext();
        // 如果头结点的next为空，那么就插入next中
        // 如果头结点的next不为空，那么就指向下一个节点，直到next为空就插入
        while (true) {
            if (null == temp.getNext()) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
    }

    /**
     * 按照id升序添加
     * @param heroNode
     */
    public void addAsc(HeroNode heroNode) {
        HeroNode temp = headNode;
        boolean flag = false;
        // 如果头结点的next为空，那么就插入next中
        while (true) {
            // 如果头结点的next为空，插入
            if (null == temp.getNext()) {
                break;
            }
            // 如果插入节点id小于当前节点next的id，插入
            if (heroNode.getId() < temp.getNext().getId()) {
                break;
            // 如果插入节点等于当前节点next的id，退出且不插入
            } else if (heroNode.getId().equals(temp.getNext().getId())){
                flag = true;
                break;
            }

            temp = temp.getNext();
        }

        if (flag) {
            System.out.printf("链表中已存在当前节点的id %d \n" , heroNode.getId());
        } else {
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    /**
     * 在指定索引位置插入元素
     * @param index
     * @param heroNode
     */
    public void addByIndex(int index, HeroNode heroNode) {
        HeroNode temp = headNode;
        int i = 0;
        while (true) {
            if (i == index) {
                if (null != temp.getNext())  {
                    heroNode.setNext(temp.getNext());
                }
                temp.setNext(heroNode);
                break;
            }
            if (null == temp) {
                break;
            }
            temp = temp.getNext();
            i++;
        }
    }

    /**
     * 删除节点
     * @param heroNode
     */
    public void remove(HeroNode heroNode) {
        HeroNode temp = headNode;
        while (true) {
            // 头结点的next为空，跳出
            if (null == temp.getNext()) {
                break;
            }
            // 如果当前节点的next == 当前插入节点
            if (heroNode == temp.getNext()) {
                // 判断当前节点的next的next是否存在
                if (null != temp.getNext().getNext()) {
                    // 如果存在，就把当前节点的next换成当前节点的next的next
                    temp.setNext(temp.getNext().getNext());
                    // 然后继续往后挪动
                } else {
                    // 如果不存在，那就直接设置next为空
                    temp.setNext(null);
                    break;
                }
            }
            temp = temp.getNext();
        }
    }

    /**
     * 根据id删除元素
     * @param id
     */
    public void removeById(Integer id) {
        HeroNode temp = headNode;
        while (true) {
            // 头结点的next为空，跳出
            if (null == temp.getNext()) {
                break;
            }
            // 如果当前节点的next == 当前插入节点
            if (id.equals(temp.getNext().getId())) {
                // 判断当前节点的next的next是否存在
                if (null != temp.getNext().getNext()) {
                    // 如果存在，就把当前节点的next换成当前节点的next的next
                    temp.setNext(temp.getNext().getNext());
                    // 然后继续往后挪动
                } else {
                    // 如果不存在，那就直接设置next为空
                    temp.setNext(null);
                    break;
                }
            }
            temp = temp.getNext();
        }
    }

    /**
     * 删除指定位置的元素
     * @param index
     */
    public void removeByIndex(int index) {
        HeroNode temp = headNode;
        int i = 0;
        while (true) {
            if (i == index) {
                if (null != temp.getNext()) {
                    if (null != temp.getNext().getNext()) {
                        temp.setNext(temp.getNext().getNext());
                    } else {
                        temp.setNext(null);
                    }
                }
                break;
            }
            if (null == temp) {
                break;
            }
            temp = temp.getNext();
            i++;
        }
    }

    /**
     * 遍历
     */
    public void list() {
        // 如果头结点的next为空，那么这个单向链表就是空的
        HeroNode temp = headNode.getNext();
        // 如果头结点的next不为空，就输出next，然后指向下一个节点
        while (true) {
            if (null == temp) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class HeroNode {
    private Integer id;
    private String name;
    private String nickName;
    private HeroNode next;

    public HeroNode(Integer id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
