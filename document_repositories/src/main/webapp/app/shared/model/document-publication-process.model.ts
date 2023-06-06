import { IDocumentPublication } from '@/shared/model/document-publication.model';

export interface IDocumentPublicationProcess {
  id?: number;
  processInstance?: any | null;
  documentPublication?: IDocumentPublication | null;
}

export class DocumentPublicationProcess implements IDocumentPublicationProcess {
  constructor(public id?: number, public processInstance?: any | null, public documentPublication?: IDocumentPublication | null) {}
}
