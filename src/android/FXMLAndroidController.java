/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 *
 * @author lherrera
 */
public class FXMLAndroidController implements Initializable {

    @FXML
    Label timeLabel;

    @FXML
    Label greetingLabel;

    @FXML
    Label labelWarning;

    @FXML
    ImageView droidImage;

    @FXML
    int counter = 0;

    @FXML
    DateFormat format = new SimpleDateFormat("HH:mm a");

    @FXML
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            Calendar cal = Calendar.getInstance();
            timeLabel.setText("The time is: " + format.format(cal.getTime()));

            if (cal.get(Calendar.HOUR_OF_DAY) < 12) {
                greetingLabel.setText("Good Morning");
            } else if (cal.get(Calendar.HOUR_OF_DAY) < 18) {
                greetingLabel.setText("Good Afternoon");
            } else {
                greetingLabel.setText("Good Evening");
            }
        }
    }));

    @FXML
    public void handleImageClickAction(MouseEvent me) {
        counter++;
        String temp;
        switch (counter) {
            case 1:
                temp = "once";
                break;
            case 2:
                temp = "twice";
                break;
            default:
                temp = String.format("%d times", counter);
        }

        labelWarning.setText(String.format("You touched the droid %s", temp));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
