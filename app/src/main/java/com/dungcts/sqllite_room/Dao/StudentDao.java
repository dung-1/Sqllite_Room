package com.dungcts.sqllite_room.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Update;
import androidx.room.Insert;
import androidx.room.Query;

import com.dungcts.sqllite_room.Entity.Student;

import java.util.List;

@Dao
public interface  StudentDao {

    @Query("SELECT * FROM Student")
    List<Student> getAll();

    @Query("SELECT * FROM Student WHERE id IN (:userIds)")
    List<Student> loadAllByIds(int[] userIds);

    @Query("DELETE FROM Student")
    void deleteAllCourses();

    @Query("SELECT * FROM Student WHERE email LIKE :first AND " +
            "password LIKE :last LIMIT 1")
    Student findByName(String first, String last);

    @Query("SELECT * FROM Student ORDER BY email ASC")
    LiveData<List<Student>> getAllCourses();

    @Insert
    void insertAll(Student... student);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);

}
