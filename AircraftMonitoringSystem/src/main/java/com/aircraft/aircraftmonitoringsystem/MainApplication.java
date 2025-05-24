package com.aircraft.aircraftmonitoringsystem;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

public class MainApplication extends Application {
    @Override

    public void start(Stage stage) throws IOException {
        //Initialisation du contenaire dea fenètre
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-image: url(\"file:src/images/background.jpg\");\n" +
                "-fx-background-repeat: stretch;\n" +
                "-fx-background-size: auto;\n" +
                "-fx-background-position: center center;\n" +
                "-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);");
        //initialiation de la division qui va contenir les images
        StackPane imagesPane = new StackPane();

        //initialisation de l'image du radare
        Image radarImage = new Image("file:src/images/radar.png");
        ImageView radar = new ImageView(radarImage);
        radar.setFitHeight(715);
        radar.setFitWidth(715);
        radar.setPreserveRatio(true);

        //initialisation de l'indicateur du radar
        Image indicatorImage = new Image("file:src/images/indicator.png");
        ImageView indicator = new ImageView(indicatorImage);
        radar.setFitHeight(715);
        radar.setFitWidth(715);
        radar.setPreserveRatio(true);
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), indicator);
        rotateTransition.setByAngle(-360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        rotateTransition.play();

        //initialisation de l'image du fuselage
        Image fuselageImage = new Image("file:src/images/Boeing 737 green fuselage.png");
        ImageView fuselage = new ImageView(fuselageImage);
        radar.setFitHeight(715);
        radar.setFitWidth(715);
        radar.setPreserveRatio(true);

        //initialisation de l'image du right wing
        Image rightWingImage = new Image("file:src/images/Boeing 737 orange right wing.png");
        ImageView rightWing = new ImageView(rightWingImage);
        radar.setFitHeight(715);
        radar.setFitWidth(715);
        radar.setPreserveRatio(true);

        //initialisation de l'image du left wing
        Image leftWingImage = new Image("file:src/images/Boeing 737 green left wing.png");
        ImageView leftWing = new ImageView(leftWingImage);
        radar.setFitHeight(715);
        radar.setFitWidth(715);
        radar.setPreserveRatio(true);

        //initialisation de l'image du tail
        Image tailImage = new Image("file:src/images/Boeing 737 red tail.png");
        ImageView tail = new ImageView(tailImage);
        radar.setFitHeight(715);
        radar.setFitWidth(715);
        radar.setPreserveRatio(true);

        //initialisation de l'image du right engine
        Image rightEngineImage = new Image("file:src/images/Boeing 737 green right engine.png");
        ImageView rightEngine = new ImageView(rightEngineImage);
        radar.setFitHeight(715);
        radar.setFitWidth(715);
        radar.setPreserveRatio(true);

        //initialisation de l'image du left engine
        Image leftEngineImage = new Image("file:src/images/Boeing 737 orange left engine.png");
        ImageView leftEngine = new ImageView(leftEngineImage);
        radar.setFitHeight(715);
        radar.setFitWidth(715);
        radar.setPreserveRatio(true);

        //Ajout des images
        imagesPane.getChildren().addAll(radar, indicator, fuselage, rightWing, leftWing, tail, rightEngine, leftEngine);
        root.setCenter(imagesPane);

        //initialisation de la barre droite des problèmes et des alertes
        VBox problemsPannel = new VBox();
        problemsPannel.setStyle("-fx-background-color: #2c2c2c");
        ObservableList problems = FXCollections.observableArrayList();
        problems.addAll(
                "Problem: tail\nThe vertical stabilizer of the tail is broken"
        );
        ListView problemsList = new ListView(problems);
        problemsPannel.getChildren().add(problemsList);
        root.setRight(problemsPannel);

        //initialisation de la barre supérieur
        ObservableList aircarfts = FXCollections.observableArrayList(
                "c0r0001-737-100",
                "a2c4821-737-300",
                "g3t9572-737-700",
                "m8x7584-737-M10"
        );
        ComboBox aircarftsComboBox = new ComboBox(aircarfts);

        HBox aircarftsPannel = new HBox();
        aircarftsPannel.setStyle("-fx-background-color: #2c2c2c");
        aircarftsPannel.getChildren().add(aircarftsComboBox);
        root.setTop(aircarftsPannel);

        //initialisation de la barre gauche des reports
        VBox reportsPannel = new VBox();
        reportsPannel.setStyle("-fx-background-color: #2c2c2c");
        ObservableList reports = FXCollections.observableArrayList();
        reports.addAll(
                "Report: fixing the tail's vertical stabilizer\nApproximate cost: 3000$"
        );
        ListView reportsList = new ListView(reports);
        reportsPannel.getChildren().add(reportsList);
        root.setLeft(reportsPannel);

        //initialisation de la barre inférieure des pourcentages et d'état
        GridPane statusTable = new GridPane();
        statusTable.setPadding(new Insets(0));
        statusTable.setHgap(10);
        statusTable.setVgap(5);
        String[] statusRowHeaders = {"Part", "Status"};
        String[][] statusData ={
                {"Fuselage", "Right Wing", "Left Wing", "Tail", "Right Engine", "Left Engine"},
                {"95%", "73%", "64%", "29%", "81%", "93%"}
        };
        for (int i = 0; i < statusData[0].length + 1; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(50);
            statusTable.getColumnConstraints().add(columnConstraints);
        }

        for (int i = 0; i < statusRowHeaders.length; i++) {
            Label statusLabel = new Label(statusRowHeaders[i]);
            statusLabel.setStyle("-fx-text-fill: #AAAAFF;");
            GridPane.setRowIndex(statusLabel, i);
            GridPane.setColumnIndex(statusLabel, 0);
            statusTable.getChildren().add(statusLabel);
            for (int j = 0; j < statusData[0].length; j++) {
                Label dataLabel = new Label(statusData[i][j]);
                dataLabel.setStyle("-fx-text-fill: #FFFFFF;");
                GridPane.setRowIndex(dataLabel, i);
                GridPane.setColumnIndex(dataLabel, j + 1);
                statusTable.getChildren().add(dataLabel);
            }
        }

        statusTable.setStyle("-fx-background-color: #2c2c2c;");
        root.setBottom(statusTable);


        //Création et affichage d'une scène
        Scene scene = new Scene(root, 1280, 960);
        stage.setTitle("Aircraft Monitoring System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}