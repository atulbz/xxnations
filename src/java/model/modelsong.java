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
public class modelsong {
    
    String Song_name,song_url,Artist_name,duration,len,demo_url,release_year,genre,ddate,img_url;
    int song_id,album_id,bitrate,frequency,Genre_id;
    double rating;

    public String getDdate() {
        return ddate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }
  
 public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
    

    public int getGenre_id() {
        return Genre_id;
    }

    public void setGenre_id(int Genre_id) {
        this.Genre_id = Genre_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getDemo_url() {
        return demo_url;
    }

    public void setDemo_url(String demo_url) {
        this.demo_url = demo_url;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLen() {
        return len;
    }

    public void setLen(String len) {
        this.len = len;
    }
   
    public String getArtist_name() {
        return Artist_name;
    }

    public void setArtist_name(String Artist_name) {
        this.Artist_name = Artist_name;
    }

    
    public String getSong_name() {
        return Song_name;
    }

    public void setSong_name(String Song_name) {
        this.Song_name = Song_name;
    }

    
    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

 

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }
  
}
