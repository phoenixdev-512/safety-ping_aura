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
import com.aura.emergency.data.model.AlertLog;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Float;
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
public final class AlertLogDao_Impl implements AlertLogDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AlertLog> __insertionAdapterOfAlertLog;

  private final EntityDeletionOrUpdateAdapter<AlertLog> __updateAdapterOfAlertLog;

  private final SharedSQLiteStatement __preparedStmtOfEndAlert;

  private final SharedSQLiteStatement __preparedStmtOfIncrementResponses;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOldAlerts;

  public AlertLogDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlertLog = new EntityInsertionAdapter<AlertLog>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `alert_logs` (`id`,`level`,`timestamp`,`latitude`,`longitude`,`accuracy`,`batteryPercentage`,`isCharging`,`networkType`,`activity`,`activityConfidence`,`noiseDb`,`audioSnapshotPath`,`isActive`,`endedAt`,`contactsAlerted`,`responsesReceived`,`triggerMethod`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AlertLog entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getLevel());
        statement.bindLong(3, entity.getTimestamp());
        if (entity.getLatitude() == null) {
          statement.bindNull(4);
        } else {
          statement.bindDouble(4, entity.getLatitude());
        }
        if (entity.getLongitude() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getLongitude());
        }
        if (entity.getAccuracy() == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.getAccuracy());
        }
        if (entity.getBatteryPercentage() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getBatteryPercentage());
        }
        final Integer _tmp = entity.isCharging() == null ? null : (entity.isCharging() ? 1 : 0);
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, _tmp);
        }
        if (entity.getNetworkType() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getNetworkType());
        }
        if (entity.getActivity() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getActivity());
        }
        if (entity.getActivityConfidence() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getActivityConfidence());
        }
        if (entity.getNoiseDb() == null) {
          statement.bindNull(12);
        } else {
          statement.bindLong(12, entity.getNoiseDb());
        }
        if (entity.getAudioSnapshotPath() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getAudioSnapshotPath());
        }
        final int _tmp_1 = entity.isActive() ? 1 : 0;
        statement.bindLong(14, _tmp_1);
        if (entity.getEndedAt() == null) {
          statement.bindNull(15);
        } else {
          statement.bindLong(15, entity.getEndedAt());
        }
        statement.bindLong(16, entity.getContactsAlerted());
        statement.bindLong(17, entity.getResponsesReceived());
        if (entity.getTriggerMethod() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getTriggerMethod());
        }
      }
    };
    this.__updateAdapterOfAlertLog = new EntityDeletionOrUpdateAdapter<AlertLog>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `alert_logs` SET `id` = ?,`level` = ?,`timestamp` = ?,`latitude` = ?,`longitude` = ?,`accuracy` = ?,`batteryPercentage` = ?,`isCharging` = ?,`networkType` = ?,`activity` = ?,`activityConfidence` = ?,`noiseDb` = ?,`audioSnapshotPath` = ?,`isActive` = ?,`endedAt` = ?,`contactsAlerted` = ?,`responsesReceived` = ?,`triggerMethod` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AlertLog entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getLevel());
        statement.bindLong(3, entity.getTimestamp());
        if (entity.getLatitude() == null) {
          statement.bindNull(4);
        } else {
          statement.bindDouble(4, entity.getLatitude());
        }
        if (entity.getLongitude() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getLongitude());
        }
        if (entity.getAccuracy() == null) {
          statement.bindNull(6);
        } else {
          statement.bindDouble(6, entity.getAccuracy());
        }
        if (entity.getBatteryPercentage() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getBatteryPercentage());
        }
        final Integer _tmp = entity.isCharging() == null ? null : (entity.isCharging() ? 1 : 0);
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, _tmp);
        }
        if (entity.getNetworkType() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getNetworkType());
        }
        if (entity.getActivity() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getActivity());
        }
        if (entity.getActivityConfidence() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getActivityConfidence());
        }
        if (entity.getNoiseDb() == null) {
          statement.bindNull(12);
        } else {
          statement.bindLong(12, entity.getNoiseDb());
        }
        if (entity.getAudioSnapshotPath() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getAudioSnapshotPath());
        }
        final int _tmp_1 = entity.isActive() ? 1 : 0;
        statement.bindLong(14, _tmp_1);
        if (entity.getEndedAt() == null) {
          statement.bindNull(15);
        } else {
          statement.bindLong(15, entity.getEndedAt());
        }
        statement.bindLong(16, entity.getContactsAlerted());
        statement.bindLong(17, entity.getResponsesReceived());
        if (entity.getTriggerMethod() == null) {
          statement.bindNull(18);
        } else {
          statement.bindString(18, entity.getTriggerMethod());
        }
        statement.bindLong(19, entity.getId());
      }
    };
    this.__preparedStmtOfEndAlert = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE alert_logs SET isActive = 0, endedAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfIncrementResponses = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE alert_logs SET responsesReceived = responsesReceived + 1 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOldAlerts = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM alert_logs WHERE timestamp < ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAlertLog(final AlertLog alertLog,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAlertLog.insertAndReturnId(alertLog);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAlertLog(final AlertLog alertLog,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAlertLog.handle(alertLog);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object endAlert(final int alertId, final long endedAt,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfEndAlert.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, endedAt);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, alertId);
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
          __preparedStmtOfEndAlert.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object incrementResponses(final int alertId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfIncrementResponses.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, alertId);
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
          __preparedStmtOfIncrementResponses.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteOldAlerts(final long beforeTimestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOldAlerts.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, beforeTimestamp);
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
          __preparedStmtOfDeleteOldAlerts.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<AlertLog>> getAllAlertLogs() {
    final String _sql = "SELECT * FROM alert_logs ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"alert_logs"}, new Callable<List<AlertLog>>() {
      @Override
      @NonNull
      public List<AlertLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
          final int _cursorIndexOfBatteryPercentage = CursorUtil.getColumnIndexOrThrow(_cursor, "batteryPercentage");
          final int _cursorIndexOfIsCharging = CursorUtil.getColumnIndexOrThrow(_cursor, "isCharging");
          final int _cursorIndexOfNetworkType = CursorUtil.getColumnIndexOrThrow(_cursor, "networkType");
          final int _cursorIndexOfActivity = CursorUtil.getColumnIndexOrThrow(_cursor, "activity");
          final int _cursorIndexOfActivityConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "activityConfidence");
          final int _cursorIndexOfNoiseDb = CursorUtil.getColumnIndexOrThrow(_cursor, "noiseDb");
          final int _cursorIndexOfAudioSnapshotPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioSnapshotPath");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfEndedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "endedAt");
          final int _cursorIndexOfContactsAlerted = CursorUtil.getColumnIndexOrThrow(_cursor, "contactsAlerted");
          final int _cursorIndexOfResponsesReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "responsesReceived");
          final int _cursorIndexOfTriggerMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerMethod");
          final List<AlertLog> _result = new ArrayList<AlertLog>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AlertLog _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            final Float _tmpAccuracy;
            if (_cursor.isNull(_cursorIndexOfAccuracy)) {
              _tmpAccuracy = null;
            } else {
              _tmpAccuracy = _cursor.getFloat(_cursorIndexOfAccuracy);
            }
            final Integer _tmpBatteryPercentage;
            if (_cursor.isNull(_cursorIndexOfBatteryPercentage)) {
              _tmpBatteryPercentage = null;
            } else {
              _tmpBatteryPercentage = _cursor.getInt(_cursorIndexOfBatteryPercentage);
            }
            final Boolean _tmpIsCharging;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsCharging)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsCharging);
            }
            _tmpIsCharging = _tmp == null ? null : _tmp != 0;
            final String _tmpNetworkType;
            if (_cursor.isNull(_cursorIndexOfNetworkType)) {
              _tmpNetworkType = null;
            } else {
              _tmpNetworkType = _cursor.getString(_cursorIndexOfNetworkType);
            }
            final String _tmpActivity;
            if (_cursor.isNull(_cursorIndexOfActivity)) {
              _tmpActivity = null;
            } else {
              _tmpActivity = _cursor.getString(_cursorIndexOfActivity);
            }
            final Integer _tmpActivityConfidence;
            if (_cursor.isNull(_cursorIndexOfActivityConfidence)) {
              _tmpActivityConfidence = null;
            } else {
              _tmpActivityConfidence = _cursor.getInt(_cursorIndexOfActivityConfidence);
            }
            final Integer _tmpNoiseDb;
            if (_cursor.isNull(_cursorIndexOfNoiseDb)) {
              _tmpNoiseDb = null;
            } else {
              _tmpNoiseDb = _cursor.getInt(_cursorIndexOfNoiseDb);
            }
            final String _tmpAudioSnapshotPath;
            if (_cursor.isNull(_cursorIndexOfAudioSnapshotPath)) {
              _tmpAudioSnapshotPath = null;
            } else {
              _tmpAudioSnapshotPath = _cursor.getString(_cursorIndexOfAudioSnapshotPath);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            final Long _tmpEndedAt;
            if (_cursor.isNull(_cursorIndexOfEndedAt)) {
              _tmpEndedAt = null;
            } else {
              _tmpEndedAt = _cursor.getLong(_cursorIndexOfEndedAt);
            }
            final int _tmpContactsAlerted;
            _tmpContactsAlerted = _cursor.getInt(_cursorIndexOfContactsAlerted);
            final int _tmpResponsesReceived;
            _tmpResponsesReceived = _cursor.getInt(_cursorIndexOfResponsesReceived);
            final String _tmpTriggerMethod;
            if (_cursor.isNull(_cursorIndexOfTriggerMethod)) {
              _tmpTriggerMethod = null;
            } else {
              _tmpTriggerMethod = _cursor.getString(_cursorIndexOfTriggerMethod);
            }
            _item = new AlertLog(_tmpId,_tmpLevel,_tmpTimestamp,_tmpLatitude,_tmpLongitude,_tmpAccuracy,_tmpBatteryPercentage,_tmpIsCharging,_tmpNetworkType,_tmpActivity,_tmpActivityConfidence,_tmpNoiseDb,_tmpAudioSnapshotPath,_tmpIsActive,_tmpEndedAt,_tmpContactsAlerted,_tmpResponsesReceived,_tmpTriggerMethod);
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
  public Object getAlertLogById(final int id, final Continuation<? super AlertLog> $completion) {
    final String _sql = "SELECT * FROM alert_logs WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<AlertLog>() {
      @Override
      @Nullable
      public AlertLog call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
          final int _cursorIndexOfBatteryPercentage = CursorUtil.getColumnIndexOrThrow(_cursor, "batteryPercentage");
          final int _cursorIndexOfIsCharging = CursorUtil.getColumnIndexOrThrow(_cursor, "isCharging");
          final int _cursorIndexOfNetworkType = CursorUtil.getColumnIndexOrThrow(_cursor, "networkType");
          final int _cursorIndexOfActivity = CursorUtil.getColumnIndexOrThrow(_cursor, "activity");
          final int _cursorIndexOfActivityConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "activityConfidence");
          final int _cursorIndexOfNoiseDb = CursorUtil.getColumnIndexOrThrow(_cursor, "noiseDb");
          final int _cursorIndexOfAudioSnapshotPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioSnapshotPath");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfEndedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "endedAt");
          final int _cursorIndexOfContactsAlerted = CursorUtil.getColumnIndexOrThrow(_cursor, "contactsAlerted");
          final int _cursorIndexOfResponsesReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "responsesReceived");
          final int _cursorIndexOfTriggerMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerMethod");
          final AlertLog _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            final Float _tmpAccuracy;
            if (_cursor.isNull(_cursorIndexOfAccuracy)) {
              _tmpAccuracy = null;
            } else {
              _tmpAccuracy = _cursor.getFloat(_cursorIndexOfAccuracy);
            }
            final Integer _tmpBatteryPercentage;
            if (_cursor.isNull(_cursorIndexOfBatteryPercentage)) {
              _tmpBatteryPercentage = null;
            } else {
              _tmpBatteryPercentage = _cursor.getInt(_cursorIndexOfBatteryPercentage);
            }
            final Boolean _tmpIsCharging;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsCharging)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsCharging);
            }
            _tmpIsCharging = _tmp == null ? null : _tmp != 0;
            final String _tmpNetworkType;
            if (_cursor.isNull(_cursorIndexOfNetworkType)) {
              _tmpNetworkType = null;
            } else {
              _tmpNetworkType = _cursor.getString(_cursorIndexOfNetworkType);
            }
            final String _tmpActivity;
            if (_cursor.isNull(_cursorIndexOfActivity)) {
              _tmpActivity = null;
            } else {
              _tmpActivity = _cursor.getString(_cursorIndexOfActivity);
            }
            final Integer _tmpActivityConfidence;
            if (_cursor.isNull(_cursorIndexOfActivityConfidence)) {
              _tmpActivityConfidence = null;
            } else {
              _tmpActivityConfidence = _cursor.getInt(_cursorIndexOfActivityConfidence);
            }
            final Integer _tmpNoiseDb;
            if (_cursor.isNull(_cursorIndexOfNoiseDb)) {
              _tmpNoiseDb = null;
            } else {
              _tmpNoiseDb = _cursor.getInt(_cursorIndexOfNoiseDb);
            }
            final String _tmpAudioSnapshotPath;
            if (_cursor.isNull(_cursorIndexOfAudioSnapshotPath)) {
              _tmpAudioSnapshotPath = null;
            } else {
              _tmpAudioSnapshotPath = _cursor.getString(_cursorIndexOfAudioSnapshotPath);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            final Long _tmpEndedAt;
            if (_cursor.isNull(_cursorIndexOfEndedAt)) {
              _tmpEndedAt = null;
            } else {
              _tmpEndedAt = _cursor.getLong(_cursorIndexOfEndedAt);
            }
            final int _tmpContactsAlerted;
            _tmpContactsAlerted = _cursor.getInt(_cursorIndexOfContactsAlerted);
            final int _tmpResponsesReceived;
            _tmpResponsesReceived = _cursor.getInt(_cursorIndexOfResponsesReceived);
            final String _tmpTriggerMethod;
            if (_cursor.isNull(_cursorIndexOfTriggerMethod)) {
              _tmpTriggerMethod = null;
            } else {
              _tmpTriggerMethod = _cursor.getString(_cursorIndexOfTriggerMethod);
            }
            _result = new AlertLog(_tmpId,_tmpLevel,_tmpTimestamp,_tmpLatitude,_tmpLongitude,_tmpAccuracy,_tmpBatteryPercentage,_tmpIsCharging,_tmpNetworkType,_tmpActivity,_tmpActivityConfidence,_tmpNoiseDb,_tmpAudioSnapshotPath,_tmpIsActive,_tmpEndedAt,_tmpContactsAlerted,_tmpResponsesReceived,_tmpTriggerMethod);
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
  public Object getActiveAlert(final Continuation<? super AlertLog> $completion) {
    final String _sql = "SELECT * FROM alert_logs WHERE isActive = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<AlertLog>() {
      @Override
      @Nullable
      public AlertLog call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
          final int _cursorIndexOfBatteryPercentage = CursorUtil.getColumnIndexOrThrow(_cursor, "batteryPercentage");
          final int _cursorIndexOfIsCharging = CursorUtil.getColumnIndexOrThrow(_cursor, "isCharging");
          final int _cursorIndexOfNetworkType = CursorUtil.getColumnIndexOrThrow(_cursor, "networkType");
          final int _cursorIndexOfActivity = CursorUtil.getColumnIndexOrThrow(_cursor, "activity");
          final int _cursorIndexOfActivityConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "activityConfidence");
          final int _cursorIndexOfNoiseDb = CursorUtil.getColumnIndexOrThrow(_cursor, "noiseDb");
          final int _cursorIndexOfAudioSnapshotPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioSnapshotPath");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfEndedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "endedAt");
          final int _cursorIndexOfContactsAlerted = CursorUtil.getColumnIndexOrThrow(_cursor, "contactsAlerted");
          final int _cursorIndexOfResponsesReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "responsesReceived");
          final int _cursorIndexOfTriggerMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerMethod");
          final AlertLog _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            final Float _tmpAccuracy;
            if (_cursor.isNull(_cursorIndexOfAccuracy)) {
              _tmpAccuracy = null;
            } else {
              _tmpAccuracy = _cursor.getFloat(_cursorIndexOfAccuracy);
            }
            final Integer _tmpBatteryPercentage;
            if (_cursor.isNull(_cursorIndexOfBatteryPercentage)) {
              _tmpBatteryPercentage = null;
            } else {
              _tmpBatteryPercentage = _cursor.getInt(_cursorIndexOfBatteryPercentage);
            }
            final Boolean _tmpIsCharging;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsCharging)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsCharging);
            }
            _tmpIsCharging = _tmp == null ? null : _tmp != 0;
            final String _tmpNetworkType;
            if (_cursor.isNull(_cursorIndexOfNetworkType)) {
              _tmpNetworkType = null;
            } else {
              _tmpNetworkType = _cursor.getString(_cursorIndexOfNetworkType);
            }
            final String _tmpActivity;
            if (_cursor.isNull(_cursorIndexOfActivity)) {
              _tmpActivity = null;
            } else {
              _tmpActivity = _cursor.getString(_cursorIndexOfActivity);
            }
            final Integer _tmpActivityConfidence;
            if (_cursor.isNull(_cursorIndexOfActivityConfidence)) {
              _tmpActivityConfidence = null;
            } else {
              _tmpActivityConfidence = _cursor.getInt(_cursorIndexOfActivityConfidence);
            }
            final Integer _tmpNoiseDb;
            if (_cursor.isNull(_cursorIndexOfNoiseDb)) {
              _tmpNoiseDb = null;
            } else {
              _tmpNoiseDb = _cursor.getInt(_cursorIndexOfNoiseDb);
            }
            final String _tmpAudioSnapshotPath;
            if (_cursor.isNull(_cursorIndexOfAudioSnapshotPath)) {
              _tmpAudioSnapshotPath = null;
            } else {
              _tmpAudioSnapshotPath = _cursor.getString(_cursorIndexOfAudioSnapshotPath);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            final Long _tmpEndedAt;
            if (_cursor.isNull(_cursorIndexOfEndedAt)) {
              _tmpEndedAt = null;
            } else {
              _tmpEndedAt = _cursor.getLong(_cursorIndexOfEndedAt);
            }
            final int _tmpContactsAlerted;
            _tmpContactsAlerted = _cursor.getInt(_cursorIndexOfContactsAlerted);
            final int _tmpResponsesReceived;
            _tmpResponsesReceived = _cursor.getInt(_cursorIndexOfResponsesReceived);
            final String _tmpTriggerMethod;
            if (_cursor.isNull(_cursorIndexOfTriggerMethod)) {
              _tmpTriggerMethod = null;
            } else {
              _tmpTriggerMethod = _cursor.getString(_cursorIndexOfTriggerMethod);
            }
            _result = new AlertLog(_tmpId,_tmpLevel,_tmpTimestamp,_tmpLatitude,_tmpLongitude,_tmpAccuracy,_tmpBatteryPercentage,_tmpIsCharging,_tmpNetworkType,_tmpActivity,_tmpActivityConfidence,_tmpNoiseDb,_tmpAudioSnapshotPath,_tmpIsActive,_tmpEndedAt,_tmpContactsAlerted,_tmpResponsesReceived,_tmpTriggerMethod);
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
  public Flow<AlertLog> getActiveAlertFlow() {
    final String _sql = "SELECT * FROM alert_logs WHERE isActive = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"alert_logs"}, new Callable<AlertLog>() {
      @Override
      @Nullable
      public AlertLog call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
          final int _cursorIndexOfBatteryPercentage = CursorUtil.getColumnIndexOrThrow(_cursor, "batteryPercentage");
          final int _cursorIndexOfIsCharging = CursorUtil.getColumnIndexOrThrow(_cursor, "isCharging");
          final int _cursorIndexOfNetworkType = CursorUtil.getColumnIndexOrThrow(_cursor, "networkType");
          final int _cursorIndexOfActivity = CursorUtil.getColumnIndexOrThrow(_cursor, "activity");
          final int _cursorIndexOfActivityConfidence = CursorUtil.getColumnIndexOrThrow(_cursor, "activityConfidence");
          final int _cursorIndexOfNoiseDb = CursorUtil.getColumnIndexOrThrow(_cursor, "noiseDb");
          final int _cursorIndexOfAudioSnapshotPath = CursorUtil.getColumnIndexOrThrow(_cursor, "audioSnapshotPath");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfEndedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "endedAt");
          final int _cursorIndexOfContactsAlerted = CursorUtil.getColumnIndexOrThrow(_cursor, "contactsAlerted");
          final int _cursorIndexOfResponsesReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "responsesReceived");
          final int _cursorIndexOfTriggerMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerMethod");
          final AlertLog _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpLevel;
            _tmpLevel = _cursor.getInt(_cursorIndexOfLevel);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            final Float _tmpAccuracy;
            if (_cursor.isNull(_cursorIndexOfAccuracy)) {
              _tmpAccuracy = null;
            } else {
              _tmpAccuracy = _cursor.getFloat(_cursorIndexOfAccuracy);
            }
            final Integer _tmpBatteryPercentage;
            if (_cursor.isNull(_cursorIndexOfBatteryPercentage)) {
              _tmpBatteryPercentage = null;
            } else {
              _tmpBatteryPercentage = _cursor.getInt(_cursorIndexOfBatteryPercentage);
            }
            final Boolean _tmpIsCharging;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsCharging)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsCharging);
            }
            _tmpIsCharging = _tmp == null ? null : _tmp != 0;
            final String _tmpNetworkType;
            if (_cursor.isNull(_cursorIndexOfNetworkType)) {
              _tmpNetworkType = null;
            } else {
              _tmpNetworkType = _cursor.getString(_cursorIndexOfNetworkType);
            }
            final String _tmpActivity;
            if (_cursor.isNull(_cursorIndexOfActivity)) {
              _tmpActivity = null;
            } else {
              _tmpActivity = _cursor.getString(_cursorIndexOfActivity);
            }
            final Integer _tmpActivityConfidence;
            if (_cursor.isNull(_cursorIndexOfActivityConfidence)) {
              _tmpActivityConfidence = null;
            } else {
              _tmpActivityConfidence = _cursor.getInt(_cursorIndexOfActivityConfidence);
            }
            final Integer _tmpNoiseDb;
            if (_cursor.isNull(_cursorIndexOfNoiseDb)) {
              _tmpNoiseDb = null;
            } else {
              _tmpNoiseDb = _cursor.getInt(_cursorIndexOfNoiseDb);
            }
            final String _tmpAudioSnapshotPath;
            if (_cursor.isNull(_cursorIndexOfAudioSnapshotPath)) {
              _tmpAudioSnapshotPath = null;
            } else {
              _tmpAudioSnapshotPath = _cursor.getString(_cursorIndexOfAudioSnapshotPath);
            }
            final boolean _tmpIsActive;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp_1 != 0;
            final Long _tmpEndedAt;
            if (_cursor.isNull(_cursorIndexOfEndedAt)) {
              _tmpEndedAt = null;
            } else {
              _tmpEndedAt = _cursor.getLong(_cursorIndexOfEndedAt);
            }
            final int _tmpContactsAlerted;
            _tmpContactsAlerted = _cursor.getInt(_cursorIndexOfContactsAlerted);
            final int _tmpResponsesReceived;
            _tmpResponsesReceived = _cursor.getInt(_cursorIndexOfResponsesReceived);
            final String _tmpTriggerMethod;
            if (_cursor.isNull(_cursorIndexOfTriggerMethod)) {
              _tmpTriggerMethod = null;
            } else {
              _tmpTriggerMethod = _cursor.getString(_cursorIndexOfTriggerMethod);
            }
            _result = new AlertLog(_tmpId,_tmpLevel,_tmpTimestamp,_tmpLatitude,_tmpLongitude,_tmpAccuracy,_tmpBatteryPercentage,_tmpIsCharging,_tmpNetworkType,_tmpActivity,_tmpActivityConfidence,_tmpNoiseDb,_tmpAudioSnapshotPath,_tmpIsActive,_tmpEndedAt,_tmpContactsAlerted,_tmpResponsesReceived,_tmpTriggerMethod);
          } else {
            _result = null;
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
