package SportsHub;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

public class WallPosts {

    public Text lastNameLabel;
    public Text firstNameLabel;
    public ImageView profilePicture;
    public Text usernameLabel;
    public Text friendLabel;
    public Text nameLabel;

    @FXML
    void initialize() throws IOException {
        personaliseScene();
    }

    private ArrayList <Post> posts;

    public WallPosts() {
        posts = new ArrayList<> ();
    }

    public void addPost (Post p) {
        posts.add (p);
    }

    public void show () {
        for (Post p : posts) {
            p.display ();
        }
    }

    public void showPhotos () {
        for (Post p : posts) {
            if (p instanceof PhotoPost) {
                p.display ();
            }
        }
    }

    private void personaliseScene() throws IOException {

        // personalising page based on logged-in user
        nameLabel.setText(Main.getCurrentAccount().getAccountFirstName() + " " + Main.getCurrentAccount().getAccountLastName());
        usernameLabel.setText(Main.getCurrentAccount().getAccountUsername());

        if (new File(Main.getCurrentAccount().getAccountUsername() + "jpg").exists()) {
            String path = URLDecoder.decode("profileImages/", "UTF-8");
            File file = new File(path + Main.getCurrentAccount().getAccountUsername() + ".png");
            Image img = SwingFXUtils.toFXImage(ImageIO.read(file), null);
            profilePicture.setImage(img);

        }
    }

    public void uploadProfileImage(MouseEvent mouseEvent) {

    }
}
