package com.aura.emergency.ui.onboarding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0003\u001a2\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u00a8\u0006\u000e"}, d2 = {"PermissionCard", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "title", "", "description", "isGranted", "", "PermissionsScreen", "onBack", "Lkotlin/Function0;", "onNext", "onSkip", "app_debug"})
public final class PermissionsScreenKt {
    
    /**
     * Permission Request Screen - Requests SMS and Location permissions
     *
     * Features:
     * - Two permission cards (SMS, Location)
     * - Clear explanation for each permission
     * - Warning about app functionality
     * - Progress indicator (3/5)
     * - Grant permissions button
     */
    @kotlin.OptIn(markerClass = {com.google.accompanist.permissions.ExperimentalPermissionsApi.class})
    @androidx.compose.runtime.Composable()
    public static final void PermissionsScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNext, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSkip) {
    }
    
    /**
     * Permission card component
     */
    @androidx.compose.runtime.Composable()
    private static final void PermissionCard(androidx.compose.ui.graphics.vector.ImageVector icon, java.lang.String title, java.lang.String description, boolean isGranted) {
    }
}