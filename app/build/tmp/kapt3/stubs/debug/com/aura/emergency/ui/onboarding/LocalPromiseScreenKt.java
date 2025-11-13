package com.aura.emergency.ui.onboarding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a\"\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"LocalPromiseScreen", "", "onBack", "Lkotlin/Function0;", "onNext", "OnboardingProgressIndicator", "currentStep", "", "totalSteps", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class LocalPromiseScreenKt {
    
    /**
     * Local-Only Promise Screen - Explains privacy features
     *
     * Features:
     * - Gradient background
     * - Diagram showing phone -> encrypted SMS -> phone
     * - Privacy explanation text
     * - Progress indicator (2/5)
     * - Back and Next buttons
     */
    @androidx.compose.runtime.Composable()
    public static final void LocalPromiseScreen(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNext) {
    }
    
    /**
     * Reusable progress indicator for onboarding screens
     */
    @androidx.compose.runtime.Composable()
    public static final void OnboardingProgressIndicator(int currentStep, int totalSteps, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}