package com.example.socialnetworkteo.database

import androidx.room.*
import com.example.socialnetworkteo.activities.EditUserActivity
import com.example.socialnetworkteo.models.User
import kotlinx.coroutines.Deferred

@Dao
interface UserDatabaseDao {
    @Insert(entity = User::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * from users_information WHERE id = :key")
    fun getId(key: Int): User?

    @Query("SELECT * from users_information")
    fun getAll(): List<User>

    @Query("SELECT * from users_information LIMIT 1")
    fun isEmpty(): User?

    @Delete
    suspend fun delete(user: User)
}