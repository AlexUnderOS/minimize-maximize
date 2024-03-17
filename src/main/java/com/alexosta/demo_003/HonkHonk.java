package com.alexosta.demo_003;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import javafx.scene.media.MediaPlayer;

public class HonkHonk extends Application {

    private Media media1 = new Media(getClass().getResource("audio/1.mp3").toExternalForm());
    private Media media2 = new Media(getClass().getResource("audio/cats.mp3").toExternalForm());

    private MediaPlayer player1 = new MediaPlayer(media1);
    private MediaPlayer player2 = new MediaPlayer(media2);
    private final AudioClip clip1 = new AudioClip(getClass().getResource("audio/honk.mp3").toExternalForm());

    private ImageView imgView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Honk-honk");

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        imgView = new ImageView();

        imgView.setPreserveRatio(true);
        imgView.setFitWidth(400);

        primaryStage.setScene(new Scene(hBox));

        Image img1 = new Image(getClass().getResourceAsStream("imgs/dog1.jpg"));
        Image img2 = new Image(getClass().getResourceAsStream("imgs/dog2.jpg"));
        imgView.setImage(img2);

        hBox.getChildren().add(imgView);

        player2.play();
        primaryStage.iconifiedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                System.out.println("minimized:" + t1.booleanValue());
                if (t1.booleanValue()){
                    player1.play();
                    player2.pause();
                }
                else{
                    imgView.setImage(img1);
                    player1.pause();
                    player2.play();
                }
            }
        });

        hBox.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clip1.play();
            }
        });

        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
