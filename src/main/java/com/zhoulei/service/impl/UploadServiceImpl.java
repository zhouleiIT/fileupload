package com.zhoulei.service.impl;

import com.zhoulei.service.UploadService;
import com.zhoulei.util.UploadServiceRunnable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
@Service
public class UploadServiceImpl implements UploadService{

    @Resource
    private ExecutorService executorService;
    @Override
    public boolean upload(InputStream inputStream, String fileName) {
        Future<Boolean> task = executorService.submit(new UploadServiceRunnable(inputStream, fileName));
        try {
            return task.get();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
