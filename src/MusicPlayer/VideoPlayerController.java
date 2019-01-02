package MusicPlayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayerController implements Initializable{
	@FXML private MediaPlayer mp;
	@FXML private MediaView mv;
	@FXML private Media me;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(MusicChooserController.getPath()!= null) {
			me = new Media(new File(MusicChooserController.getPath()).toURI().toString());
			mp = new MediaPlayer(me);
			mp.setAutoPlay(true);
			mv.setMediaPlayer(mp);
			DoubleProperty width = mv.fitWidthProperty();
			DoubleProperty height = mv.fitHeightProperty();
			width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
			height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
			mv.setPreserveRatio(true);
			mp.play();
			
			
		}
		
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
