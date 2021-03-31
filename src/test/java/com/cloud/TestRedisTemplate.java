package com.cloud;

import com.emc.ecs.nfsclient.nfs.io.Nfs3File;
import com.emc.ecs.nfsclient.nfs.io.NfsFileOutputStream;
import com.emc.ecs.nfsclient.nfs.nfs3.Nfs3;
import com.emc.ecs.nfsclient.rpc.CredentialUnix;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.concurrent.TimeUnit;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedisTemplate {

    private static final String NFS_IP = "192.168.56.131";
    private static final String NFS_DIR = "/app/file";

    @Autowired
    private RedisTemplate<String,Serializable> redisTemplate;


    private Logger logger = LoggerFactory.getLogger(TestRedisTemplate.class);


    @Test
    @Scheduled(cron = " 0 0 0 * * ? ")
    public void testSchedule(){

    }

    public static void main(String[] args) {
        uploadFileToNfs();
    }
    public static void uploadFileToNfs() {
        String localDir = "E:\\look\\look.txt";
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //创建一个本地文件对象
            File localFile = new File(localDir);
            //获取本地文件的文件名，此名字用于在远程的Nfs服务器上指定目录创建同名文件
            String localFileName = localFile.getName();
            Nfs3 nfs3 = new Nfs3(NFS_IP, NFS_DIR, new CredentialUnix(0, 0, null), 3);
            //创建远程服务器上Nfs文件对象
            Nfs3File NfsFile = new Nfs3File(nfs3, "/" + localFileName);
            //打开一个文件输入流
            inputStream = new BufferedInputStream(new FileInputStream(localFile));
            //打开一个远程Nfs文件输出流，将文件复制到的目的地
            outputStream = new BufferedOutputStream(new NfsFileOutputStream(NfsFile));

            //缓冲内存
            byte[] buffer = new byte[1024];
            while ((inputStream.read(buffer)) != -1) {
                outputStream.write(buffer);
            }
            System.out.println("文件上传完成！");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public  void testJedis(){
        redisTemplate.opsForValue().set("123",15,20, TimeUnit.SECONDS);

    }
}
