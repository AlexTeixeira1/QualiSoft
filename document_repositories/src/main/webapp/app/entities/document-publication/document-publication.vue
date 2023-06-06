<template>
  <div>
    <h2 id="page-heading" data-cy="DocumentPublicationHeading">
      <span v-text="$t('documentRepositoriesApp.documentPublication.home.title')" id="document-publication-heading"
        >Document Publications</span
      >
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('documentRepositoriesApp.documentPublication.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && documentPublications && documentPublications.length === 0">
      <span v-text="$t('documentRepositoriesApp.documentPublication.home.notFound')">No documentPublications found</span>
    </div>
    <div class="table-responsive" v-if="documentPublications && documentPublications.length > 0">
      <table class="table table-striped" aria-describedby="documentPublications">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('documentRepositoriesApp.documentPublication.name')">Name</span></th>
            <th scope="row"><span v-text="$t('documentRepositoriesApp.documentPublication.startDate')">Start Date</span></th>
            <th scope="row"><span v-text="$t('documentRepositoriesApp.documentPublication.endDate')">End Date</span></th>
            <th scope="row"><span v-text="$t('documentRepositoriesApp.documentPublication.documentId')">Document Id</span></th>
            <th scope="row"><span v-text="$t('documentRepositoriesApp.documentPublication.comment')">Comment</span></th>
            <th scope="row"><span v-text="$t('documentRepositoriesApp.documentPublication.status')">Status</span></th>
            <th scope="row"><span v-text="$t('documentRepositoriesApp.documentPublication.documentType')">Document Type</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="documentPublication in documentPublications" :key="documentPublication.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'DocumentPublicationView', params: { documentPublicationId: documentPublication.id } }">{{
                documentPublication.id
              }}</router-link>
            </td>
            <td>{{ documentPublication.name }}</td>
            <td>{{ documentPublication.startDate }}</td>
            <td>{{ documentPublication.endDate }}</td>
            <td>{{ documentPublication.documentId }}</td>
            <td>{{ documentPublication.comment }}</td>
            <td>{{ documentPublication.status }}</td>
            <td>{{ documentPublication.documentType }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'DocumentPublicationView', params: { documentPublicationId: documentPublication.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="documentRepositoriesApp.documentPublication.delete.question"
          data-cy="documentPublicationDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p
          id="jhi-delete-documentPublication-heading"
          v-text="$t('documentRepositoriesApp.documentPublication.delete.question', { id: removeId })"
        >
          Are you sure you want to delete this Document Publication?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-documentPublication"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeDocumentPublication()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./document-publication.component.ts"></script>
