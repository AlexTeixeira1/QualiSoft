import axios from 'axios';
import { TaskReviewDocumentContext } from './task-review-document.model';

const baseApiUrl = 'api/document-publication-process/task-review-document';

export default class TaskReviewDocumentService {
  public loadContext(taskId: number): Promise<TaskReviewDocumentContext> {
    return new Promise<TaskReviewDocumentContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskReviewDocumentContext> {
    return new Promise<TaskReviewDocumentContext>((resolve, reject) => {
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

  public complete(taskReviewDocumentContext: TaskReviewDocumentContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskReviewDocumentContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
