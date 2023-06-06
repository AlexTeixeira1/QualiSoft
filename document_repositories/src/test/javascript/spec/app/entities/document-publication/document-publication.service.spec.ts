/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import DocumentPublicationService from '@/entities/document-publication/document-publication.service';
import { DocumentPublication } from '@/shared/model/document-publication.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('DocumentPublication Service', () => {
    let service: DocumentPublicationService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new DocumentPublicationService();
      currentDate = new Date();
      elemDefault = new DocumentPublication(0, 'AAAAAAA', currentDate, currentDate, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            startDate: dayjs(currentDate).format(DATE_FORMAT),
            endDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of DocumentPublication', async () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            startDate: dayjs(currentDate).format(DATE_FORMAT),
            endDate: dayjs(currentDate).format(DATE_FORMAT),
            documentId: 'BBBBBB',
            comment: 'BBBBBB',
            status: 'BBBBBB',
            documentType: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            startDate: currentDate,
            endDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of DocumentPublication', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
