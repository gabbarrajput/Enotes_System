package com.gabbar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabbar.entity.Notes;
import com.gabbar.entity.User;

public interface NotesRepository extends JpaRepository<Notes, Integer>
{
   public List<Notes> findByUser(User user);
}
