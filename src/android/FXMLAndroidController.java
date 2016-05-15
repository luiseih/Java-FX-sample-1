/* 
 * Copyright (C) 2016 Luis E. I. Herrera <lherrera at sdf.org>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
