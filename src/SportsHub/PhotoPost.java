package SportsHub;

import java.awt.*;

public class PhotoPost extends Post implements UploadedContentPost {

    private String filename;
    private String caption;
    private Image image=null;


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public PhotoPost (String author, String filename, String caption, Image image) {
        super (author);
        this.filename = filename;
        this.caption = caption;
        this.image = image;
    }


    public String getFilename () {
        return filename;
    }

    public void setFilename (String filename) {
        this.filename = filename;
    }

    public String getCaption () {
        return caption;
    }

    public void setCaption (String caption) {
        this.caption = caption;
    }

    public void display () {



    }

    @Override
    public void upload (String filename) {
        System.out.println ("Uploading " + filename + " ...");
    }
}
