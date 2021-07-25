package com.hq;

import java.io.*;
import java.util.List;

/**
 * 用于数据的读取与保存
 */
public class DataBase {
    public List<Person> readData(String filePath){
        ObjectInputStream bis = null;
        FileInputStream fis = null;
        List<Person> list = null;
        try{
            fis = new FileInputStream(filePath);
            bis = new ObjectInputStream(fis);
            list = (List<Person>)bis.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(bis != null){
                    bis.close();
                }
                if(fis != null){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
     }

     public void writeData(String filePath,List<Person> list){
         ObjectOutputStream bos = null;
         FileOutputStream fos = null;
         try{
             fos = new FileOutputStream(filePath);
             bos = new ObjectOutputStream(fos);
             bos.writeObject(list);
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             try{
                 if(bos != null){
                     bos.close();
                 }
                 if(fos != null){
                     fos.close();
                 }
             }catch (Exception e){
                 e.printStackTrace();
             }
         }
     }
}
