package com.daniel1898.petproject;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class HelloController {
    public Pane Background;
    public Button generateButton;
    public Button sortButton;
    public Button pauseButton;
    public Button stopButton;
    @FXML
    private Label welcomeText;

    private ArrayList<SortingElement> elements = new ArrayList<>();

    public void onGenerateButtonClick(ActionEvent actionEvent) {
        ObservableList<Node> nodes = Background.getChildren();

        Random random = new Random();

        if (!elements.isEmpty()){
            nodes.removeAll(elements);
            elements.clear();
        }

        for (int i = 0; i < 50; i++) {
            int num = random.nextInt(200);
            SortingElement elem = new SortingElement(70+i*10,50,10, num);
            elements.add(elem);
            nodes.add(elem);
        }
        sortButton.setDisable(false);
    }

    public void onSortButtonClick(ActionEvent actionEvent) {
        sortButton.setDisable(true);
        pauseButton.setDisable(false);
        stopButton.setDisable(false);
        generateButton.setDisable(true);
        new Thread(() -> {
            try {
                SortingAghoritms.bubbleSortRun(elements).join();
                generateButton.setDisable(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void onSortPauseClick(ActionEvent actionEvent) {
        stopButton.setDisable(!stopButton.isDisable());
        SortingAghoritms.isPause.set(!SortingAghoritms.isPause.get());
    }

    public void onSortStopClick(ActionEvent actionEvent) {
        stopButton.setDisable(true);
        pauseButton.setDisable(true);
        sortButton.setDisable(false);
        SortingAghoritms.isStop.set(!SortingAghoritms.isStop.get());
    }
}