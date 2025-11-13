package com.aura.emergency.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.aura.emergency.data.model.LocationBreadcrumb;
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
public final class LocationBreadcrumbDao_Impl implements LocationBreadcrumbDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LocationBreadcrumb> __insertionAdapterOfLocationBreadcrumb;

  private final SharedSQLiteStatement __preparedStmtOfDeleteBreadcrumbsForAlert;

  public LocationBreadcrumbDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocationBreadcrumb = new EntityInsertionAdapter<LocationBreadcrumb>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `location_breadcrumbs` (`id`,`alertLogId`,`timestamp`,`latitude`,`longitude`,`accuracy`,`batteryPercentage`,`activity`,`noiseDb`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LocationBreadcrumb entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getAlertLogId());
        statement.bindLong(3, entity.getTimestamp());
        statement.bindDouble(4, entity.getLatitude());
        statement.bindDouble(5, entity.getLongitude());
        statement.bindDouble(6, entity.getAccuracy());
        if (entity.getBatteryPercentage() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getBatteryPercentage());
        }
        if (entity.getActivity() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getActivity());
        }
        if (entity.getNoiseDb() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getNoiseDb());
        }
      }
    };
    this.__preparedStmtOfDeleteBreadcrumbsForAlert = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM location_breadcrumbs WHERE alertLogId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertBreadcrumb(final LocationBreadcrumb breadcrumb,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfLocationBreadcrumb.insertAndReturnId(breadcrumb);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteBreadcrumbsForAlert(final int alertLogId,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteBreadcrumbsForAlert.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, alertLogId);
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
          __preparedStmtOfDeleteBreadcrumbsForAlert.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<LocationBreadcrumb>> getBreadcrumbsForAlert(final int alertLogId) {
    final String _sql = "SELECT * FROM location_breadcrumbs WHERE alertLogId = ? ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, alertLogId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"location_breadcrumbs"}, new Callable<List<LocationBreadcrumb>>() {
      @Override
      @NonNull
      public List<LocationBreadcrumb> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAlertLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "alertLogId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
          final int _cursorIndexOfBatteryPercentage = CursorUtil.getColumnIndexOrThrow(_cursor, "batteryPercentage");
          final int _cursorIndexOfActivity = CursorUtil.getColumnIndexOrThrow(_cursor, "activity");
          final int _cursorIndexOfNoiseDb = CursorUtil.getColumnIndexOrThrow(_cursor, "noiseDb");
          final List<LocationBreadcrumb> _result = new ArrayList<LocationBreadcrumb>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LocationBreadcrumb _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpAlertLogId;
            _tmpAlertLogId = _cursor.getInt(_cursorIndexOfAlertLogId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final float _tmpAccuracy;
            _tmpAccuracy = _cursor.getFloat(_cursorIndexOfAccuracy);
            final Integer _tmpBatteryPercentage;
            if (_cursor.isNull(_cursorIndexOfBatteryPercentage)) {
              _tmpBatteryPercentage = null;
            } else {
              _tmpBatteryPercentage = _cursor.getInt(_cursorIndexOfBatteryPercentage);
            }
            final String _tmpActivity;
            if (_cursor.isNull(_cursorIndexOfActivity)) {
              _tmpActivity = null;
            } else {
              _tmpActivity = _cursor.getString(_cursorIndexOfActivity);
            }
            final Integer _tmpNoiseDb;
            if (_cursor.isNull(_cursorIndexOfNoiseDb)) {
              _tmpNoiseDb = null;
            } else {
              _tmpNoiseDb = _cursor.getInt(_cursorIndexOfNoiseDb);
            }
            _item = new LocationBreadcrumb(_tmpId,_tmpAlertLogId,_tmpTimestamp,_tmpLatitude,_tmpLongitude,_tmpAccuracy,_tmpBatteryPercentage,_tmpActivity,_tmpNoiseDb);
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
  public Object getLatestBreadcrumb(final int alertLogId,
      final Continuation<? super LocationBreadcrumb> $completion) {
    final String _sql = "SELECT * FROM location_breadcrumbs WHERE alertLogId = ? ORDER BY timestamp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, alertLogId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<LocationBreadcrumb>() {
      @Override
      @Nullable
      public LocationBreadcrumb call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAlertLogId = CursorUtil.getColumnIndexOrThrow(_cursor, "alertLogId");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAccuracy = CursorUtil.getColumnIndexOrThrow(_cursor, "accuracy");
          final int _cursorIndexOfBatteryPercentage = CursorUtil.getColumnIndexOrThrow(_cursor, "batteryPercentage");
          final int _cursorIndexOfActivity = CursorUtil.getColumnIndexOrThrow(_cursor, "activity");
          final int _cursorIndexOfNoiseDb = CursorUtil.getColumnIndexOrThrow(_cursor, "noiseDb");
          final LocationBreadcrumb _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpAlertLogId;
            _tmpAlertLogId = _cursor.getInt(_cursorIndexOfAlertLogId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final float _tmpAccuracy;
            _tmpAccuracy = _cursor.getFloat(_cursorIndexOfAccuracy);
            final Integer _tmpBatteryPercentage;
            if (_cursor.isNull(_cursorIndexOfBatteryPercentage)) {
              _tmpBatteryPercentage = null;
            } else {
              _tmpBatteryPercentage = _cursor.getInt(_cursorIndexOfBatteryPercentage);
            }
            final String _tmpActivity;
            if (_cursor.isNull(_cursorIndexOfActivity)) {
              _tmpActivity = null;
            } else {
              _tmpActivity = _cursor.getString(_cursorIndexOfActivity);
            }
            final Integer _tmpNoiseDb;
            if (_cursor.isNull(_cursorIndexOfNoiseDb)) {
              _tmpNoiseDb = null;
            } else {
              _tmpNoiseDb = _cursor.getInt(_cursorIndexOfNoiseDb);
            }
            _result = new LocationBreadcrumb(_tmpId,_tmpAlertLogId,_tmpTimestamp,_tmpLatitude,_tmpLongitude,_tmpAccuracy,_tmpBatteryPercentage,_tmpActivity,_tmpNoiseDb);
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
