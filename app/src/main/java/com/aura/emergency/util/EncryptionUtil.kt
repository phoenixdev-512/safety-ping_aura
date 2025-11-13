package com.aura.emergency.util

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.aead.AeadKeyTemplates
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

/**
 * Encryption utility using Google Tink for end-to-end encrypted SMS
 */
object EncryptionUtil {
    
    private const val KEYSTORE_ALIAS = "aura_master_key"
    private const val PREF_NAME = "aura_encryption_prefs"
    private const val KEYSET_NAME = "aura_keyset"
    private const val ANDROID_KEYSTORE = "AndroidKeyStore"
    
    init {
        // Initialize Tink
        AeadConfig.register()
    }
    
    /**
     * Get or create the AEAD primitive for encryption/decryption
     */
    fun getAead(context: Context): Aead {
        val keysetHandle = getOrCreateKeysetHandle(context)
        return keysetHandle.getPrimitive(Aead::class.java)
    }
    
    /**
     * Get or create keyset handle stored in encrypted shared preferences
     */
    private fun getOrCreateKeysetHandle(context: Context): KeysetHandle {
        return AndroidKeysetManager.Builder()
            .withSharedPref(context, KEYSET_NAME, PREF_NAME)
            .withKeyTemplate(AeadKeyTemplates.AES256_GCM)
            .withMasterKeyUri("android-keystore://$KEYSTORE_ALIAS")
            .build()
            .keysetHandle
    }
    
    /**
     * Encrypt data using Tink AEAD
     */
    fun encrypt(context: Context, plaintext: String, associatedData: String = ""): String {
        val aead = getAead(context)
        val ciphertext = aead.encrypt(
            plaintext.toByteArray(Charsets.UTF_8),
            associatedData.toByteArray(Charsets.UTF_8)
        )
        return Base64.encodeToString(ciphertext, Base64.NO_WRAP)
    }
    
    /**
     * Decrypt data using Tink AEAD
     */
    fun decrypt(context: Context, ciphertext: String, associatedData: String = ""): String {
        val aead = getAead(context)
        val ciphertextBytes = Base64.decode(ciphertext, Base64.NO_WRAP)
        val plaintext = aead.decrypt(
            ciphertextBytes,
            associatedData.toByteArray(Charsets.UTF_8)
        )
        return String(plaintext, Charsets.UTF_8)
    }
    
    /**
     * Generate a new encryption key pair for key exchange
     */
    fun generateKeyPair(): Pair<String, String> {
        // For simplicity, we're using symmetric encryption
        // In production, use asymmetric encryption (RSA/ECC)
        val keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM)
        
        // Export public key (in real implementation, use PublicKeySign/Verify)
        val publicKey = Base64.encodeToString(
            "PUBLIC_KEY_PLACEHOLDER".toByteArray(),
            Base64.NO_WRAP
        )
        val privateKey = Base64.encodeToString(
            "PRIVATE_KEY_PLACEHOLDER".toByteArray(),
            Base64.NO_WRAP
        )
        
        return Pair(publicKey, privateKey)
    }
    
    /**
     * Encrypt message for specific recipient using their public key
     */
    fun encryptForRecipient(
        context: Context,
        message: String,
        recipientPublicKey: String
    ): String {
        // In production, use the recipient's public key for encryption
        // For now, using symmetric encryption
        return encrypt(context, message, recipientPublicKey)
    }
    
    /**
     * Decrypt message from sender using their public key
     */
    fun decryptFromSender(
        context: Context,
        ciphertext: String,
        senderPublicKey: String
    ): String {
        // In production, use sender's public key for verification
        return decrypt(context, ciphertext, senderPublicKey)
    }
    
    /**
     * Generate database encryption passphrase
     */
    fun generateDatabasePassphrase(context: Context): String {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        var passphrase = prefs.getString("db_passphrase", null)
        
        if (passphrase == null) {
            // Generate new passphrase using Android Keystore
            passphrase = generateSecureRandom(32)
            prefs.edit().putString("db_passphrase", passphrase).apply()
        }
        
        return passphrase
    }
    
    /**
     * Generate cryptographically secure random string
     */
    private fun generateSecureRandom(length: Int): String {
        val random = java.security.SecureRandom()
        val bytes = ByteArray(length)
        random.nextBytes(bytes)
        return Base64.encodeToString(bytes, Base64.NO_WRAP)
    }
    
    /**
     * Get or create master key in Android Keystore
     */
    private fun getOrCreateMasterKey(): SecretKey {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE)
        keyStore.load(null)
        
        if (!keyStore.containsAlias(KEYSTORE_ALIAS)) {
            val keyGenerator = KeyGenerator.getInstance(
                KeyProperties.KEY_ALGORITHM_AES,
                ANDROID_KEYSTORE
            )
            
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                KEYSTORE_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setKeySize(256)
                .build()
            
            keyGenerator.init(keyGenParameterSpec)
            return keyGenerator.generateKey()
        }
        
        return keyStore.getKey(KEYSTORE_ALIAS, null) as SecretKey
    }
}
