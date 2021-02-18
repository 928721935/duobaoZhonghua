package com.jida.common.util;

import com.jida.dto.FunctionDto;
import com.jida.dto.Place;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {
    public static List<Place> maps = new ArrayList<Place>();
    public static Map<Integer,Place> placeId_placeMap = new HashMap<>();

    public static void initMap(){
        FunctionDto functionDto = null;
        Place place = new Place();
        place.setPlaceId(1);
        place.setName("长安客栈（江湖起点）");
        place.setSencondName("长安客栈（江湖起点）");
        place.setNorthPlaceId(2);//北：洞房↑
        place.setWestPlaceId(3);//西：朱雀大街←
        place.setEastPlaceId(4);//东：江湖聚义厅→
        place.setDescription("长安客栈是江湖人物出没的地方，拜师可以找柳如烟、清法比丘、无名乞丐。在江湖百晓生那里可以领任务。");
        place.setSafe(true);

        functionDto = new FunctionDto();
        functionDto.setText("睡觉");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);
        maps.add(place);

        place = new Place();
        place.setPlaceId(2);
        place.setName("洞房");
        place.setSencondName("洞房");
        place.setSouthPlaceId(1);//南：长安客栈（江湖起点）↓
        place.setDescription("这里是洞房，可以在这里和情投意合的心上人结为夫妻，白头偕老。");
        place.setSafe(true);
        maps.add(place);

        place = new Place();
        place.setPlaceId(3);
        place.setName("朱雀大街");
        place.setSencondName("朱雀大街");
        place.setEastPlaceId(1);//东：长安客栈（江湖起点）→
        place.setSouthPlaceId(6);//南：朱雀南街↓
        place.setDescription("这是一条宽阔的青石板街道，向南北两头延伸,你走在一条繁忙的街道上，看着操着南腔北调的人们行色匆匆。");
        maps.add(place);

        place = new Place();
        place.setPlaceId(4);
        place.setName("江湖聚义厅");
        place.setSencondName("江湖聚义厅");
        place.setWestPlaceId(1);//西：长安客栈（江湖起点）←
        place.setEastPlaceId(5);//东：新手村广场→
        place.setDescription("江湖豪杰相会于此。在这里你可以申请成为新人的师傅，也可以申请一个师傅带你玩这个游戏。");
        place.setSafe(true);

        functionDto = new FunctionDto();
        functionDto.setText("我要拜师");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);

        functionDto = new FunctionDto();
        functionDto.setText("我(要/停止)收徒");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);

        functionDto = new FunctionDto();
        functionDto.setText("我要出师");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);

        functionDto = new FunctionDto();
        functionDto.setText("收徒规则");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);

        functionDto = new FunctionDto();
        functionDto.setText("查看帮会");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);

        functionDto = new FunctionDto();
        functionDto.setText("建立帮会");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);

        functionDto = new FunctionDto();
        functionDto.setText("参与帮战");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);

        functionDto = new FunctionDto();
        functionDto.setText("查看帮战排行");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);
        maps.add(place);

        place = new Place();
        place.setPlaceId(5);
        place.setName("新手村广场");
        place.setSencondName("新手村广场");
        place.setWestPlaceId(4);//西：江湖聚义厅←
        place.setDescription("欢迎你来到风云变幻的江湖！祝你早日成为一代大侠。先从木人开始练手吧，也可以和武林信使对话做任务");
        place.setSafe(true);

        functionDto = new FunctionDto();
        functionDto.setText("取名字");
        functionDto.setUrl("setNamePage");
        place.getFunctionDtoList().add(functionDto);
        functionDto = new FunctionDto();
        functionDto.setText("血战（新）");
        functionDto.setUrl("");
        place.getFunctionDtoList().add(functionDto);
        maps.add(place);

        place = new Place();
        place.setPlaceId(6);
        place.setName("朱雀南街");
        place.setSencondName("朱雀南街");
        place.setNorthPlaceId(3);//北：朱雀大街↑
        place.setWestPlaceId(7);//西：江湖论坛←
        place.setDescription("这是一条宽阔的青石板街道，向南北两头延伸。南边就是朱雀门，你走在一条繁忙的街道上，看着操着南腔北调的人们行色匆匆。");
        maps.add(place);

        place = new Place();
        place.setPlaceId(7);
        place.setName("江湖论坛");
        place.setSencondName("江湖论坛");
        place.setEastPlaceId(6);//东：朱雀南街→
        place.setDescription("在这里你可以畅所欲言！");
        maps.add(place);

        functionDto = new FunctionDto();
        functionDto.setText("江湖论坛");
        functionDto.setUrl("forumNormalPostList");
        place.getFunctionDtoList().add(functionDto);

        for (Place placeTemp:maps) {
            placeId_placeMap.put(placeTemp.getPlaceId(),placeTemp);
        }
    }
}
