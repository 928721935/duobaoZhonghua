package com.jida.common.filter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jida.common.cache.BattleCache;
import com.jida.common.constant.CommonConstant;
import com.jida.common.constant.StaticConstant;
import com.jida.common.constant.StaticEnum;
import com.jida.common.properties.CommonConfigProperties;
import com.jida.common.util.*;
import com.jida.common.util.illegalWordUtil.IllegalWordsSearch;
import com.jida.dto.ChatRecordDTO;
import com.jida.entity.ChatRecord;
import com.jida.entity.User;
import com.jida.mapper.ChatRecordMappper;
import com.jida.mapper.UserMappper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@WebListener
@Slf4j
public class ShutdownContextListener extends ContextLoaderListener {
    @Resource
    private ChatRecordMappper chatRecordMappper;
    @Resource
    private UserMappper userMappper;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        WebApplicationContext webApplicationContext= WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        ContextUtils.setApplicationContext(webApplicationContext);

        MapUtil.initMap();
        NpcUtil.initData();
        IllegalWordsSearch.getInstance();
        battleExec();
        initCharRecord();
        System.out.println("ShutdownContextListener init ...");
    }

    private void initCharRecord(){
        Page page = new Page();
        page.setTotal(20);
        ChatRecord chatRecordCon = new ChatRecord();
        chatRecordCon.setType(StaticEnum.CHAT_RECORD_TYPE_PUBLIC);
        IPage<ChatRecord> iPage = chatRecordMappper.selectPage(page, Wrappers.lambdaQuery(chatRecordCon).orderByDesc(ChatRecord::getCreateTime));
        List<ChatRecord> records = iPage.getRecords();
        if(records.size()>0){
            List<Long> senderIDList = records.stream().map(ChatRecord::getSenderID).collect(Collectors.toList());
            List<User> users = userMappper.selectList(Wrappers.lambdaQuery(new User()).in(User::getUserId,senderIDList));
            Map<Long, User> userID_userMap = users.stream().collect(Collectors.toMap(User::getUserId, v -> v, (v1, v2) -> v1));
            LinkedList<ChatRecordDTO> dtos = new LinkedList<>();
            for (ChatRecord chatRecord:records) {
                ChatRecordDTO dto = new ChatRecordDTO();
                dto.setMsg(chatRecord.getMsg());
                User user = userID_userMap.get(chatRecord.getSenderID());
                dto.setSendPeopleName(user.getPeopleName());
                dto.setSendUserId(chatRecord.getSenderID());
                dto.setCreateTime(chatRecord.getCreateTime());
                dtos.add(dto);
            }
            CacheUtil.publicChatRecordCache.chatRecordDTOList = dtos;
        }
    }

    private void battleExec() {
        BattleCache battleCache = ContextUtils.getBeanClass(BattleCache.class);
        Integer timePerRound = CommonConstant.TIME_PER_ROUND;
        Executors.newSingleThreadExecutor().execute(() -> {
            while (true) {
                try {
                    CommonUtil.sleepThread(timePerRound);
                    battleCache.battleUserIdLock.lock();
                    battleCache.battleRound();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    battleCache.battleUserIdLock.unlock();
                }
            }
        });
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
