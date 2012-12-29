/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shaishav
 */
public class modelrequest {
         int request_id,user_id;
         String album,song,rtime,username;

         public String getUsername() {
                  return username;
         }

         public void setUsername(String username) {
                  this.username = username;
         }

         public String getAlbum() {
                  return album;
         }

         public void setAlbum(String album) {
                  this.album = album;
         }

         public int getRequest_id() {
                  return request_id;
         }

         public void setRequest_id(int request_id) {
                  this.request_id = request_id;
         }

         public String getRtime() {
                  return rtime;
         }

         public void setRtime(String rtime) {
                  this.rtime = rtime;
         }

         public String getSong() {
                  return song;
         }

         public void setSong(String song) {
                  this.song = song;
         }

         public int getUser_id() {
                  return user_id;
         }

         public void setUser_id(int user_id) {
                  this.user_id = user_id;
         }
         
}
