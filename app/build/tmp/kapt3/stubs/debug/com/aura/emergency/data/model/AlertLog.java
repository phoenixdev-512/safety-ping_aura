package com.aura.emergency.data.model;

/**
 * Alert log entity storing details of emergency alerts sent
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\bE\b\u0087\b\u0018\u00002\u00020\u0001B\u00b9\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u001aJ\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u000b\u0010A\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\t\u0010B\u001a\u00020\u000eH\u00c6\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0010H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010J\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u00101J\u0010\u0010K\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u0010\u0010M\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010.J\u000b\u0010N\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u00d8\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u00c6\u0001\u00a2\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020\u000e2\b\u0010R\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010S\u001a\u00020\u0003H\u00d6\u0001J\t\u0010T\u001a\u00020\u0010H\u00d6\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\'\u001a\u0004\u0018\u00010\u00068F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010+\u001a\u0004\b*\u0010)R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0011\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010-R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u0010/\u001a\u0004\b\r\u0010.R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010&R\u0015\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u00102\u001a\u0004\b4\u00101R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b6\u0010!R\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0011\u00108\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b9\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0019\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001f\u00a8\u0006U"}, d2 = {"Lcom/aura/emergency/data/model/AlertLog;", "", "id", "", "level", "timestamp", "", "latitude", "", "longitude", "accuracy", "", "batteryPercentage", "isCharging", "", "networkType", "", "activity", "activityConfidence", "noiseDb", "audioSnapshotPath", "isActive", "endedAt", "contactsAlerted", "responsesReceived", "triggerMethod", "(IIJLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Long;IILjava/lang/String;)V", "getAccuracy", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getActivity", "()Ljava/lang/String;", "getActivityConfidence", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAudioSnapshotPath", "getBatteryPercentage", "getContactsAlerted", "()I", "durationMs", "getDurationMs", "()Ljava/lang/Long;", "getEndedAt", "Ljava/lang/Long;", "getId", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLevel", "getLongitude", "getNetworkType", "getNoiseDb", "getResponsesReceived", "statusText", "getStatusText", "getTimestamp", "()J", "getTriggerMethod", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIJLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Long;IILjava/lang/String;)Lcom/aura/emergency/data/model/AlertLog;", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "alert_logs")
public final class AlertLog {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;
    private final int level = 0;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double latitude = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double longitude = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float accuracy = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer batteryPercentage = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isCharging = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String networkType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String activity = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer activityConfidence = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer noiseDb = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String audioSnapshotPath = null;
    private final boolean isActive = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long endedAt = null;
    private final int contactsAlerted = 0;
    private final int responsesReceived = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String triggerMethod = null;
    
    public AlertLog(int id, int level, long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.Double latitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double longitude, @org.jetbrains.annotations.Nullable()
    java.lang.Float accuracy, @org.jetbrains.annotations.Nullable()
    java.lang.Integer batteryPercentage, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isCharging, @org.jetbrains.annotations.Nullable()
    java.lang.String networkType, @org.jetbrains.annotations.Nullable()
    java.lang.String activity, @org.jetbrains.annotations.Nullable()
    java.lang.Integer activityConfidence, @org.jetbrains.annotations.Nullable()
    java.lang.Integer noiseDb, @org.jetbrains.annotations.Nullable()
    java.lang.String audioSnapshotPath, boolean isActive, @org.jetbrains.annotations.Nullable()
    java.lang.Long endedAt, int contactsAlerted, int responsesReceived, @org.jetbrains.annotations.NotNull()
    java.lang.String triggerMethod) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final int getLevel() {
        return 0;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLatitude() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getLongitude() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getAccuracy() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getBatteryPercentage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isCharging() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNetworkType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getActivityConfidence() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNoiseDb() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAudioSnapshotPath() {
        return null;
    }
    
    public final boolean isActive() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getEndedAt() {
        return null;
    }
    
    public final int getContactsAlerted() {
        return 0;
    }
    
    public final int getResponsesReceived() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTriggerMethod() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getDurationMs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatusText() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    public final boolean component14() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component15() {
        return null;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final int component17() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final long component3() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aura.emergency.data.model.AlertLog copy(int id, int level, long timestamp, @org.jetbrains.annotations.Nullable()
    java.lang.Double latitude, @org.jetbrains.annotations.Nullable()
    java.lang.Double longitude, @org.jetbrains.annotations.Nullable()
    java.lang.Float accuracy, @org.jetbrains.annotations.Nullable()
    java.lang.Integer batteryPercentage, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isCharging, @org.jetbrains.annotations.Nullable()
    java.lang.String networkType, @org.jetbrains.annotations.Nullable()
    java.lang.String activity, @org.jetbrains.annotations.Nullable()
    java.lang.Integer activityConfidence, @org.jetbrains.annotations.Nullable()
    java.lang.Integer noiseDb, @org.jetbrains.annotations.Nullable()
    java.lang.String audioSnapshotPath, boolean isActive, @org.jetbrains.annotations.Nullable()
    java.lang.Long endedAt, int contactsAlerted, int responsesReceived, @org.jetbrains.annotations.NotNull()
    java.lang.String triggerMethod) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}