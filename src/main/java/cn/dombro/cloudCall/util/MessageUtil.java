package cn.dombro.cloudCall.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MessageUtil {


    public static String remindCsByAdmin(String missionName,LocalDate endDate){
        LocalDate today = LocalDate.now();
        long betweenDay =  ChronoUnit.DAYS.between(today,endDate);
        return "您接收的任务 ："+missionName+ " ,还有 "+betweenDay+" 天截止，系统提醒您请尽快完成！";
    }

    public static String remindCsByCompany(String missionName,LocalDate endDate,String company){
        LocalDate today = LocalDate.now();
        long betweenDay = ChronoUnit.DAYS.between(today,endDate);
        return  "您接收的任务 ："+ missionName + " ,还有 "+betweenDay+" 天截止，"+company+"公司提醒您请尽快完成！";
    }

    public static String toCsBySa(String missionName){
        return "您结算的任务 ："+missionName+ " ,已经通过企业确认和平台确认,请前往平台的任务详情页查看相关评价以及验收结算金额。";
    }

    public static String passMissionBySa(String missionName){
        return "贵公司发布的任务 ："+missionName+ " ,已经通过审核,请耐心等待客服接单。";
    }

    public static String unPassMissionBySa(String missionName){
        return "贵公司发布的任务 ："+missionName+ " ,未通过审核,请前往平台查看审核批注。";
    }

    public static String missionAcceptBySa(String missionName){
        return "贵公司发布的需求："+missionName+ " ,已被客服受理，请实时查看任务进度。";
    }

    public static String sattleAccountBySa(String missionName){
        return "贵公司发布的需求 ："+missionName+ " ,已经被客服请求结算，请前往平台的任务详情页面确认任务结果并给出评分。";
    }

    public static String toSaForMission(String company){
        return "企业 ："+company+ ", 发布呼叫需求，请尽快审核！";
    }
    public static String toSaForSattle(String scName,String missionName){
        return "客服 ： "+scName+",请求结算任务："+missionName+",请前往任务详情页面确认任务结果并给出评分。";
    }

}
