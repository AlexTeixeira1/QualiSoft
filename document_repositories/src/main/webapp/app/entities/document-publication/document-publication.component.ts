import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IDocumentPublication } from '@/shared/model/document-publication.model';

import DocumentPublicationService from './document-publication.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class DocumentPublication extends Vue {
  @Inject('documentPublicationService') private documentPublicationService: () => DocumentPublicationService;
  private removeId: number = null;

  public documentPublications: IDocumentPublication[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllDocumentPublications();
  }

  public clear(): void {
    this.retrieveAllDocumentPublications();
  }

  public retrieveAllDocumentPublications(): void {
    this.isFetching = true;

    this.documentPublicationService()
      .retrieve()
      .then(
        res => {
          this.documentPublications = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
