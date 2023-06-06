import axios from 'axios';

import { IDocumentPublication } from '@/shared/model/document-publication.model';

const baseApiUrl = 'api/document-publications';

export default class DocumentPublicationService {
  public find(id: number): Promise<IDocumentPublication> {
    return new Promise<IDocumentPublication>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
