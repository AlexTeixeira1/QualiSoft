import axios from 'axios';

import { IDocumentPublicationProcess } from '@/shared/model/document-publication-process.model';

const baseApiUrl = 'api/document-publication-processes';

export default class DocumentPublicationProcessService {
  public find(id: number): Promise<IDocumentPublicationProcess> {
    return new Promise<IDocumentPublicationProcess>((resolve, reject) => {
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

  public create(entity: IDocumentPublicationProcess): Promise<IDocumentPublicationProcess> {
    return new Promise<IDocumentPublicationProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
