import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskReviewDocumentService from './task-review-document.service';
import { TaskReviewDocumentContext } from './task-review-document.model';

@Component
export default class TaskReviewDocumentDetailsComponent extends Vue {
  private taskReviewDocumentService: TaskReviewDocumentService = new TaskReviewDocumentService();
  private taskContext: TaskReviewDocumentContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskReviewDocumentService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
