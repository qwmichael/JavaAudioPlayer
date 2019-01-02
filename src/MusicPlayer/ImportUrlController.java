package MusicPlayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ImportUrlController implements Initializable{
	@FXML private Button EnterBtn;
	@FXML private TextField URLtf;
	@FXML private Slider volSlider;
	@FXML private WebView wv;
	private final String getURL() { return URLtf.getText(); }
    private final void setURL() { URLtf.setText(""); }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		wv = new WebView();
	    wv.getEngine().load(getURL());
	    wv.setPrefSize(640, 390);

	    
	}
	
	@FXML private void handleURL(ActionEvent event) throws IOException{
    	try {
    		wv = new WebView();
    	    wv.getEngine().load(getURL());
    	    wv.setPrefSize(640, 390);

    	}
    	catch (Exception e) {
    		
    	}
    	finally {
    		setURL(); 
    	}
    }
	
	
	

}
