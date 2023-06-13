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
                v-text="$t('documentRepositoriesApp.taskCreateDocument.name')"
                for="task-create-document-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-create-document-name"
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
                v-text="$t('documentRepositoriesApp.taskCreateDocument.startDate')"
                for="task-create-document-startDate"
                >Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-create-document-startDate"
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
                v-text="$t('documentRepositoriesApp.taskCreateDocument.endDate')"
                for="task-create-document-endDate"
                >End Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-create-document-endDate"
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
                v-text="$t('documentRepositoriesApp.taskCreateDocument.documentId')"
                for="task-create-document-documentId"
                >Document Id</label
              >
              <input
                type="text"
                class="form-control"
                name="documentId"
                id="task-create-document-documentId"
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
                v-text="$t('documentRepositoriesApp.taskCreateDocument.documentType')"
                for="task-create-document-documentType"
                >Document Type</label
              >
              <input
                type="text"
                class="form-control"
                name="documentType"
                id="task-create-document-documentType"
                data-cy="documentType"
                :class="{
                  valid: !$v.taskContext.documentPublicationProcess.documentPublication.documentType.$invalid,
                  invalid: $v.taskContext.documentPublicationProcess.documentPublication.documentType.$invalid,
                }"
                v-model="$v.taskContext.documentPublicationProcess.documentPublication.documentType.$model"
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

<script lang="ts" src="./task-create-document-execute.component.ts"></script>
