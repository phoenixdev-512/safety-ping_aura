package com.aura.emergency.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.aura.emergency.data.model.Contact;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ContactDao_Impl implements ContactDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Contact> __insertionAdapterOfContact;

  private final EntityDeletionOrUpdateAdapter<Contact> __deletionAdapterOfContact;

  private final EntityDeletionOrUpdateAdapter<Contact> __updateAdapterOfContact;

  private final SharedSQLiteStatement __preparedStmtOfRecordAlertSent;

  private final SharedSQLiteStatement __preparedStmtOfUpdateEncryptionStatus;

  public ContactDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContact = new EntityInsertionAdapter<Contact>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `contacts` (`id`,`name`,`phoneNumber`,`photoUri`,`level`,`hasApp`,`publicKey`,`verified`,`createdAt`,`lastAlertSentAt`,`alertsSentCount`,`verificationQrCode`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Contact entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhoneNumber());
        }
        if (entity.getPhotoUri() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhotoUri());
        }
        statement.bindLong(5, entity.getLevel());
        final int _tmp = entity.getHasApp() ? 1 : 0;
        statement.bindLong(6, _tmp);
        if (entity.getPublicKey() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPublicKey());
        }
        final int _tmp_1 = entity.getVerified() ? 1 : 0;
        statement.bindLong(8, _tmp_1);
        statement.bindLong(9, entity.getCreatedAt());
        if (entity.getLastAlertSentAt() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getLastAlertSentAt());
        }
        statement.bindLong(11, entity.getAlertsSentCount());
        if (entity.getVerificationQrCode() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getVerificationQrCode());
        }
      }
    };
    this.__deletionAdapterOfContact = new EntityDeletionOrUpdateAdapter<Contact>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `contacts` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Contact entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfContact = new EntityDeletionOrUpdateAdapter<Contact>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `contacts` SET `id` = ?,`name` = ?,`phoneNumber` = ?,`photoUri` = ?,`level` = ?,`hasApp` = ?,`publicKey` = ?,`verified` = ?,`createdAt` = ?,`lastAlertSentAt` = ?,`alertsSentCount` = ?,`verificationQrCode` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Contact entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhoneNumber());
        }
        if (entity.getPhotoUri() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhotoUri());
        }
        statement.bindLong(5, entity.getLevel());
        final int _tmp = entity.getHasApp() ? 1 : 0;
        statement.bindLong(6, _tmp);
        if (entity.getPublicKey() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPublicKey());
        }
        final int _tmp_1 = entity.getVerified() ? 1 : 0;
        statement.bindLong(8, _tmp_1);
        statement.bindLong(9, entity.getCreatedAt());
        if (entity.getLastAlertSentAt() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getLastAlertSentAt());
        }
        statement.bindLong(11, entity.getAlertsSentCount());
        if (entity.getVerificationQrCode() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getVerificationQrCode());
        }
        statement.bindLong(13, entity.getId());
      }
    };
    this.__preparedStmtOfRecordAlertSent = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE contacts SET lastAlertSentAt = ?, alertsSentCount = alertsSentCount + 1 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateEncryptionStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE contacts SET publicKey = ?, verified = ?, hasApp = 1 WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertContact(final Contact contact, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfContact.insertAndReturnId(contact);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteContact(final Contact contact, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfContact.handle(contact);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateContact(final Contact contact, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfContact.handle(contact);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object recordAlertSent(final int contactId, final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRecordAlertSent.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, timestamp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, contactId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfRecordAlertSent.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateEncryptionStatus(final int contactId, final String publicKey,
      final boolean verified, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateEncryptionStatus.acquire();
        int _argIndex = 1;
        if (publicKey == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, publicKey);
        }
        _argIndex = 2;
        final int _tmp = verified ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, contactId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateEncryptionStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Contact>> getAllContacts() {
    final String _sql = "SELECT * FROM contacts ORDER BY level ASC, name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"contacts"}, new Callable<List<Contact>>() {
      @Override
      @NonNull
      public List<Contact> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfPhotoUri = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUri");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfHasApp = CursorUtil.getColumnIndexOrThrow(_cursor, "hasApp");
          final int _cursorIndexOfPublicKey = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKey");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "verified");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastAlertSentAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastAlertSentAt");
          final int _cursorIndexOfAlertsSentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "alertsSentCount");
          final int _cursorIndexOfVerificationQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "verificationQrCode");
          final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Contact _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpPhotoUri;
            if (_cursor.isNull(_cursorIndexOfPhotoUri)) {
              _tmpPhotoUri = null;
            } else {
              _tmpPhotoUri = _cursor.getString(_cursorIndexOfPhotoUri);
            }
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final boolean _tmpHasApp;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfHasApp);
            _tmpHasApp = _tmp != 0;
            final String _tmpPublicKey;
            if (_cursor.isNull(_cursorIndexOfPublicKey)) {
              _tmpPublicKey = null;
            } else {
              _tmpPublicKey = _cursor.getString(_cursorIndexOfPublicKey);
            }
            final boolean _tmpVerified;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfVerified);
            _tmpVerified = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpLastAlertSentAt;
            if (_cursor.isNull(_cursorIndexOfLastAlertSentAt)) {
              _tmpLastAlertSentAt = null;
            } else {
              _tmpLastAlertSentAt = _cursor.getLong(_cursorIndexOfLastAlertSentAt);
            }
            final int _tmpAlertsSentCount;
            _tmpAlertsSentCount = _cursor.getInt(_cursorIndexOfAlertsSentCount);
            final String _tmpVerificationQrCode;
            if (_cursor.isNull(_cursorIndexOfVerificationQrCode)) {
              _tmpVerificationQrCode = null;
            } else {
              _tmpVerificationQrCode = _cursor.getString(_cursorIndexOfVerificationQrCode);
            }
            _item = new Contact(_tmpId,_tmpName,_tmpPhoneNumber,_tmpPhotoUri,_tmpLevel,_tmpHasApp,_tmpPublicKey,_tmpVerified,_tmpCreatedAt,_tmpLastAlertSentAt,_tmpAlertsSentCount,_tmpVerificationQrCode);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getContactById(final int id, final Continuation<? super Contact> $completion) {
    final String _sql = "SELECT * FROM contacts WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Contact>() {
      @Override
      @Nullable
      public Contact call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfPhotoUri = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUri");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfHasApp = CursorUtil.getColumnIndexOrThrow(_cursor, "hasApp");
          final int _cursorIndexOfPublicKey = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKey");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "verified");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastAlertSentAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastAlertSentAt");
          final int _cursorIndexOfAlertsSentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "alertsSentCount");
          final int _cursorIndexOfVerificationQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "verificationQrCode");
          final Contact _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpPhotoUri;
            if (_cursor.isNull(_cursorIndexOfPhotoUri)) {
              _tmpPhotoUri = null;
            } else {
              _tmpPhotoUri = _cursor.getString(_cursorIndexOfPhotoUri);
            }
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final boolean _tmpHasApp;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfHasApp);
            _tmpHasApp = _tmp != 0;
            final String _tmpPublicKey;
            if (_cursor.isNull(_cursorIndexOfPublicKey)) {
              _tmpPublicKey = null;
            } else {
              _tmpPublicKey = _cursor.getString(_cursorIndexOfPublicKey);
            }
            final boolean _tmpVerified;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfVerified);
            _tmpVerified = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpLastAlertSentAt;
            if (_cursor.isNull(_cursorIndexOfLastAlertSentAt)) {
              _tmpLastAlertSentAt = null;
            } else {
              _tmpLastAlertSentAt = _cursor.getLong(_cursorIndexOfLastAlertSentAt);
            }
            final int _tmpAlertsSentCount;
            _tmpAlertsSentCount = _cursor.getInt(_cursorIndexOfAlertsSentCount);
            final String _tmpVerificationQrCode;
            if (_cursor.isNull(_cursorIndexOfVerificationQrCode)) {
              _tmpVerificationQrCode = null;
            } else {
              _tmpVerificationQrCode = _cursor.getString(_cursorIndexOfVerificationQrCode);
            }
            _result = new Contact(_tmpId,_tmpName,_tmpPhoneNumber,_tmpPhotoUri,_tmpLevel,_tmpHasApp,_tmpPublicKey,_tmpVerified,_tmpCreatedAt,_tmpLastAlertSentAt,_tmpAlertsSentCount,_tmpVerificationQrCode);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Contact>> getContactsByLevel(final int level) {
    final String _sql = "SELECT * FROM contacts WHERE level = ? ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, level);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"contacts"}, new Callable<List<Contact>>() {
      @Override
      @NonNull
      public List<Contact> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfPhotoUri = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUri");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfHasApp = CursorUtil.getColumnIndexOrThrow(_cursor, "hasApp");
          final int _cursorIndexOfPublicKey = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKey");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "verified");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastAlertSentAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastAlertSentAt");
          final int _cursorIndexOfAlertsSentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "alertsSentCount");
          final int _cursorIndexOfVerificationQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "verificationQrCode");
          final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Contact _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpPhotoUri;
            if (_cursor.isNull(_cursorIndexOfPhotoUri)) {
              _tmpPhotoUri = null;
            } else {
              _tmpPhotoUri = _cursor.getString(_cursorIndexOfPhotoUri);
            }
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final boolean _tmpHasApp;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfHasApp);
            _tmpHasApp = _tmp != 0;
            final String _tmpPublicKey;
            if (_cursor.isNull(_cursorIndexOfPublicKey)) {
              _tmpPublicKey = null;
            } else {
              _tmpPublicKey = _cursor.getString(_cursorIndexOfPublicKey);
            }
            final boolean _tmpVerified;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfVerified);
            _tmpVerified = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpLastAlertSentAt;
            if (_cursor.isNull(_cursorIndexOfLastAlertSentAt)) {
              _tmpLastAlertSentAt = null;
            } else {
              _tmpLastAlertSentAt = _cursor.getLong(_cursorIndexOfLastAlertSentAt);
            }
            final int _tmpAlertsSentCount;
            _tmpAlertsSentCount = _cursor.getInt(_cursorIndexOfAlertsSentCount);
            final String _tmpVerificationQrCode;
            if (_cursor.isNull(_cursorIndexOfVerificationQrCode)) {
              _tmpVerificationQrCode = null;
            } else {
              _tmpVerificationQrCode = _cursor.getString(_cursorIndexOfVerificationQrCode);
            }
            _item = new Contact(_tmpId,_tmpName,_tmpPhoneNumber,_tmpPhotoUri,_tmpLevel,_tmpHasApp,_tmpPublicKey,_tmpVerified,_tmpCreatedAt,_tmpLastAlertSentAt,_tmpAlertsSentCount,_tmpVerificationQrCode);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Contact>> getEncryptedContacts() {
    final String _sql = "SELECT * FROM contacts WHERE hasApp = 1 AND verified = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"contacts"}, new Callable<List<Contact>>() {
      @Override
      @NonNull
      public List<Contact> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
          final int _cursorIndexOfPhotoUri = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUri");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfHasApp = CursorUtil.getColumnIndexOrThrow(_cursor, "hasApp");
          final int _cursorIndexOfPublicKey = CursorUtil.getColumnIndexOrThrow(_cursor, "publicKey");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "verified");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfLastAlertSentAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastAlertSentAt");
          final int _cursorIndexOfAlertsSentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "alertsSentCount");
          final int _cursorIndexOfVerificationQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "verificationQrCode");
          final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Contact _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpPhoneNumber;
            if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
              _tmpPhoneNumber = null;
            } else {
              _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
            }
            final String _tmpPhotoUri;
            if (_cursor.isNull(_cursorIndexOfPhotoUri)) {
              _tmpPhotoUri = null;
            } else {
              _tmpPhotoUri = _cursor.getString(_cursorIndexOfPhotoUri);
            }
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final boolean _tmpHasApp;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfHasApp);
            _tmpHasApp = _tmp != 0;
            final String _tmpPublicKey;
            if (_cursor.isNull(_cursorIndexOfPublicKey)) {
              _tmpPublicKey = null;
            } else {
              _tmpPublicKey = _cursor.getString(_cursorIndexOfPublicKey);
            }
            final boolean _tmpVerified;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfVerified);
            _tmpVerified = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final Long _tmpLastAlertSentAt;
            if (_cursor.isNull(_cursorIndexOfLastAlertSentAt)) {
              _tmpLastAlertSentAt = null;
            } else {
              _tmpLastAlertSentAt = _cursor.getLong(_cursorIndexOfLastAlertSentAt);
            }
            final int _tmpAlertsSentCount;
            _tmpAlertsSentCount = _cursor.getInt(_cursorIndexOfAlertsSentCount);
            final String _tmpVerificationQrCode;
            if (_cursor.isNull(_cursorIndexOfVerificationQrCode)) {
              _tmpVerificationQrCode = null;
            } else {
              _tmpVerificationQrCode = _cursor.getString(_cursorIndexOfVerificationQrCode);
            }
            _item = new Contact(_tmpId,_tmpName,_tmpPhoneNumber,_tmpPhotoUri,_tmpLevel,_tmpHasApp,_tmpPublicKey,_tmpVerified,_tmpCreatedAt,_tmpLastAlertSentAt,_tmpAlertsSentCount,_tmpVerificationQrCode);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getContactCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM contacts";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
