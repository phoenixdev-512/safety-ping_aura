package com.aura.emergency.data.dao

import androidx.room.*
import com.aura.emergency.data.model.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    
    @Query("SELECT * FROM contacts ORDER BY level ASC, name ASC")
    fun getAllContacts(): Flow<List<Contact>>
    
    @Query("SELECT * FROM contacts WHERE id = :id")
    suspend fun getContactById(id: Int): Contact?
    
    @Query("SELECT * FROM contacts WHERE level = :level ORDER BY name ASC")
    fun getContactsByLevel(level: Int): Flow<List<Contact>>
    
    @Query("SELECT * FROM contacts WHERE hasApp = 1 AND verified = 1")
    fun getEncryptedContacts(): Flow<List<Contact>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: Contact): Long
    
    @Update
    suspend fun updateContact(contact: Contact)
    
    @Delete
    suspend fun deleteContact(contact: Contact)
    
    @Query("UPDATE contacts SET lastAlertSentAt = :timestamp, alertsSentCount = alertsSentCount + 1 WHERE id = :contactId")
    suspend fun recordAlertSent(contactId: Int, timestamp: Long)
    
    @Query("UPDATE contacts SET publicKey = :publicKey, verified = :verified, hasApp = 1 WHERE id = :contactId")
    suspend fun updateEncryptionStatus(contactId: Int, publicKey: String, verified: Boolean)
    
    @Query("SELECT COUNT(*) FROM contacts")
    suspend fun getContactCount(): Int
}
