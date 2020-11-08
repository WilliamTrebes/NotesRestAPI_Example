package com.example.notesV2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RestRepo extends CrudRepository<Note, Long> {

}
