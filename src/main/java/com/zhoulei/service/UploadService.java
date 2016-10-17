package com.zhoulei.service;

import java.io.InputStream;


public interface UploadService {
    boolean upload(InputStream inputStream,String fileName);
}
