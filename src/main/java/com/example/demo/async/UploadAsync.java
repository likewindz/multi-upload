package com.example.demo.async;

import com.example.demo.entity.UploadEntity;
import com.example.demo.util.UploadQueue;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author likeWind
 * @date created in 15:33 2020/2/19
 * @description 异步上传文件
 */
@Component
public class UploadAsync {

    @Async
    public void upload(UploadEntity entity){
        System.out.println("设备"+entity.getSId()+"上传文件"+entity.getFileName()+"  start");
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("设备"+entity.getSId()+"上传文件"+entity.getFileName()+"  上传成功");
        UploadQueue.startQueue.remove(entity.getSId());
        if (UploadQueue.queueMap.get(entity.getSId()).size()==1){
            UploadQueue.queueMap.remove(entity.getSId());
        }else{
            UploadQueue.queueMap.get(entity.getSId()).remove();
        }
    }

}
