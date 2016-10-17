package com.zhoulei.util;

import java.io.*;
import java.util.concurrent.Callable;


public class UploadServiceRunnable implements Callable<Boolean>{
    private InputStream inputStream;
    private String fileName;
    public UploadServiceRunnable(InputStream inputStream, String fileName){
        this.inputStream = inputStream;
        this.fileName = fileName;
    }
    @Override
    public Boolean call() {
        System.out.println("当前运行的线程 : "+Thread.currentThread().getName());
        File fileDir = new File("d://upload");
        if(!fileDir.exists()) fileDir.mkdir();
        File file = new File(fileDir+File.separator+fileName);
        byte buf[] = new byte[1024*4];
        try(BufferedInputStream fis = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            int len;
            while ((len = fis.read(buf))!= -1){
                bos.write(buf,0,len);
                bos.flush();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
