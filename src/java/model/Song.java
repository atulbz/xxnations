/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shaishav
 */
public class Song {
    
    String song_id,Album_id,Song_name,song_url;

   

    public String getAlbum_id() {
        return Album_id;
    }

    public void setAlbum_id(String Album_id) {
        this.Album_id = Album_id;
    }

    public String getSong_name() {
        return Song_name;
    }

    public void setSong_name(String Song_name) {
        this.Song_name = Song_name;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }
    
    
    
    
    
    
    
}
