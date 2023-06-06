export interface IDocumentPublication {
  id?: number;
  name?: string | null;
  startDate?: Date | null;
  endDate?: Date | null;
  documentId?: string | null;
  comment?: string | null;
  status?: string | null;
  documentType?: string | null;
}

export class DocumentPublication implements IDocumentPublication {
  constructor(
    public id?: number,
    public name?: string | null,
    public startDate?: Date | null,
    public endDate?: Date | null,
    public documentId?: string | null,
    public comment?: string | null,
    public status?: string | null,
    public documentType?: string | null
  ) {}
}
