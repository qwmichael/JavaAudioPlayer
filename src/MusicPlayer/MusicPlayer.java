package MusicPlayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MusicPlayer extends Application{

	@Override
    public void start(Stage stage) throws Exception {
 
        Parent root = FXMLLoader.load(getClass().getResource("MusicPlayer.fxml"));
        stage.setTitle("MusicPlayer");
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.show();
        //MusicPlayerController.startup();
    }

}
