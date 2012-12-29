/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shaishav
 */
public class modelsearch {
    
    String Album_name,song_name,song_url,genre,Artist_name,img_url;

         public String getImg_url() {
                  return img_url;
         }

         public void setImg_url(String img_url) {
                  this.img_url = img_url;
         }
    int song_id,Album_id;

    public String getArtist_name() {
        return Artist_name;
    }

    public void setArtist_name(String Artist_name) {
        this.Artist_name = Artist_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    

   
    public String getAlbum_name() {
        return Album_name;
    }

    public void setAlbum_name(String Album_name) {
        this.Album_name = Album_name;
    }

  
    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSong_url() {
        return song_url;
    }

    public void setSong_url(String song_url) {
        this.song_url = song_url;
    }

    public int getAlbum_id() {
        return Album_id;
    }

    public void setAlbum_id(int Album_id) {
        this.Album_id = Album_id;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }
    














}
