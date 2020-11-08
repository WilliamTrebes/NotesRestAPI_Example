package com.example.notesV2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/notes")
public class NotesController { 
	
		private CrudRepository repository;
		private NotesService notesService;
		
		public NotesController(RestRepo rr, NotesService notesService) {
			this.repository = rr;
			this.notesService = notesService;
		}
		
		//Mapping to get a list of all unarchived notes
		@GetMapping("/unarchived")
		public List<Note> getUnarchived() {
			return this.notesService.getAllUnarchivedNotes();
		} 
		
		//Mapping to get a list of all archived notes 
		@GetMapping("/archived")
		public List<Note> getArchived() {
			 return this.notesService.getAllArchivedNotes();
		} 
		
		
		// URL for Patch
		@PatchMapping("/{id}")
		//@pathVariable grabs id from URL 
		public ResponseEntity<Void> updateNoteById(@PathVariable(value = "id") Long noteId, @RequestBody Note note) {
 
			
			if (this.notesService.updateNoteById(noteId, note)) {
				
				return ResponseEntity.noContent().build();
			} 
			else {
				return ResponseEntity.notFound().build();
			}
			
		} 
		
		
		// Method will remove note from system 
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteNoteById(@PathVariable(value = "id") Long noteId) {
			this.notesService.deleteNote(noteId);
			return ResponseEntity.ok().build();
		}
		
		
		//Mapping to change the archive status of a given note
		@PutMapping("/archive/{id}")
		public ResponseEntity<Void> changeArchiveStatusById(@PathVariable(value = "id") Long noteId, @RequestBody ArchiveStatus archiveStatus) {
			
				if (this.notesService.changeArchiveStatus(noteId, archiveStatus.getArchiveStatus())) {

					return ResponseEntity.noContent().build();
				} 
				else {
					return ResponseEntity.notFound().build();
				}			
			}
		
		
		//Mapping to Save a new note
		@PutMapping 
		public ResponseEntity<Void> createNote(@RequestBody Note note) {
			
				this.notesService.saveNote(note);
				
				return ResponseEntity.ok().build();
		} 
					
			
		//Mapping for getting all notes
		@GetMapping
		public Iterable getAll() {
			
			return this.notesService.getAllNotes();
		}
		
		static class ArchiveStatus{
			private boolean archiveStatus;

			public boolean getArchiveStatus() {
				return archiveStatus;
			}
			public void setArchiveStatus(boolean value) {
				this.archiveStatus = value;
			}
		}
}
