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
public class modelalbum {
    
    String album_name,Artist_name,Album_info,img_url,Featuring_artists,genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    int Album_id,Genre_id;
    Date Release_date;

    public int getAlbum_id() {
        return Album_id;
    }

    public void setAlbum_id(int Album_id) {
        this.Album_id = Album_id;
    }

   

    public String getFeaturing_artists() {
        return Featuring_artists;
    }

    public void setFeaturing_artists(String Featuring_artists) {
        this.Featuring_artists = Featuring_artists;
    }

    

    public String getAlbum_info() {
        return Album_info;
    }

    public void setAlbum_info(String Album_info) {
        this.Album_info = Album_info;
    }

    public String getArtist_name() {
        return Artist_name;
    }

    public void setArtist_name(String Artist_name) {
        this.Artist_name = Artist_name;
    }

    public int getGenre_id() {
        return Genre_id;
    }

    public void setGenre_id(int Genre_id) {
        this.Genre_id = Genre_id;
    }

    public Date getRelease_date() {
        return Release_date;
    }

    public void setRelease_date(Date Release_date) {
        this.Release_date = Release_date;
    }

    


    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

 

    
    
    
}