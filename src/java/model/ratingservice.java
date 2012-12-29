/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shaishav
 */
public class ratingservice {
String classname,driver;

    public ratingservice(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
    }
    
    public void setRating(String song_id,int rate)
    {
        
        ratingdao obj=new ratingdao(classname,driver);
        obj.setRatingdao(song_id,rate);
        
    }

    public double getRating(String song_id)
    {
        
        ratingdao obj=new ratingdao(classname,driver);
        return obj.getRatingdao(song_id);
        
    }
}
