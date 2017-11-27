package com.vajasoft.musicsheet;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MusicSheet extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Sheet.fxml"));
        Pane root = createSheet("Sheet_1", 8, 4);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Music Sheet");
        stage.getIcons().add(new Image("/img/app-icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    Pane createSheet(String id, int nbrOfVerses, int nbrOfBars) {
        VBox root = new VBox(32);
        root.setPrefHeight(891);
        root.setPrefWidth(630);
        root.setPadding(new Insets(48, 12, 12, 12));
        root.setId(id);
        for (int i = 0; i < nbrOfVerses; i++) {
            root.getChildren().add(createVerse(id + "_Verse_" + i, nbrOfBars));
        }
        return root;
    }

    Node createVerse(String id, int nbrOfBars) {
        StackPane verse = new StackPane();
        verse.getStyleClass().add("music-sheet-bckgrnd");
        
        HBox bars = new HBox();
        bars.setPrefHeight(46);
        bars.setMaxHeight(Region.USE_PREF_SIZE);
        bars.setPadding(new Insets(0, 0, 0, 32));
        for (int i = 0; i < nbrOfBars; i++) {
            bars.getChildren().add(createBar(id + "_Bar_" + i));
        }
        
        HBox key = new HBox();
        Pane gKey = new Pane();
        gKey.setPrefHeight(72);
        gKey.setPrefWidth(31);
        gKey.getStyleClass().add("music-sheet-g-key");
        key.getChildren().add(gKey);
        HBox.setHgrow(gKey, Priority.NEVER);
        
        verse.getChildren().addAll(bars, key);
        verse.setId(id);
        return verse;
    }

    Node createBar(String id) {
        HBox bar = new HBox();
        bar.getStyleClass().add("music-sheet-bar");
        HBox.setHgrow(bar, Priority.ALWAYS);
        bar.setId(id);
        return bar;
    }
}
