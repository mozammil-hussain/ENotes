package com.enotes.dao;

import java.util.List;

import com.enotes.entity.Notes;
import com.enotes.entity.User;

public interface UserDao {
	
	public int saveUser(User user);
	
	public User login(String email,String password);
	
	public int saveNotes(Notes notes);
	
	public List<Notes> getNotesByUser(User user);
	
	public Notes getNotesById(int id);
	
	public void deleteNotes(int id);
	
	public void updateNotes(Notes n);
	

	
	

}
