package com.example.socialnetworkteo.database

import androidx.room.*
import com.example.socialnetworkteo.models.User

@Dao
interface UserDatabaseDao {
    @Insert(entity = User::class, onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query("SELECT * from users_information WHERE id = :key")
    fun get(key: Int): User?

    @Query("SELECT * from users_information")
    fun getAll(): List<User>

    @Query("SELECT * from users_information LIMIT 1")
    fun isEmpty(): User?

    @Delete
    fun delete(user: User)
}