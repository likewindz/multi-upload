package com.example.demo.web;

import com.example.demo.entity.UploadEntity;
import com.example.demo.util.UploadQueue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author likeWind
 * @date created in 14:50 2020/2/19
 * @description 上传服务
 */
@RestController
public class UploadController {



    @GetMapping("/upload")
    public String upload(UploadEntity entity){
        if(UploadQueue.queueMap.get(entity.getSId())==null){
            UploadQueue.queueMap.put(entity.getSId(),new ConcurrentLinkedQueue<>());
        }
        UploadQueue.queueMap.get(entity.getSId()).add(entity);
        return "加入队列，等待执行完成";
    }


}
