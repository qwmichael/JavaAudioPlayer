package MusicPlayer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.Initializable;


public class MusicChooserController implements Initializable {
    @FXML private Button SelectSong;
    @FXML private Button ConfirmSong;
    @FXML private FileChooser fc;
    @FXML private MediaPlayer mp;
	@FXML private MediaView mv;
	@FXML private Media me;
	@FXML private Slider volSlider;
	@FXML private TextArea ta;
	@FXML private BorderPane bp;
    private String path;
    private String LyricPath;
    private boolean flag = false;

   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		SelectSong.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				fc = new FileChooser();
				fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("MP3 audio files","*.mp3"),
						new FileChooser.ExtensionFilter("MP4 audio files", "*.mp4"));
				File file = fc.showOpenDialog(null);
				path = file.getAbsolutePath();
				

				if(path != null) {
					if(flag) {
						mp.stop();
						ta.clear();
					}
					flag = true;
					path = path.replace("\\", "/");
					LyricPath = path.substring(0, path.length()-3) + "txt";
					me = new Media(new File(path).toURI().toString());
					mp = new MediaPlayer(me);
					mp.setAutoPlay(true);
					mv.setMediaPlayer(mp);
					
					mp.play();
					mv.setPreserveRatio(false);
	        
			        volSlider.setValue(mp.getVolume() * 100);
			        volSlider.valueProperty().addListener(new InvalidationListener() {
			            @Override
			            public void invalidated(Observable observable) {
			                mp.setVolume(volSlider.getValue()/100);
			            }
			        });
			        
			        try {
						FileReader reader = new FileReader(LyricPath);
						BufferedReader br = new BufferedReader(reader);
						String s;
						while ((s = br.readLine()) != null) {
					        ta.appendText(br.readLine() +"\n");
					    }
						ta.requestFocus();
					    br.close();
					} catch (FileNotFoundException e) {
						return;
					} catch (IOException e) {
						return;
					} 
			        

			        
				
				}
				
			}
			
		});
		
		
	}
	
	
	@FXML private void Play(ActionEvent event) throws Exception {
		mp.setRate(1);
		mp.play();
	}
	@FXML private void Pause(ActionEvent event) throws Exception {
		mp.pause();
	}
	@FXML private void Fast(ActionEvent event) throws Exception {
		mp.setRate(2);
	}
	@FXML private void Slow(ActionEvent event) throws Exception {
		mp.setRate(0.5);
	}
	@FXML private void Reload(ActionEvent event) throws Exception {
		mp.seek(mp.getStartTime());
		mp.play();
	}
	@FXML private void Start(ActionEvent event) throws Exception {
		mp.seek(mp.getStartTime());
		mp.stop();
	}
	@FXML private void Last(ActionEvent event) throws Exception {
		mp.seek(mp.getTotalDuration());
		mp.stop();
	}
	

}