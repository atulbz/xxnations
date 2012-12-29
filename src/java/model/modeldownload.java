/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Shaishav
 */
public class modeldownload {
    String dtime;

         public String getDtime() {
                  return dtime;
         }

         public void setDtime(String dtime) {
                  this.dtime = dtime;
         }
    int download_id,user_id;
    String song_name,url;

         public int getDownload_id() {
                  return download_id;
         }

         public void setDownload_id(int download_id) {
                  this.download_id = download_id;
         }

      

         public String getSong_name() {
                  return song_name;
         }

         public void setSong_name(String song_name) {
                  this.song_name = song_name;
         }

         public String getUrl() {
                  return url;
         }

         public void setUrl(String url) {
                  this.url = url;
         }

         public int getUser_id() {
                  return user_id;
         }

         public void setUser_id(int user_id) {
                  this.user_id = user_id;
         }
    
}
