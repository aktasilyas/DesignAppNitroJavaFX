package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SampleController implements Initializable {
	

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;

    @FXML
    private JFXButton nextaction;

    @FXML
    private JFXButton backaction;

    @FXML
    private Label countLabel;
    
    public void translateAnimation(double duration, Node node,double byX) {
    	TranslateTransition transition=new TranslateTransition(Duration.seconds(duration),node);
    	transition.setByX(byX);
    	transition.play();
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
		
	}
    @FXML
    void backAction(ActionEvent event) {
    	
    	
    	if (showSlide==0) {
    		System.out.println("no more slide");
			
		}
    	else if (showSlide==1) {
			translateAnimation(0.5, pane2, 600);
			showSlide--;
			countLabel.setText("1/3");
			
		}
    	else if (showSlide==2) {
    		translateAnimation(0.5, pane3, 600);
			showSlide--;
			countLabel.setText("2/3");
		}

    }

    int showSlide=0;
    @FXML
    void nextAction(ActionEvent event) {

    	if (showSlide==0) {
    		translateAnimation(0.5, pane2, -600);
    		showSlide++;
    		countLabel.setText("2/3");
		}
    	else if (showSlide==1) {
    		translateAnimation(0.5, pane3, -600);
    		showSlide++;
    		countLabel.setText("3/3");
		}
    	else {
			System.out.println("no more slide");
		}
    	
    }
	
}
