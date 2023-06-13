import axios from 'axios';
import { TaskCreateDocumentContext } from './task-create-document.model';

const baseApiUrl = 'api/document-publication-process/task-create-document';

export default class TaskCreateDocumentService {
  public loadContext(taskId: number): Promise<TaskCreateDocumentContext> {
    return new Promise<TaskCreateDocumentContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskCreateDocumentContext> {
    return new Promise<TaskCreateDocumentContext>((resolve, reject) => {
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

  public complete(taskCreateDocumentContext: TaskCreateDocumentContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskCreateDocumentContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
