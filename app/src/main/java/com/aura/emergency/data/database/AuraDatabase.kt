package com.aura.emergency.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aura.emergency.data.dao.*
import com.aura.emergency.data.model.*
// TODO: Re-enable SQLCipher encryption
// import net.sqlcipher.database.SQLiteDatabase
// import net.sqlcipher.database.SupportFactory

@Database(
    entities = [
        Contact::class,
        AlertLog::class,
        LocationBreadcrumb::class,
        AuditLog::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AuraDatabase : RoomDatabase() {
    
    abstract fun contactDao(): ContactDao
    abstract fun alertLogDao(): AlertLogDao
    abstract fun locationBreadcrumbDao(): LocationBreadcrumbDao
    abstract fun auditLogDao(): AuditLogDao
    
    companion object {
        @Volatile
        private var INSTANCE: AuraDatabase? = null
        
        fun getDatabase(context: Context, passphrase: String): AuraDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = buildDatabase(context, passphrase)
                INSTANCE = instance
                instance
            }
        }
        
        private fun buildDatabase(context: Context, passphrase: String): AuraDatabase {
            // TODO: Re-enable SQLCipher encryption
            // Temporarily disabled for build - will add back encryption
            /* 
            // Initialize SQLCipher
            System.loadLibrary("sqlcipher")
            
            // Create passphrase for encryption
            val passphraseBytes = SQLiteDatabase.getBytes(passphrase.toCharArray())
            val factory = SupportFactory(passphraseBytes)
            */
            
            return Room.databaseBuilder(
                context.applicationContext,
                AuraDatabase::class.java,
                "aura_database.db"
            )
                // .openHelperFactory(factory)  // TODO: Re-enable with SQLCipher
                .fallbackToDestructiveMigration()
                .build()
        }
        
        fun closeDatabase() {
            INSTANCE?.close()
            INSTANCE = null
        }
    }
}
