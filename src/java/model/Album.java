/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shaishav
 */
public class Album {
    String album_name;
    String Genre_id,song_id,Album_id,Release_date,Artist_name,Album_info,img_url;

    public String getAlbum_id() {
        return Album_id;
    }

    public void setAlbum_id(String Album_id) {
        this.Album_id = Album_id;
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

    public String getGenre_id() {
        return Genre_id;
    }

    public void setGenre_id(String Genre_id) {
        this.Genre_id = Genre_id;
    }

    public String getRelease_date() {
        return Release_date;
    }

    public void setRelease_date(String Release_date) {
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

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    
    
    
}