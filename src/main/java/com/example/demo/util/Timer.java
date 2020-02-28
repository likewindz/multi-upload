package com.example.demo.util;

import com.example.demo.async.UploadAsync;
import com.example.demo.entity.UploadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;


/**
 * @author likeWind
 * @date created in 15:20 2020/2/19
 * @description
 */
@Component
public class Timer implements Runnable {


    @Autowired
    private UploadAsync uploadAsync;

    @Override
    public void run() {
        while (true) {
            long sleepTime = 1000L;
            Set<String> strings = UploadQueue.queueMap.keySet();
            if (CollectionUtils.isEmpty(strings)) {
                continue;
            }
            for (String sid : strings) {
                if (UploadQueue.startQueue.get(sid) == null && UploadQueue.queueMap.get(sid).size() != 0) {
                    UploadQueue.startQueue.put(sid,sid);
                    UploadEntity remove = UploadQueue.queueMap.get(sid).element();
                    uploadAsync.upload(remove);
                }
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
