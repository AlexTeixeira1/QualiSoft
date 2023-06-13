import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskApproveDocumentService from './task-approve-document.service';
import { TaskApproveDocumentContext } from './task-approve-document.model';

const validations: any = {
  taskContext: {
    documentPublicationProcess: {
      documentPublication: {
        name: {},
        startDate: {},
        endDate: {},
        documentId: {},
        comment: {},
        status: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskApproveDocumentExecuteComponent extends Vue {
  private taskApproveDocumentService: TaskApproveDocumentService = new TaskApproveDocumentService();
  private taskContext: TaskApproveDocumentContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskApproveDocumentService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskApproveDocumentService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
