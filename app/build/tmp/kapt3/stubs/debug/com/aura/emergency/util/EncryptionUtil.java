package com.aura.emergency.util;

/**
 * Encryption utility using Google Tink for end-to-end encrypted SMS
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004J\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/aura/emergency/util/EncryptionUtil;", "", "()V", "ANDROID_KEYSTORE", "", "KEYSET_NAME", "KEYSTORE_ALIAS", "PREF_NAME", "decrypt", "context", "Landroid/content/Context;", "ciphertext", "associatedData", "decryptFromSender", "senderPublicKey", "encrypt", "plaintext", "encryptForRecipient", "message", "recipientPublicKey", "generateDatabasePassphrase", "generateKeyPair", "Lkotlin/Pair;", "generateSecureRandom", "length", "", "getAead", "Lcom/google/crypto/tink/Aead;", "getOrCreateKeysetHandle", "Lcom/google/crypto/tink/KeysetHandle;", "getOrCreateMasterKey", "Ljavax/crypto/SecretKey;", "app_debug"})
public final class EncryptionUtil {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEYSTORE_ALIAS = "aura_master_key";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREF_NAME = "aura_encryption_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEYSET_NAME = "aura_keyset";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ANDROID_KEYSTORE = "AndroidKeyStore";
    @org.jetbrains.annotations.NotNull()
    public static final com.aura.emergency.util.EncryptionUtil INSTANCE = null;
    
    private EncryptionUtil() {
        super();
    }
    
    /**
     * Get or create the AEAD primitive for encryption/decryption
     */
    @org.jetbrains.annotations.NotNull()
    public final com.google.crypto.tink.Aead getAead(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * Get or create keyset handle stored in encrypted shared preferences
     */
    private final com.google.crypto.tink.KeysetHandle getOrCreateKeysetHandle(android.content.Context context) {
        return null;
    }
    
    /**
     * Encrypt data using Tink AEAD
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String encrypt(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String plaintext, @org.jetbrains.annotations.NotNull()
    java.lang.String associatedData) {
        return null;
    }
    
    /**
     * Decrypt data using Tink AEAD
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String decrypt(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String ciphertext, @org.jetbrains.annotations.NotNull()
    java.lang.String associatedData) {
        return null;
    }
    
    /**
     * Generate a new encryption key pair for key exchange
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.String, java.lang.String> generateKeyPair() {
        return null;
    }
    
    /**
     * Encrypt message for specific recipient using their public key
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String encryptForRecipient(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String recipientPublicKey) {
        return null;
    }
    
    /**
     * Decrypt message from sender using their public key
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String decryptFromSender(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String ciphertext, @org.jetbrains.annotations.NotNull()
    java.lang.String senderPublicKey) {
        return null;
    }
    
    /**
     * Generate database encryption passphrase
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateDatabasePassphrase(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * Generate cryptographically secure random string
     */
    private final java.lang.String generateSecureRandom(int length) {
        return null;
    }
    
    /**
     * Get or create master key in Android Keystore
     */
    private final javax.crypto.SecretKey getOrCreateMasterKey() {
        return null;
    }
}