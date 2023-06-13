import axios from 'axios';
import { TaskApproveDocumentContext } from './task-approve-document.model';

const baseApiUrl = 'api/document-publication-process/task-approve-document';

export default class TaskApproveDocumentService {
  public loadContext(taskId: number): Promise<TaskApproveDocumentContext> {
    return new Promise<TaskApproveDocumentContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskApproveDocumentContext> {
    return new Promise<TaskApproveDocumentContext>((resolve, reject) => {
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

  public complete(taskApproveDocumentContext: TaskApproveDocumentContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskApproveDocumentContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
