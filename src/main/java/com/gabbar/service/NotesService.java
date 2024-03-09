package com.gabbar.service;

import java.util.List;

import com.gabbar.entity.Notes;
import com.gabbar.entity.User;

public interface NotesService 
{
   public Notes saveNotes (Notes notes);
   
   public Notes getNotesById(int id);
   
   public List<Notes> getNotesByUser(User user);
   
   public Notes updateNotes(Notes notes);
   
   public boolean deleteNotes(int id);
}
