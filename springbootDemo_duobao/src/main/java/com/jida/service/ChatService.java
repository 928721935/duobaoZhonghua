package com.jida.service;

import com.jida.common.constant.StaticConstant;
import com.jida.common.constant.StaticEnum;
import com.jida.common.util.CacheUtil;
import com.jida.common.util.CommonUtil;
import com.jida.common.util.RequestUtil;
import com.jida.common.util.SnowFlakeUtil;
import com.jida.common.util.illegalWordUtil.IllegalWordsSearch;
import com.jida.dto.ChatRecordDTO;
import com.jida.common.cache.data.RoleEntity;
import com.jida.dto.ChatRecordDTO;
import com.jida.entity.ChatRecord;
import com.jida.entity.User;
import com.jida.mapper.ChatRecordMappper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class ChatService {
    @Resource
    private ChatRecordMappper chatRecordMappper;

    public List<ChatRecordDTO> getWord() {
        List<ChatRecordDTO> za = CacheUtil.publicChatRecordCache.chatRecordDTOList;
        HttpServletRequest request = RequestUtil.getRequest();
        request.setAttribute("lis", za);
        return za;
    }

    public String sayWord(String count) {
        User user = CacheUtil.getCurrRoleEntity().getUser();
        HttpServletRequest request = RequestUtil.getRequest();
        if (user.getPeopleName() == null || StaticConstant.NO_NAME.equals(user.getPeopleName())) {
            String aa = "<a href=\""+ CommonUtil.getStandardUrl("setNamePage") +"\">取个名字吧</a>";
            request.setAttribute("tips", "你没有名字，不能千里传音。<br/>"+aa);
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
        }
        count = IllegalWordsSearch.getInstance().Replace(count);
        request.setAttribute("word", count);

        ChatRecordDTO record = new ChatRecordDTO();
        record.setCreateTime(new Date());
        record.setMsg(count);
        record.setSendPeopleName(user.getPeopleName());
        record.setSendUserId(user.getUserId());
        CacheUtil.publicChatRecordCache.put(record);

        ChatRecord chatRecord = initChatRecord(count, user.getUserId());
        chatRecord.setType(StaticEnum.CHAT_RECORD_TYPE_PUBLIC);
        chatRecordMappper.insert(chatRecord);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/chatChannel/saySuccess";
    }

    private ChatRecord initChatRecord(String msg,Long senderID){
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setId(SnowFlakeUtil.getInstance().nextId());
        chatRecord.setMsg(msg);
        chatRecord.setSenderID(senderID);
        return chatRecord;
    }

    public void sayToOtherPeople(Long userId, String count) {
        User otherUser = CacheUtil.roleEntityCache.userID_roleEntityMap.get(userId).getUser();
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        HttpServletRequest request = RequestUtil.getRequest();
        count = IllegalWordsSearch.getInstance().Replace(count);
        request.setAttribute("word", count);
        request.setAttribute("otherUserName", otherUser.getPeopleName());
        request.setAttribute("otherUserId", otherUser.getUserId());

        ChatRecordDTO chatRecordDTO = new ChatRecordDTO();
        chatRecordDTO.setMsg(count);
        chatRecordDTO.setCreateTime(new Date());
        chatRecordDTO.setSendUserId(currRoleEntity.getUser().getUserId());
        chatRecordDTO.setSendPeopleName(currRoleEntity.getUser().getPeopleName());
        CacheUtil.privateChatImmediateCache.put(chatRecordDTO, userId);
    }
}
