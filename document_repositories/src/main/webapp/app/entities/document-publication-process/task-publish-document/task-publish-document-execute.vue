<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('documentRepositoriesApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('documentRepositoriesApp.taskPublishDocument.name')"
                for="task-publish-document-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-publish-document-name"
                readonly
                data-cy="name"
                :class="{
                  valid: !$v.taskContext.documentPublicationProcess.documentPublication.name.$invalid,
                  invalid: $v.taskContext.documentPublicationProcess.documentPublication.name.$invalid,
                }"
                v-model="$v.taskContext.documentPublicationProcess.documentPublication.name.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('documentRepositoriesApp.taskPublishDocument.startDate')"
                for="task-publish-document-startDate"
                >Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-publish-document-startDate"
                  readonly
                  data-cy="startDate"
                  type="text"
                  class="form-control"
                  name="startDate"
                  :class="{
                    valid: !$v.taskContext.documentPublicationProcess.documentPublication.startDate.$invalid,
                    invalid: $v.taskContext.documentPublicationProcess.documentPublication.startDate.$invalid,
                  }"
                  v-model="$v.taskContext.documentPublicationProcess.documentPublication.startDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('documentRepositoriesApp.taskPublishDocument.endDate')"
                for="task-publish-document-endDate"
                >End Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-publish-document-endDate"
                  readonly
                  data-cy="endDate"
                  type="text"
                  class="form-control"
                  name="endDate"
                  :class="{
                    valid: !$v.taskContext.documentPublicationProcess.documentPublication.endDate.$invalid,
                    invalid: $v.taskContext.documentPublicationProcess.documentPublication.endDate.$invalid,
                  }"
                  v-model="$v.taskContext.documentPublicationProcess.documentPublication.endDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('documentRepositoriesApp.taskPublishDocument.documentId')"
                for="task-publish-document-documentId"
                >Document Id</label
              >
              <input
                type="text"
                class="form-control"
                name="documentId"
                id="task-publish-document-documentId"
                readonly
                data-cy="documentId"
                :class="{
                  valid: !$v.taskContext.documentPublicationProcess.documentPublication.documentId.$invalid,
                  invalid: $v.taskContext.documentPublicationProcess.documentPublication.documentId.$invalid,
                }"
                v-model="$v.taskContext.documentPublicationProcess.documentPublication.documentId.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('documentRepositoriesApp.taskPublishDocument.comment')"
                for="task-publish-document-comment"
                >Comment</label
              >
              <input
                type="text"
                class="form-control"
                name="comment"
                id="task-publish-document-comment"
                readonly
                data-cy="comment"
                :class="{
                  valid: !$v.taskContext.documentPublicationProcess.documentPublication.comment.$invalid,
                  invalid: $v.taskContext.documentPublicationProcess.documentPublication.comment.$invalid,
                }"
                v-model="$v.taskContext.documentPublicationProcess.documentPublication.comment.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('documentRepositoriesApp.taskPublishDocument.status')"
                for="task-publish-document-status"
                >Status</label
              >
              <input
                type="text"
                class="form-control"
                name="status"
                id="task-publish-document-status"
                readonly
                data-cy="status"
                :class="{
                  valid: !$v.taskContext.documentPublicationProcess.documentPublication.status.$invalid,
                  invalid: $v.taskContext.documentPublicationProcess.documentPublication.status.$invalid,
                }"
                v-model="$v.taskContext.documentPublicationProcess.documentPublication.status.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-publish-document-execute.component.ts"></script>
