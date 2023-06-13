import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskReviewDocumentService from './task-review-document.service';
import { TaskReviewDocumentContext } from './task-review-document.model';

const validations: any = {
  taskContext: {
    documentPublicationProcess: {
      documentPublication: {
        name: {},
        startDate: {},
        endDate: {},
        documentId: {},
        comment: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskReviewDocumentExecuteComponent extends Vue {
  private taskReviewDocumentService: TaskReviewDocumentService = new TaskReviewDocumentService();
  private taskContext: TaskReviewDocumentContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskReviewDocumentService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskReviewDocumentService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
