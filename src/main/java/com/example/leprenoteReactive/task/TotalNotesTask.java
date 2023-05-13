package com.example.leprenoteReactive.task;

import com.example.leprenoteReactive.domain.Notes;
import com.example.leprenoteReactive.service.LepreNotesService;
import io.reactivex.functions.Consumer;
import javafx.concurrent.Task;
import javafx.scene.control.TextArea;


public class TotalNotesTask extends Task<Integer> {
    private LepreNotesService service;
    private Consumer<Notes> dep;
    public TotalNotesTask (Consumer<Notes> dep){
        this.dep = dep;

    }
    @Override
    protected Integer call() throws Exception {

        service = new LepreNotesService();
        service.getTotalNotes().subscribe(dep);
        return null;
    }
}
