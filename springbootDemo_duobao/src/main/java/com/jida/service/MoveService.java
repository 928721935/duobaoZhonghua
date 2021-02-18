package com.jida.service;

import com.jida.common.cache.data.RoleEntity;
import com.jida.common.util.CacheUtil;
import com.jida.common.util.CommonUtil;
import com.jida.common.util.MapUtil;
import com.jida.common.util.RequestUtil;
import com.jida.dto.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MoveService {
    @Resource
    private RoomService roomService;

    public String moveMap(String redirection) {
        RoleEntity roleInfo = CacheUtil.roleEntityCache.getCurrRoleEntity();
        int old_scene_id = roleInfo.getSceneId();
        int new_scene_id = roomService.getSceneByWay(old_scene_id, redirection);
        changeScene(new_scene_id, roleInfo.getUser().getUserId());

        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setMsg(roleInfo.getUser().getPeopleName() + "走了过来。");
        trackInfo.setCreateTime(new Date());
        trackInfo.getAreadyReadUserIds().add(roleInfo.getUser().getUserId());
        CacheUtil.comeSceneTrackCache.put(trackInfo);
        flashView();
        return "/WEB-INF/jsp/scene";
    }

    public void changeScene(Integer new_scene_id, Long userId) {
        RoleEntity roleInfo = CacheUtil.getRoleEntity(userId);
        Integer old_scene_id = roleInfo.getSceneId();
        CacheUtil.viewCache.remove(old_scene_id, userId);
        CacheUtil.viewCache.add(new_scene_id, userId);
        roleInfo.setSceneId(new_scene_id);
    }

    public String getCurrViewPeopleListStr(Integer new_scene_id) {
        RoleEntity currRoleEntity = CacheUtil.roleEntityCache.getCurrRoleEntity();
        StringBuffer sb = new StringBuffer();
        Set<RoleEntity> roleEntities = CacheUtil.viewCache.sceneID_usersMap.get(new_scene_id);
        String url = null;
        if (roleEntities.size() == 2) {
            url = "/getOtherPeopleInfo";
            sb.append("你遇到了<a href=\"");
            for (RoleEntity roleEntity : roleEntities) {
                if (!currRoleEntity.getUser().equals(roleEntity.getUser())) {
                    sb.append(CommonUtil.getStandardUrl(url + "?userId=" + roleEntity.getUser().getUserId()));
                    sb.append("\">");
                    sb.append("少林寺第一代弟子" + roleEntity.getUser().getPeopleName());
                    break;
                }
            }
        } else if (roleEntities.size() > 2) {
            url = "/getOtherPeopleList";
            sb.append("你遇到了<a href=\"");
            sb.append(CommonUtil.getStandardUrl(url));
            sb.append("\">");
            for (RoleEntity roleEntity : roleEntities) {
                if (!currRoleEntity.getUser().equals(roleEntity.getUser())) {
                    sb.append(roleEntity.getUser().getPeopleName() + ",");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        if (roleEntities.size() >= 2) {
            sb.append("</a><br/>");
        }
        return sb.toString();
    }

    public String flashView() {
        RoleEntity roleInfo = CacheUtil.roleEntityCache.getCurrRoleEntity();
        int new_scene_id = roleInfo.getSceneId();
        HttpServletRequest request = RequestUtil.getRequest();
        Place place = MapUtil.placeId_placeMap.get(new_scene_id);
        String scene_walk_info = getWalkInfo(place);
        String currViewPeopleList = getCurrViewPeopleListStr(new_scene_id);
        List<TrackInfo> comeSceneTrack = CacheUtil.comeSceneTrackCache.pull();
        List<String> comeSceneTrackStr = comeSceneTrack.stream().map(TrackInfo::getMsg).collect(Collectors.toList());
        List<ChatRecordDTO> privateChatRecordDTOList = CacheUtil.privateChatImmediateCache.pull();
        List<ChatRecordDTO> publicChatRecordDTOList = CacheUtil.publicChatRecordCache.pull();

        List<ChatRecordDTO> pull = CacheUtil.battlePrivateTrackCache.pull();
        StringBuffer sb = new StringBuffer();
        pull.stream().map(ChatRecordDTO::getMsg).forEach(sb::append);
        String battlePrivateMsg = sb.toString();
//        request.setAttribute("battle_private_msg",sb.toString());
//        request.setAttribute("publicChatRecordDTOList", publicChatRecordDTOList);
//        request.setAttribute("privateChatRecordDTOList", privateChatRecordDTOList);
//        request.setAttribute("scene_comeTrack", comeSceneTrackStr);
//        request.setAttribute("scene_peopleListStr", currViewPeopleList);
//        request.setAttribute("scene_walk_info", scene_walk_info);
//        request.setAttribute("scene_desc", place.getDescription());
//        request.setAttribute("scene_name", place.getName());
//        request.setAttribute("functionDtoList", place.getFunctionDtoList());
        String functionDtoListStr = getFunctionDtoListStr(place);
        SceneDto sceneDto = new SceneDto();
        sceneDto.setFunctionDtoListStr(functionDtoListStr);
        sceneDto.setBattlePrivateMsg(battlePrivateMsg);
        sceneDto.setPublicChatRecordDTOList(publicChatRecordDTOList);
        sceneDto.setPrivateChatRecordDTOList(privateChatRecordDTOList);
        sceneDto.setComeSceneTrackStr(comeSceneTrackStr);
        sceneDto.setScenePeopleListStr(currViewPeopleList);
        sceneDto.setSceneWalkInfo(scene_walk_info);
        sceneDto.setPlace(place);
        request.setAttribute("sceneDto", sceneDto);
        return "/WEB-INF/jsp/scene";
    }

    private String getFunctionDtoListStr(Place place) {
        StringBuffer sb = new StringBuffer();
        List<FunctionDto> functionDtoList = place.getFunctionDtoList();
        if (functionDtoList.size() > 0) {
            for (int i = 0; i < functionDtoList.size(); i++) {
                FunctionDto functionDto = functionDtoList.get(i);
                sb.append("<a href=\"").append(CommonUtil.getStandardUrl(functionDto.getUrl()));
                sb.append("\">");
                sb.append(functionDto.getText());
                sb.append("</a>");
                if (i != functionDtoList.size() - 1) {
                    sb.append(" | ");
                }
            }
//            sb.deleteCharAt(sb.length()-4);
        }
        return sb.toString();
    }

    private String getWalkInfo(Place place) {
//        <a href="http://localhost:8084/duobao/moveMapNorth">北：洞房↑</a><br/>
        StringBuffer result = new StringBuffer();
        if (place.getNorthPlaceId() != null) {
            Place placeTemp = MapUtil.placeId_placeMap.get(place.getNorthPlaceId());
//            result.append("<a href=\"").append(CommonUtil.encryptStr(CommonUtil.getContextPath()+"/moveMapNorth\">北："));
            result.append("<a href=\"").append(CommonUtil.getStandardUrl("/moveMap?redirection=North"));
            result.append("\">北：");
            result.append(placeTemp.getName());
            result.append("↑</a><br/>");
        }
        if (place.getWestPlaceId() != null) {
            Place placeTemp = MapUtil.placeId_placeMap.get(place.getWestPlaceId());
            result.append("<a href=\"").append(CommonUtil.getStandardUrl("/moveMap?redirection=West"));
            result.append("\">西：");
            result.append(placeTemp.getName());
            result.append("←</a><br/>");
        }
        if (place.getEastPlaceId() != null) {
            Place placeTemp = MapUtil.placeId_placeMap.get(place.getEastPlaceId());
            result.append("<a href=\"").append(CommonUtil.getStandardUrl("/moveMap?redirection=East"));
            result.append("\">东：");
            result.append(placeTemp.getName());
            result.append("→</a><br/>");
        }
        if (place.getSouthPlaceId() != null) {
            Place placeTemp = MapUtil.placeId_placeMap.get(place.getSouthPlaceId());
            result.append("<a href=\"").append(CommonUtil.getStandardUrl("/moveMap?redirection=South"));
            result.append("\">南：");
            result.append(placeTemp.getName());
            result.append("↓</a><br/>");
        }
        return result.toString();
    }
}
