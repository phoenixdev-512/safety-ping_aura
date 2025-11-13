package com.aura.emergency.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.aura.emergency.data.dao.AlertLogDao;
import com.aura.emergency.data.dao.AlertLogDao_Impl;
import com.aura.emergency.data.dao.AuditLogDao;
import com.aura.emergency.data.dao.AuditLogDao_Impl;
import com.aura.emergency.data.dao.ContactDao;
import com.aura.emergency.data.dao.ContactDao_Impl;
import com.aura.emergency.data.dao.LocationBreadcrumbDao;
import com.aura.emergency.data.dao.LocationBreadcrumbDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AuraDatabase_Impl extends AuraDatabase {
  private volatile ContactDao _contactDao;

  private volatile AlertLogDao _alertLogDao;

  private volatile LocationBreadcrumbDao _locationBreadcrumbDao;

  private volatile AuditLogDao _auditLogDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `contacts` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `phoneNumber` TEXT NOT NULL, `photoUri` TEXT, `level` INTEGER NOT NULL, `hasApp` INTEGER NOT NULL, `publicKey` TEXT, `verified` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `lastAlertSentAt` INTEGER, `alertsSentCount` INTEGER NOT NULL, `verificationQrCode` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `alert_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `level` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `latitude` REAL, `longitude` REAL, `accuracy` REAL, `batteryPercentage` INTEGER, `isCharging` INTEGER, `networkType` TEXT, `activity` TEXT, `activityConfidence` INTEGER, `noiseDb` INTEGER, `audioSnapshotPath` TEXT, `isActive` INTEGER NOT NULL, `endedAt` INTEGER, `contactsAlerted` INTEGER NOT NULL, `responsesReceived` INTEGER NOT NULL, `triggerMethod` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `location_breadcrumbs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `alertLogId` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `accuracy` REAL NOT NULL, `batteryPercentage` INTEGER, `activity` TEXT, `noiseDb` INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `audit_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `eventType` TEXT NOT NULL, `eventDescription` TEXT NOT NULL, `metadata` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3709d14d63e1ea8ef41e35e2fdced37c')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `contacts`");
        db.execSQL("DROP TABLE IF EXISTS `alert_logs`");
        db.execSQL("DROP TABLE IF EXISTS `location_breadcrumbs`");
        db.execSQL("DROP TABLE IF EXISTS `audit_logs`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsContacts = new HashMap<String, TableInfo.Column>(12);
        _columnsContacts.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("photoUri", new TableInfo.Column("photoUri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("level", new TableInfo.Column("level", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("hasApp", new TableInfo.Column("hasApp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("publicKey", new TableInfo.Column("publicKey", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("verified", new TableInfo.Column("verified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("lastAlertSentAt", new TableInfo.Column("lastAlertSentAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("alertsSentCount", new TableInfo.Column("alertsSentCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContacts.put("verificationQrCode", new TableInfo.Column("verificationQrCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContacts = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContacts = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoContacts = new TableInfo("contacts", _columnsContacts, _foreignKeysContacts, _indicesContacts);
        final TableInfo _existingContacts = TableInfo.read(db, "contacts");
        if (!_infoContacts.equals(_existingContacts)) {
          return new RoomOpenHelper.ValidationResult(false, "contacts(com.aura.emergency.data.model.Contact).\n"
                  + " Expected:\n" + _infoContacts + "\n"
                  + " Found:\n" + _existingContacts);
        }
        final HashMap<String, TableInfo.Column> _columnsAlertLogs = new HashMap<String, TableInfo.Column>(18);
        _columnsAlertLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("level", new TableInfo.Column("level", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("accuracy", new TableInfo.Column("accuracy", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("batteryPercentage", new TableInfo.Column("batteryPercentage", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("isCharging", new TableInfo.Column("isCharging", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("networkType", new TableInfo.Column("networkType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("activity", new TableInfo.Column("activity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("activityConfidence", new TableInfo.Column("activityConfidence", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("noiseDb", new TableInfo.Column("noiseDb", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("audioSnapshotPath", new TableInfo.Column("audioSnapshotPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("endedAt", new TableInfo.Column("endedAt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("contactsAlerted", new TableInfo.Column("contactsAlerted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("responsesReceived", new TableInfo.Column("responsesReceived", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertLogs.put("triggerMethod", new TableInfo.Column("triggerMethod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlertLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlertLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlertLogs = new TableInfo("alert_logs", _columnsAlertLogs, _foreignKeysAlertLogs, _indicesAlertLogs);
        final TableInfo _existingAlertLogs = TableInfo.read(db, "alert_logs");
        if (!_infoAlertLogs.equals(_existingAlertLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "alert_logs(com.aura.emergency.data.model.AlertLog).\n"
                  + " Expected:\n" + _infoAlertLogs + "\n"
                  + " Found:\n" + _existingAlertLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsLocationBreadcrumbs = new HashMap<String, TableInfo.Column>(9);
        _columnsLocationBreadcrumbs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationBreadcrumbs.put("alertLogId", new TableInfo.Column("alertLogId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationBreadcrumbs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationBreadcrumbs.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationBreadcrumbs.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationBreadcrumbs.put("accuracy", new TableInfo.Column("accuracy", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationBreadcrumbs.put("batteryPercentage", new TableInfo.Column("batteryPercentage", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationBreadcrumbs.put("activity", new TableInfo.Column("activity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLocationBreadcrumbs.put("noiseDb", new TableInfo.Column("noiseDb", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLocationBreadcrumbs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLocationBreadcrumbs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLocationBreadcrumbs = new TableInfo("location_breadcrumbs", _columnsLocationBreadcrumbs, _foreignKeysLocationBreadcrumbs, _indicesLocationBreadcrumbs);
        final TableInfo _existingLocationBreadcrumbs = TableInfo.read(db, "location_breadcrumbs");
        if (!_infoLocationBreadcrumbs.equals(_existingLocationBreadcrumbs)) {
          return new RoomOpenHelper.ValidationResult(false, "location_breadcrumbs(com.aura.emergency.data.model.LocationBreadcrumb).\n"
                  + " Expected:\n" + _infoLocationBreadcrumbs + "\n"
                  + " Found:\n" + _existingLocationBreadcrumbs);
        }
        final HashMap<String, TableInfo.Column> _columnsAuditLogs = new HashMap<String, TableInfo.Column>(5);
        _columnsAuditLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAuditLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAuditLogs.put("eventType", new TableInfo.Column("eventType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAuditLogs.put("eventDescription", new TableInfo.Column("eventDescription", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAuditLogs.put("metadata", new TableInfo.Column("metadata", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAuditLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAuditLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAuditLogs = new TableInfo("audit_logs", _columnsAuditLogs, _foreignKeysAuditLogs, _indicesAuditLogs);
        final TableInfo _existingAuditLogs = TableInfo.read(db, "audit_logs");
        if (!_infoAuditLogs.equals(_existingAuditLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "audit_logs(com.aura.emergency.data.model.AuditLog).\n"
                  + " Expected:\n" + _infoAuditLogs + "\n"
                  + " Found:\n" + _existingAuditLogs);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "3709d14d63e1ea8ef41e35e2fdced37c", "1de39bcbd97d45e4028ab91bafc29734");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "contacts","alert_logs","location_breadcrumbs","audit_logs");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `contacts`");
      _db.execSQL("DELETE FROM `alert_logs`");
      _db.execSQL("DELETE FROM `location_breadcrumbs`");
      _db.execSQL("DELETE FROM `audit_logs`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ContactDao.class, ContactDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AlertLogDao.class, AlertLogDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LocationBreadcrumbDao.class, LocationBreadcrumbDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AuditLogDao.class, AuditLogDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ContactDao contactDao() {
    if (_contactDao != null) {
      return _contactDao;
    } else {
      synchronized(this) {
        if(_contactDao == null) {
          _contactDao = new ContactDao_Impl(this);
        }
        return _contactDao;
      }
    }
  }

  @Override
  public AlertLogDao alertLogDao() {
    if (_alertLogDao != null) {
      return _alertLogDao;
    } else {
      synchronized(this) {
        if(_alertLogDao == null) {
          _alertLogDao = new AlertLogDao_Impl(this);
        }
        return _alertLogDao;
      }
    }
  }

  @Override
  public LocationBreadcrumbDao locationBreadcrumbDao() {
    if (_locationBreadcrumbDao != null) {
      return _locationBreadcrumbDao;
    } else {
      synchronized(this) {
        if(_locationBreadcrumbDao == null) {
          _locationBreadcrumbDao = new LocationBreadcrumbDao_Impl(this);
        }
        return _locationBreadcrumbDao;
      }
    }
  }

  @Override
  public AuditLogDao auditLogDao() {
    if (_auditLogDao != null) {
      return _auditLogDao;
    } else {
      synchronized(this) {
        if(_auditLogDao == null) {
          _auditLogDao = new AuditLogDao_Impl(this);
        }
        return _auditLogDao;
      }
    }
  }
}
