package com.example.leprenoteReactive.controller;

import com.example.leprenoteReactive.domain.Notes;
import com.example.leprenoteReactive.domain.Reviews;
import com.example.leprenoteReactive.task.TotalNotesTask;
import com.example.leprenoteReactive.task.TotalReviewsTask;
import io.reactivex.functions.Consumer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private Button butLoad, buttonReviews;
    @FXML
    private TextArea textArea;

    @FXML
    public ObservableList<Notes> notesObservableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void loadNotes(ActionEvent actionEvent) {
        textArea.clear();
        StringBuilder sb = new StringBuilder();
        Consumer<Notes> dep = (info) -> {
            textArea.setText(textArea.getText() + info.getTitle()+"\n");
        };

        TotalNotesTask totalNotesTask = new TotalNotesTask(dep);
        new Thread(totalNotesTask).start();
    }

    public void listReviews (ActionEvent actionEvent){
        textArea.clear();
        StringBuilder sb = new StringBuilder();
        Consumer<Reviews> dep = (info) -> {
            textArea.setText(textArea.getText() + info.getDescription()+"\n");
        };

        TotalReviewsTask totalReviewsTask = new TotalReviewsTask(dep);
        new Thread(totalReviewsTask).start();
    }
}
