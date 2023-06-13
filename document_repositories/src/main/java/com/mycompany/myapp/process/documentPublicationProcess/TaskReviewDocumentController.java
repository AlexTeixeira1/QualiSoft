package com.mycompany.myapp.process.documentPublicationProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document-publication-process/task-review-document")
public class TaskReviewDocumentController {

    private final Logger log = LoggerFactory.getLogger(TaskReviewDocumentController.class);

    private final TaskReviewDocumentService taskReviewDocumentService;

    public TaskReviewDocumentController(TaskReviewDocumentService taskReviewDocumentService) {
        this.taskReviewDocumentService = taskReviewDocumentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskReviewDocumentContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskReviewDocumentContextDTO taskReviewDocumentContext = taskReviewDocumentService.loadContext(id);
        return ResponseEntity.ok(taskReviewDocumentContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskReviewDocumentContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskReviewDocumentContextDTO taskReviewDocumentContext = taskReviewDocumentService.claim(id);
        return ResponseEntity.ok(taskReviewDocumentContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskReviewDocumentContextDTO taskReviewDocumentContext) {
        log.debug(
            "REST request to complete DocumentPublicationProcess.TaskReviewDocument {}",
            taskReviewDocumentContext.getTaskInstance().getId()
        );
        taskReviewDocumentService.complete(taskReviewDocumentContext);
        return ResponseEntity.noContent().build();
    }
}
