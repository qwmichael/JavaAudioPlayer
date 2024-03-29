package MusicPlayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MusicChooser extends Application{

	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
 
        Parent root = FXMLLoader.load(getClass().getResource("FileChooser.fxml"));
        stage.setTitle("MusicPlayer");
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.show();
    }
    

}
