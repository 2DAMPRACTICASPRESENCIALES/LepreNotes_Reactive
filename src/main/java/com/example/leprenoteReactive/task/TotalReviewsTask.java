package com.example.leprenoteReactive.task;

import com.example.leprenoteReactive.domain.Notes;
import com.example.leprenoteReactive.domain.Reviews;
import com.example.leprenoteReactive.service.LepreNotesService;
import io.reactivex.functions.Consumer;
import javafx.concurrent.Task;

public class TotalReviewsTask extends Task<Integer>
{

    private LepreNotesService service;
    private Consumer<Reviews> dep;
    public TotalReviewsTask (Consumer<Reviews> dep){
        this.dep = dep;

    }
    @Override
    protected Integer call() throws Exception {
        service = new LepreNotesService();
        service.getTotalReviews().subscribe(dep);
        return null;
    }
}
