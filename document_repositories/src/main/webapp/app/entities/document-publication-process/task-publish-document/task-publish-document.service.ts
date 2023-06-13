import axios from 'axios';
import { TaskPublishDocumentContext } from './task-publish-document.model';

const baseApiUrl = 'api/document-publication-process/task-publish-document';

export default class TaskPublishDocumentService {
  public loadContext(taskId: number): Promise<TaskPublishDocumentContext> {
    return new Promise<TaskPublishDocumentContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskPublishDocumentContext> {
    return new Promise<TaskPublishDocumentContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskPublishDocumentContext: TaskPublishDocumentContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskPublishDocumentContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
