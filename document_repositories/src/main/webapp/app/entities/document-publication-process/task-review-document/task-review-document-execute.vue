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
                v-text="$t('documentRepositoriesApp.taskReviewDocument.name')"
                for="task-review-document-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-review-document-name"
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
                v-text="$t('documentRepositoriesApp.taskReviewDocument.startDate')"
                for="task-review-document-startDate"
                >Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-review-document-startDate"
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
                v-text="$t('documentRepositoriesApp.taskReviewDocument.endDate')"
                for="task-review-document-endDate"
                >End Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-review-document-endDate"
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
                v-text="$t('documentRepositoriesApp.taskReviewDocument.documentId')"
                for="task-review-document-documentId"
                >Document Id</label
              >
              <input
                type="text"
                class="form-control"
                name="documentId"
                id="task-review-document-documentId"
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
                v-text="$t('documentRepositoriesApp.taskReviewDocument.comment')"
                for="task-review-document-comment"
                >Comment</label
              >
              <input
                type="text"
                class="form-control"
                name="comment"
                id="task-review-document-comment"
                data-cy="comment"
                :class="{
                  valid: !$v.taskContext.documentPublicationProcess.documentPublication.comment.$invalid,
                  invalid: $v.taskContext.documentPublicationProcess.documentPublication.comment.$invalid,
                }"
                v-model="$v.taskContext.documentPublicationProcess.documentPublication.comment.$model"
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

<script lang="ts" src="./task-review-document-execute.component.ts"></script>
