package cn.dombro.cloudCall.util;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by 18246 on 2017/7/16.
 */
public class GeneratorUtilTest {

    @Test
    public void testGetRunningId() {
        for (int i = 0; i < 5; i++) {
            System.out.println(GeneratorUtil.createRunningId(232));
        }

    }

    @Test
    public void testGreatPassword() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        uuidStr = uuidStr.substring(12);
        System.out.println(uuidStr.length());
        System.out.println(GeneratorUtil.creatPassword());
    }

    @Test
    public void testCreatAccount() {
        String account = GeneratorUtil.creatAccount();
        System.out.println(account + " 位数" + account.length());
    }
}

