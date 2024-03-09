package com.gabbar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabbar.entity.Notes;
import com.gabbar.entity.User;
import com.gabbar.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService
{
	@Autowired
	private NotesRepository np;

	@Override
	public Notes saveNotes(Notes notes) {
		
		return np.save(notes);
	}

	@Override
	public Notes getNotesById(int id) {
		
		return np.findById(id).get();
	}

	@Override
	public List<Notes> getNotesByUser(User user) {
		
		return np.findByUser(user);
	}

	@Override
	public Notes updateNotes(Notes notes) {
		
		return np.save(notes);
	}

	@Override
	public boolean deleteNotes(int id) {
		 Notes notes = np.findById(id).get();
		 if(notes != null)
		 {
			 np.delete(notes);
			 return true;
		 }
		
		return false;
	}

}
