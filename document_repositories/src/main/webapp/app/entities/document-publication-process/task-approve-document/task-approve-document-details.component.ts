import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskApproveDocumentService from './task-approve-document.service';
import { TaskApproveDocumentContext } from './task-approve-document.model';

@Component
export default class TaskApproveDocumentDetailsComponent extends Vue {
  private taskApproveDocumentService: TaskApproveDocumentService = new TaskApproveDocumentService();
  private taskContext: TaskApproveDocumentContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskApproveDocumentService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
