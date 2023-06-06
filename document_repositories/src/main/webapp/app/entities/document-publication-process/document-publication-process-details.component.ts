import { Component, Vue, Inject } from 'vue-property-decorator';

import { IDocumentPublicationProcess } from '@/shared/model/document-publication-process.model';
import DocumentPublicationProcessService from './document-publication-process.service';

@Component
export default class DocumentPublicationProcessDetailsComponent extends Vue {
  @Inject('documentPublicationProcessService') private documentPublicationProcessService: () => DocumentPublicationProcessService;
  public documentPublicationProcess: IDocumentPublicationProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveDocumentPublicationProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveDocumentPublicationProcess(documentPublicationProcessId) {
    this.isFetching = true;
    this.documentPublicationProcessService()
      .find(documentPublicationProcessId)
      .then(
        res => {
          this.documentPublicationProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
