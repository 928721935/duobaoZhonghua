package com.jida.aspesct;

import com.jida.common.util.CacheUtil;
import com.jida.common.cache.data.RoleEntity;
import com.jida.service.BattleService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Aspect
@Component
public class BeAttackedAspect {
    @Resource
    private BattleService battleService;

    @Pointcut("@within(BeAttackAnnotation)")
    public void perform(){

    }

    @Around(value="perform()")
    public String aroundMethod(ProceedingJoinPoint jp) throws Throwable {
        RoleEntity currRoleEntity = CacheUtil.getCurrRoleEntity();
        if(currRoleEntity.isInBattle()){
            return battleService.flashBattleRecord();
        }
        return (String)jp.proceed();
    }
}
