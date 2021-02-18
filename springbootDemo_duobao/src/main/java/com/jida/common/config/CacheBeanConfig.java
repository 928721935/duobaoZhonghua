package com.jida.common.config;

import com.jida.common.cache.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class CacheBeanConfig {

    //场景视野
    /*@Bean
    public ViewCache b1(){
        ViewCache viewCache = new ViewCache();
        return viewCache;
    }*/

    //私聊即时信息
    @Bean(name = "privateChatImmediateCache")
    public SelfTrackCache b2(){
        SelfTrackCache bean = new SelfTrackCache();
        return bean;
    }

    //战斗个人战报
    @Bean(name = "battlePrivateTrackCache")
    public BattlePrivateTrackCache b3(){
        BattlePrivateTrackCache bean = new BattlePrivateTrackCache(6);
        return bean;
    }

    //公聊历史信息
    @Bean(name = "publicChatRecordCache")
//    @Lazy(value = false)
    public ChatRecordCache b4(){
        ChatRecordCache bean = new ChatRecordCache(20,180);
        return bean;
    }

    //场景人物进入提示信息
    @Bean(name = "comeSceneTrackCache")
    public SceneTrackCache b5(){
        SceneTrackCache bean = new SceneTrackCache(6,5);
        return bean;
    }

    /*//私聊即时信息
    @Bean
    public SelfTrackCache b6(){
        SelfTrackCache bean = new SelfTrackCache();
        return bean;
    }*/
}
