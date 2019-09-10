package com.dhm.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/8/15 14:30
 */
@Slf4j
public class FutureTest {

    public static Random random = new Random();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.准备数据
        long preDataStart = System.currentTimeMillis();
        //异步准备数据，减少准备时间
        ExecutorService preDataExecutor = Executors.newFixedThreadPool(3);


        Future consumeAmountDatas = preDataExecutor.submit(()->{
            log.info("1.准备存入金额数据......");
            long start = System.currentTimeMillis();
            Thread.sleep(random.nextInt(10000));
            long end = System.currentTimeMillis();
            log.info("1.准备存入金额数据，耗时：" + (end - start) + "毫秒");
            return "1";
        });


        Future depositAmountDatas = preDataExecutor.submit(()->{
            log.info("2.准备消费金额数据......");
            long start = System.currentTimeMillis();
            Thread.sleep(random.nextInt(10000));
            long end = System.currentTimeMillis();
            log.info("2.准备消费金额数据，耗时：" + (end - start) + "毫秒");
            return "2";
        });


        Future statAcctFirstDetailDatas = preDataExecutor.submit(()->{
            log.info("3.准备一期数据......");
            long start = System.currentTimeMillis();
            Thread.sleep(random.nextInt(10000));
            long end = System.currentTimeMillis();
            log.info("3.准备一期数据，耗时：" + (end - start) + "毫秒");
            return "3";
        });

        preDataExecutor.shutdown();
        log.info("1.存入金额数据加载完成，数据条数：" + consumeAmountDatas.get());
        log.info("2.消费金额数据加载完成，数据条数：" + depositAmountDatas.get());
        log.info("3.一期数据加载完成，数据条数：" + statAcctFirstDetailDatas.get());

        long preDataEnd = System.currentTimeMillis();
        log.info("4.all准备数据耗时："+(preDataEnd-preDataStart)+"ms");
    }
}