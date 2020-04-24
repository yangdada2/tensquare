package com.tensquare.friend.service;

import com.tensquare.friend.client.UserCliient;
import com.tensquare.friend.dao.FriendDao;
import com.tensquare.friend.dao.NoFriendDao;
import com.tensquare.friend.pojo.Friend;
import com.tensquare.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FriendService {


    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    @Autowired
    private UserCliient userClient;

    @Transactional
    public Integer addFriend(String userid,String friendid){
        //判断该用户是否已经添加了这个好友
        if (friendDao.selectCount(userid,friendid) > 0) {
            return 0;
        }

        //向喜欢表中添加数据
        Friend friend = new Friend();
        friend.setFriendid(friendid);
        friend.setUserid(userid);
        friend.setIslike("0");

        //添加数据
        friendDao.save(friend);
        //增加自己的关注数
        userClient.incFollowcount(userid,1);
        //增加对方的粉丝数
        userClient.incFriendcount(friendid,1);

        //判断对方是否喜欢你,喜欢的话修改数据为1
        if (friendDao.selectCount(friendid,userid) > 0) {
            friendDao.updateLike(userid,friendid,"1");
            friendDao.updateLike(friendid,userid,"1");
        }
        return 1;
    }

    /**
     * 向不喜欢列表中添加记录
     * @param userid
     * @param friendid
     */
    public void addNoFriend(String userid,String friendid){
        NoFriend noFriend=new NoFriend();
        noFriend.setUserid(userid);
        noFriend.setFriendid(friendid);
        noFriendDao.save(noFriend);
    }

    /**
     * 删除好友
     * @param userid
     * @param friendid
     */
    @Transactional
    public void deleteFriend(String userid,String friendid){
        //删除喜欢
        friendDao.deleteFriend(userid,friendid);
        //变更相互喜欢状态
        friendDao.updateLike(friendid,userid,"0");
        //向不喜欢表中添加记录
        addNoFriend(userid,friendid);
        //减少自己的关注数
        userClient.incFollowcount(userid,-1);
        //减少对方的粉丝数
        userClient.incFriendcount(friendid,-1);
    }
}
