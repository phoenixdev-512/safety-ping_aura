package com.aura.emergency.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0011\u001a\u00020\fH\'J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0014H\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J&\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u00a7@\u00a2\u0006\u0002\u0010\u001f\u00a8\u0006 "}, d2 = {"Lcom/aura/emergency/data/dao/ContactDao;", "", "deleteContact", "", "contact", "Lcom/aura/emergency/data/model/Contact;", "(Lcom/aura/emergency/data/model/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllContacts", "Lkotlinx/coroutines/flow/Flow;", "", "getContactById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactsByLevel", "level", "getEncryptedContacts", "insertContact", "", "recordAlertSent", "contactId", "timestamp", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateContact", "updateEncryptionStatus", "publicKey", "", "verified", "", "(ILjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ContactDao {
    
    @androidx.room.Query(value = "SELECT * FROM contacts ORDER BY level ASC, name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.aura.emergency.data.model.Contact>> getAllContacts();
    
    @androidx.room.Query(value = "SELECT * FROM contacts WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getContactById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.aura.emergency.data.model.Contact> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM contacts WHERE level = :level ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.aura.emergency.data.model.Contact>> getContactsByLevel(int level);
    
    @androidx.room.Query(value = "SELECT * FROM contacts WHERE hasApp = 1 AND verified = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.aura.emergency.data.model.Contact>> getEncryptedContacts();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertContact(@org.jetbrains.annotations.NotNull()
    com.aura.emergency.data.model.Contact contact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateContact(@org.jetbrains.annotations.NotNull()
    com.aura.emergency.data.model.Contact contact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteContact(@org.jetbrains.annotations.NotNull()
    com.aura.emergency.data.model.Contact contact, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE contacts SET lastAlertSentAt = :timestamp, alertsSentCount = alertsSentCount + 1 WHERE id = :contactId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object recordAlertSent(int contactId, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE contacts SET publicKey = :publicKey, verified = :verified, hasApp = 1 WHERE id = :contactId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateEncryptionStatus(int contactId, @org.jetbrains.annotations.NotNull()
    java.lang.String publicKey, boolean verified, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM contacts")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getContactCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}