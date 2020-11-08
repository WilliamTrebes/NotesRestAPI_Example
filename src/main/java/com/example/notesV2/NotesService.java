package com.example.notesV2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
	private CrudRepository repository;

	public NotesService(RestRepo rr) {
		this.repository = rr;
	}
	public List<Note> getAllUnarchivedNotes(){
		//Create Iterator for the database
		 Iterator<Note> noteIterator = getAllNotes().iterator();
		 return getSpecificNotesType(noteIterator, false);
	}
	public List<Note> getAllArchivedNotes(){
		//Create Iterator for the database
		 Iterator<Note> noteIterator = getAllNotes().iterator();
		 
		 return getSpecificNotesType(noteIterator, true);
	}
	public Iterable getAllNotes(){
		
		return this.repository.findAll();
	}
	public List<Note> getSpecificNotesType(Iterator<Note> iterator, boolean isArchived){
		List<Note> notes = new ArrayList();
		 
		 //While values in array append un-archived notes to return list
		 while (iterator.hasNext()) {
			 Note temp = iterator.next();
			 if (temp.getIsArchived() == isArchived) {
				 notes.add(temp);
			 }
		 }
		return notes;
	}
	
	
	public void saveNote(Note note) {
		this.repository.save(note);
	}
	
	
	public void deleteNote(Long id) {
		this.repository.deleteById(id);
	}
	
	
	
	public Optional<Note> findNoteById(Long id) {
		return this.repository.findById(id);
	}
	
	
	public boolean changeArchiveStatus(Long id, boolean status) {
		Optional<Note> targetNote = this.findNoteById(id);
		if (targetNote.isPresent()) {
			Note temp = targetNote.get();
			temp.setIsArchived(status);
			
			this.saveNote(temp);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean updateNoteById(Long noteId, Note note) {

		Optional<Note> targetNote = this.findNoteById(noteId);
		if (targetNote.isPresent()) {
			Note temp = targetNote.get();
			if (!temp.getName().equals(note.getName())) {
				temp.setName(note.getName());
			}
			if (!temp.getInfo().equals(note.getInfo())) {
				temp.setInfo(note.getInfo());
			}
			if (!temp.getIsArchived() == (note.getIsArchived())) {
				temp.setIsArchived(note.getIsArchived());
			}
			this.saveNote(temp);
			return true;
		}
		else {
			return false; 
		}
	}
}
