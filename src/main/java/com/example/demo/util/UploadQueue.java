package com.example.demo.util;


import com.example.demo.entity.UploadEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author likeWind
 * @date created in 14:58 2020/2/19
 * @description 文件上传队列
 */
public class UploadQueue {


  public static final Map<String,String> startQueue = new ConcurrentHashMap<>();

  public static final Map<String, ConcurrentLinkedQueue<UploadEntity>> queueMap = new ConcurrentHashMap<>();

}
