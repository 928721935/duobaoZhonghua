package com.jida.common.cache;

import com.jida.common.util.CacheUtil;
import com.jida.common.util.CommonUtil;
import com.jida.dto.BattleInfo;
import com.jida.dto.ChatRecordDTO;
import com.jida.common.cache.data.RoleEntity;
import com.jida.entity.User;
import com.jida.service.MoveService;
import lombok.extern.slf4j.Slf4j;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
//@Service
public class BattleCache {
    public volatile List<Long> battleUserIdList = new LinkedList<>();
    public volatile List<Long> leaveUserIdList = new LinkedList<>();
    public volatile ReentrantLock battleUserIdLock = new ReentrantLock();

    public void battleRound(){
        if(battleUserIdList.size()==0){
            return;
        }
        Iterator<Long> iterator = battleUserIdList.iterator();
        while (iterator.hasNext()) {
            Long userId = iterator.next();
            if(leaveUserIdList.contains(userId)){
                continue;
            }
            action(userId);
        }
        iterator = battleUserIdList.iterator();
        while (iterator.hasNext()) {
            Long userId = iterator.next();
            RoleEntity roleEntity1 = CacheUtil.getRoleEntity(userId);
            log.info("{}剩余血量:{}",roleEntity1.getUser().getPeopleName(),roleEntity1.getBattleInfo().getHp());
            if(leaveUserIdList.contains(userId)){
                iterator.remove();
                continue;
            }
            if(roleEntity1.getBattleInfo().getOtherUserIds().size()==0){
                iterator.remove();
                continue;
            }
        }
        leaveUserIdList.clear();
        log.info(Thread.currentThread().getName()+CommonUtil.translateDate2(new Date())+"+++++++++++++++++");
    }

    public void action(Long userId){
        RoleEntity roleEntity = CacheUtil.getRoleEntity(userId);
        BattleInfo battleInfo = roleEntity.getBattleInfo();
        List<Long> otherUserIds = roleEntity.getBattleInfo().getOtherUserIds();
        long otherUserId = otherUserIds.get(random.nextInt(otherUserIds.size()));
        RoleEntity roleEntity2 = CacheUtil.getRoleEntity(otherUserId);
        BattleInfo battleInfo2 = roleEntity2.getBattleInfo();
        Integer damage = random.nextInt(100)+100;
        String msg = "绯村拔刀斋一声暴喝，步伐加快，左手虚划，右手回转，聚气于胸前，猛地双手推出，刹那间，一招变为数招，同时使出，正是降龙十八掌「龍嘯九天」，气势恢弘，势不可挡！结果圣境高手躲闪不及，绯村拔刀斋的掌劲顿时穿胸而过，喀嚓喀嚓断了数根肋骨，圣境高手口中鲜血狂喷。(-265082)圣境高手满身鲜血，已经有如风中残烛，随时都可能断气。<br/>";
        msg = msg.replace("绯村拔刀斋","你");
        msg = msg.replace("圣境高手",roleEntity2.getUser().getPeopleName());
        msg = msg.replace("265082",damage+"");
        ChatRecordDTO chatRecordDTO = new ChatRecordDTO();
        chatRecordDTO.setMsg(msg);
        CacheUtil.battlePrivateTrackCache.put(chatRecordDTO,userId);

        msg = "绯村拔刀斋一声暴喝，步伐加快，左手虚划，右手回转，聚气于胸前，猛地双手推出，刹那间，一招变为数招，同时使出，正是降龙十八掌「龍嘯九天」，气势恢弘，势不可挡！结果圣境高手躲闪不及，绯村拔刀斋的掌劲顿时穿胸而过，喀嚓喀嚓断了数根肋骨，圣境高手口中鲜血狂喷。(-265082)圣境高手满身鲜血，已经有如风中残烛，随时都可能断气。<br/>";
        msg = msg.replace("绯村拔刀斋",roleEntity.getUser().getPeopleName());
        msg = msg.replace("圣境高手","你");
        msg = msg.replace("265082",damage+"");
        chatRecordDTO = new ChatRecordDTO();
        chatRecordDTO.setMsg(msg);
        CacheUtil.battlePrivateTrackCache.put(chatRecordDTO,otherUserId);

        Integer hp = battleInfo2.getHp();

        log.info("{}对{}造成{}点伤害",roleEntity.getUser().getPeopleName(),roleEntity2.getUser().getPeopleName(),damage);
        if(damage<hp){
            battleInfo2.setHp(hp-damage);
        }else {
            battleInfo2.setHp(hp-damage);
            turnOutBattle(otherUserId);
            msg = "紫衣刀客死了。<br/>你杀死了紫衣刀客!获得十一年四十五天修行，一百点潜能！<br/>";
            msg = msg.replace("紫衣刀客",roleEntity2.getUser().getPeopleName());
            chatRecordDTO = new ChatRecordDTO();
            chatRecordDTO.setMsg(msg);
            CacheUtil.battlePrivateTrackCache.put(chatRecordDTO,userId);
            if(roleEntity.getBattleInfo().getOtherUserIds().size()==0){
                roleEntity.setInBattle(false);
                battleInfo.setHp(1000);
            }
            msg = "你死了。<br/>损失三时辰修行，三百五十八潜能<br/>胜败乃兵家常事，你被无名老者救了回来，就在客栈里好好养伤吧<br/>";
            chatRecordDTO = new ChatRecordDTO();
            chatRecordDTO.setMsg(msg);
            roleEntity2.setInBattle(false);
            battleInfo2.setHp(1000);
            CacheUtil.battlePrivateTrackCache.put(chatRecordDTO,otherUserId);
            if(roleEntity.getUserType()==1){
                MoveService moveService = new MoveService();
                moveService.changeScene(1,otherUserId);
            }
            System.out.println(roleEntity2.getUser().getPeopleName()+"死了————————————————————-");
        }
    }

    public void turnInBattle(Long userId1,Long userId2){
        RoleEntity roleEntity1 = CacheUtil.getRoleEntity(userId1);
        RoleEntity roleEntity2 = CacheUtil.getRoleEntity(userId2);
        BattleInfo battleInfo1 = roleEntity1.getBattleInfo();
        BattleInfo battleInfo2 = roleEntity2.getBattleInfo();
        battleInfo1.getOtherUserIds().add(userId2);
        battleInfo2.getOtherUserIds().add(userId1);
        battleUserIdLock.lock();
        String msg = "你对著天锋小子喝道：「老匹夫！今日不是你死就是我活！」<br/>";
        msg = msg.replace("天锋小子",roleEntity2.getUser().getPeopleName());
        ChatRecordDTO chatRecordDTO = new ChatRecordDTO();
        chatRecordDTO.setMsg(msg);
        CacheUtil.battlePrivateTrackCache.put(chatRecordDTO,userId1);

        msg = "太岁对著你喝道：「老匹夫！今日不是你死就是我活！」<br/>看起来太岁想杀死你！<br/>";
        msg = msg.replace("太岁",roleEntity1.getUser().getPeopleName());
        chatRecordDTO = new ChatRecordDTO();
        chatRecordDTO.setMsg(msg);
        CacheUtil.battlePrivateTrackCache.put(chatRecordDTO,userId2);

        if(!battleUserIdList.contains(userId2)){
            battleUserIdList.add(userId2);
        }
        roleEntity1.setInBattle(true);
        roleEntity2.setInBattle(true);
        battleUserIdList.add(userId1);
        battleUserIdLock.unlock();
    }

    public void turnOutBattle(Long userId){
        RoleEntity roleEntity = CacheUtil.getRoleEntity(userId);
        List<Long> otherUserIds = roleEntity.getBattleInfo().getOtherUserIds();
        for (Long otherUserId:otherUserIds) {
            RoleEntity roleEntity1 = CacheUtil.getRoleEntity(otherUserId);
            if(roleEntity1!=null){
                roleEntity1.getBattleInfo().getOtherUserIds().remove(userId);
            }
        }

        battleUserIdLock.lock();
        leaveUserIdList.add(userId);
        battleUserIdLock.unlock();
        otherUserIds.clear();
    }

    SecureRandom random;
    {
        random = new SecureRandom();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setPeopleName("龙吟天下");
        user.setUserId(11L);
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setUser(user);
        CacheUtil.roleEntityCache.userID_roleEntityMap.put(user.getUserId(),roleEntity);

        user = new User();
        user.setPeopleName("赵本山");
        user.setUserId(22L);
        roleEntity = new RoleEntity();
        roleEntity.setUser(user);
        CacheUtil.roleEntityCache.userID_roleEntityMap.put(user.getUserId(),roleEntity);

        BattleCache battleCache = new BattleCache();
        battleCache.turnInBattle(11L,22L);
        while (battleCache.battleUserIdList.size()>0){
            CommonUtil.sleepThread(2000);
            battleCache.battleUserIdLock.lock();
            battleCache.battleRound();
            battleCache.battleUserIdLock.lock();
        }
    }
}
