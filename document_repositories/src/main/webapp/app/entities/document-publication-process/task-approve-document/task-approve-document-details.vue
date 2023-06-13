<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('documentRepositoriesApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskApproveDocument.name')">name</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="name"
                id="document-publication-name"
                data-cy="name"
                v-model="taskContext.documentPublicationProcess.documentPublication.name"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskApproveDocument.startDate')">startDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="startDate"
                id="document-publication-startDate"
                data-cy="startDate"
                v-model="taskContext.documentPublicationProcess.documentPublication.startDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskApproveDocument.endDate')">endDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="endDate"
                id="document-publication-endDate"
                data-cy="endDate"
                v-model="taskContext.documentPublicationProcess.documentPublication.endDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskApproveDocument.documentId')">documentId</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="documentId"
                id="document-publication-documentId"
                data-cy="documentId"
                v-model="taskContext.documentPublicationProcess.documentPublication.documentId"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskApproveDocument.comment')">comment</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="comment"
                id="document-publication-comment"
                data-cy="comment"
                v-model="taskContext.documentPublicationProcess.documentPublication.comment"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskApproveDocument.status')">status</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="status"
                id="document-publication-status"
                data-cy="status"
                v-model="taskContext.documentPublicationProcess.documentPublication.status"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/DocumentPublicationProcess/task/TaskApproveDocument/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-approve-document-details.component.ts"></script>
