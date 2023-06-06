import { Component, Vue, Inject } from 'vue-property-decorator';
import { IDocumentPublicationProcess } from '@/shared/model/document-publication-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import DocumentPublicationProcessService from './document-publication-process.service';

@Component
export default class DocumentPublicationProcessListComponent extends Vue {
  @Inject('documentPublicationProcessService') private documentPublicationProcessService: () => DocumentPublicationProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'DocumentPublicationProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public documentPublicationProcessList: IDocumentPublicationProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.documentPublicationProcessService()
      .retrieve()
      .then(
        res => {
          this.documentPublicationProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
