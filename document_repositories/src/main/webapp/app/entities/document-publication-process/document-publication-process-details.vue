<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="documentPublicationProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="documentPublicationProcessDetailsHeading">
          <span v-text="$t('documentRepositoriesApp.documentPublicationProcess.detail.title')">DocumentPublicationProcess</span>
          {{ documentPublicationProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="documentPublicationProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('documentRepositoriesApp.documentPublicationProcess.detail.title')">DocumentPublicationProcess</span> #{{
              documentPublicationProcess.id
            }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="documentPublicationProcess.documentPublication">
              <h5 class="card-header">
                <span class="title"> Document Publication #{{ documentPublicationProcess.documentPublication.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('documentRepositoriesApp.documentPublicationProcess.name')">name</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="name"
                    id="document-publication-name"
                    data-cy="name"
                    v-model="documentPublicationProcess.documentPublication.name"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('documentRepositoriesApp.documentPublicationProcess.startDate')"
                    >startDate</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="startDate"
                    id="document-publication-startDate"
                    data-cy="startDate"
                    v-model="documentPublicationProcess.documentPublication.startDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('documentRepositoriesApp.documentPublicationProcess.endDate')"
                    >endDate</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="endDate"
                    id="document-publication-endDate"
                    data-cy="endDate"
                    v-model="documentPublicationProcess.documentPublication.endDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('documentRepositoriesApp.documentPublicationProcess.documentId')"
                    >documentId</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="documentId"
                    id="document-publication-documentId"
                    data-cy="documentId"
                    v-model="documentPublicationProcess.documentPublication.documentId"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('documentRepositoriesApp.documentPublicationProcess.comment')"
                    >comment</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="comment"
                    id="document-publication-comment"
                    data-cy="comment"
                    v-model="documentPublicationProcess.documentPublication.comment"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('documentRepositoriesApp.documentPublicationProcess.status')">status</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="status"
                    id="document-publication-status"
                    data-cy="status"
                    v-model="documentPublicationProcess.documentPublication.status"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('documentRepositoriesApp.documentPublicationProcess.documentType')"
                    >documentType</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="documentType"
                    id="document-publication-documentType"
                    data-cy="documentType"
                    v-model="documentPublicationProcess.documentPublication.documentType"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./document-publication-process-details.component.ts"></script>
