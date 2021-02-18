package com.jida.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jida.common.cache.data.RoleEntity;
import com.jida.common.constant.StaticConstant;
import com.jida.common.util.*;
import com.jida.common.util.illegalWordUtil.IllegalWordsSearch;
import com.jida.common.util.illegalWordUtil.IllegalWordsSearchResult;
import com.jida.dto.*;
import com.jida.entity.ForumPost;
import com.jida.entity.ForumReply;
import com.jida.mapper.ForumPostMapper;
import com.jida.mapper.ForumReplyMappper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForumService {
    @Resource
    private ForumPostMapper forumPostMapper;
    @Resource
    private ForumReplyMappper forumReplyMappper;

    public void forumNormalPostList(int pageNum, int pageSize) {
        Integer count = forumPostMapper.getForumPostListCount();
        Integer totalPage = (count + pageSize - 1)/pageSize;
        List<ForumPostDto> forumPostList = forumPostMapper.getForumPostList(pageNum*pageSize,pageSize);

        List<ForumPostDto> topForumPostList = forumPostMapper.getTopForumPostList();
        ForumNormalPostListDto dto = new ForumNormalPostListDto();
        dto.setDataList(forumPostList);
        dto.setTopList(topForumPostList);
        dto.setCurrPage(pageNum+1);
        dto.setTotalPage(totalPage);
        dto.setCount(count);
        HttpServletRequest request = RequestUtil.getRequest();
        request.setAttribute("forumNormalPostListDto",dto);
    }

    public void forumPostDetail(Long id, int pageNum, int pageSize, Integer postPageNum, Integer postPageSize) {
        ForumPostDto forumPost = forumPostMapper.getForumPostByPostID(id);
        Integer count = forumReplyMappper.getReplyListCountByPostID(id);
        Integer totalPage = (count + pageSize - 1)/pageSize;
        List<ForumReplyDto> replyList = forumReplyMappper.getReplyListByPostID(id,pageNum*pageSize,pageSize);

        //阅读数+1
        ForumPost forumPost1 = new ForumPost();
        forumPost1.setId(id);
        ForumPost forumPost2 = new ForumPost();
        forumPost2.setReadNum(forumPost.getReadNum()+1);
        forumPostMapper.update(forumPost2,Wrappers.lambdaUpdate(forumPost1));
        ForumPostDetailDto forumPostDetailDto = new ForumPostDetailDto();
        forumPostDetailDto.setPostData(forumPost);
        forumPostDetailDto.setReplyList(replyList);
        forumPostDetailDto.setCurrPage(pageNum+1);
        forumPostDetailDto.setTotalPage(totalPage);
        forumPostDetailDto.setCount(count);
        forumPostDetailDto.setPostPageNum(postPageNum);
        forumPostDetailDto.setPostPageSize(postPageSize);
        HttpServletRequest request = RequestUtil.getRequest();
        request.setAttribute("forumPostDetailDto",forumPostDetailDto);
    }

    public void replyPostPage(Long postID, Integer postPageNum, Integer postPageSize, Integer replyPageNum, Integer replyPageSize) {
        ReplyPostPageDto dto = new ReplyPostPageDto();
        dto.setPostID(postID);
        dto.setPostPageNum(postPageNum);
        dto.setPostPageSize(postPageSize);
        dto.setReplyPageNum(replyPageNum);
        dto.setReplyPageSize(replyPageSize);
        HttpServletRequest request = RequestUtil.getRequest();
        request.setAttribute("replyPostPageDto",dto);
    }

    public String replyPost(String count, Long postID, Integer postPageNum, Integer postPageSize, Integer replyPageNum, Integer replyPageSize) {
        HttpServletRequest request = RequestUtil.getRequest();
        RoleEntity roleEntity = CacheUtil.getCurrRoleEntity();
        if(CheckParamUtl.checkNoName(roleEntity.getUser().getPeopleName())){
            request.setAttribute("tips", "你没有名字，不能回复帖子。<br/><a href=\""+ CommonUtil.getStandardUrl("setNamePage") +"\">取个名字吧</a>");
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
        }
        boolean isPass = true;
        if(StringUtils.isEmpty(count)){
            isPass = false;
            request.setAttribute("tipReply","回复内容不能为空");
        }
        if(count.length()>500){
            isPass = false;
            request.setAttribute("tipReply","回复内容不能超过500字");
        }
        List<IllegalWordsSearchResult> illegalWordTitle = IllegalWordsSearch.getInstance().FindAll(count);
        if(illegalWordTitle.size()>0){
            isPass = false;
            String illegalWord = illegalWordTitle.stream().map(IllegalWordsSearchResult::getKeyword).collect(Collectors.joining(","));
            request.setAttribute("tipReply","发现敏感词，请修改后提交:"+illegalWord);
        }
        if(!isPass){
            request.setAttribute("count",count);
            ReplyPostPageDto dto = new ReplyPostPageDto();
            dto.setPostID(postID);
            dto.setPostPageNum(postPageNum);
            dto.setPostPageSize(postPageSize);
            dto.setReplyPageNum(replyPageNum);
            dto.setReplyPageSize(replyPageSize);
            request.setAttribute("replyPostPageDto",dto);
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/forum/forumReplyPage";
        }
        ForumReply forumReply = new ForumReply();
        forumReply.setId(SnowFlakeUtil.getInstance().nextId());
        forumReply.setMsg(count);
        forumReply.setReplyerID(roleEntity.getUser().getUserId());
        forumReply.setPostID(postID);
        forumReplyMappper.insert(forumReply);

        //最新回复帖子靠前，回复数+1
        ForumReply forumReplyCon = new ForumReply();
        forumReplyCon.setPostID(forumReply.getPostID());
        Integer replyCount = forumReplyMappper.selectCount(Wrappers.lambdaQuery(forumReplyCon));
        ForumPost forumPost = new ForumPost();
        forumPost.setReplyNum(replyCount);
        forumPost.setLastReplyTime(new Date());
        ForumPost forumPost2 = new ForumPost();
        forumPost2.setId(postID);
        forumPostMapper.update(forumPost, Wrappers.lambdaUpdate(forumPost2));

        ForumReplySuccessDto dto = new ForumReplySuccessDto();
        dto.setPostID(postID);
        dto.setPostPageNum(postPageNum);
        dto.setPostPageSize(postPageSize);
        request.setAttribute("forumReplySuccessDto",dto);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/forum/forumReplySuccess";
    }

    public void forumSendPostPage(Integer postPageNum, Integer postPageSize) {
        HttpServletRequest request = RequestUtil.getRequest();
        request.setAttribute("postPageNum",postPageNum);
        request.setAttribute("postPageSize",postPageSize);
    }

    public String sendPost(String count, String other, Integer postPageNum, Integer postPageSize) {
        HttpServletRequest request = RequestUtil.getRequest();
        RoleEntity roleEntity = CacheUtil.getCurrRoleEntity();
        if(CheckParamUtl.checkNoName(roleEntity.getUser().getPeopleName())){
            request.setAttribute("tips", "你没有名字，不能发表帖子。<br/><a href=\""+ CommonUtil.getStandardUrl("setNamePage") +"\">取个名字吧</a>");
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/wrong";
        }
        boolean isPass = true;
        if(StringUtils.isEmpty(count)){
            isPass = false;
            request.setAttribute("tipTitle","标题不能为空");
        }
        if(count.length()>20){
            isPass = false;
            request.setAttribute("tipTitle","标题不能超过20字");
        }
        List<IllegalWordsSearchResult> illegalWordTitle = IllegalWordsSearch.getInstance().FindAll(count);
        if(illegalWordTitle.size()>0){
            isPass = false;
            String illegalWord = illegalWordTitle.stream().map(IllegalWordsSearchResult::getKeyword).collect(Collectors.joining(","));
            request.setAttribute("tipTitle","发现敏感词，请修改后提交:"+illegalWord);
        }
        if(StringUtils.isEmpty(other)){
            isPass = false;
            request.setAttribute("tipContent","内容不能为空");
        }
        if(other.length()>800){
            isPass = false;
            request.setAttribute("tipContent","内容不能超过800字");
        }
        illegalWordTitle = IllegalWordsSearch.getInstance().FindAll(other);
        if(illegalWordTitle.size()>0){
            isPass = false;
            String illegalWord = illegalWordTitle.stream().map(IllegalWordsSearchResult::getKeyword).collect(Collectors.joining(","));
            request.setAttribute("tipContent","发现敏感词，请修改后提交:"+illegalWord);
        }
        if(!isPass){
            request.setAttribute("count",count);
            request.setAttribute("other",other);
            request.setAttribute("postPageNum",postPageNum);
            request.setAttribute("postPageSize",postPageSize);
            return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/forum/forumSendPostPage";
        }
        ForumPost forumPost = new ForumPost();
        forumPost.setId(SnowFlakeUtil.getInstance().nextId());
        forumPost.setContent(other);
        forumPost.setTitle(count);
        forumPost.setSenderID(roleEntity.getUser().getUserId());
        forumPostMapper.insert(forumPost);
        request.setAttribute("postPageNum",postPageNum);
        request.setAttribute("postPageSize",postPageSize);
        return StaticConstant.DEFAULT_JSP_DIRECTORY + "/function/forum/forumSendPostSuccess";
    }
}
