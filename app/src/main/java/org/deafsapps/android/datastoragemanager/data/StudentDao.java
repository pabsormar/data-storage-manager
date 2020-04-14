package org.deafsapps.android.datastoragemanager.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(StudentEntity student);

    @Query("SELECT * FROM mdsd_students")
    List<StudentEntity> readAll();

}
