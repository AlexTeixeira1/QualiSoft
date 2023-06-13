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
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskCreateDocument.name')">name</label>
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
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskCreateDocument.startDate')">startDate</label>
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
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskCreateDocument.endDate')">endDate</label>
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
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskCreateDocument.documentId')">documentId</label>
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
              <label class="form-control-label" v-text="$t('documentRepositoriesApp.taskCreateDocument.documentType')">documentType</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="documentType"
                id="document-publication-documentType"
                data-cy="documentType"
                v-model="taskContext.documentPublicationProcess.documentPublication.documentType"
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
          :to="`/process-definition/DocumentPublicationProcess/task/TaskCreateDocument/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-create-document-details.component.ts"></script>
