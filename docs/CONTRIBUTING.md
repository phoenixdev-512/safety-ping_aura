# Contributing to Aura

Thank you for your interest in contributing to Aura. This document provides guidelines and instructions for contributing to the project.

---

## Table of Contents

1. [Code of Conduct](#code-of-conduct)
2. [Getting Started](#getting-started)
3. [Development Setup](#development-setup)
4. [Making Changes](#making-changes)
5. [Coding Standards](#coding-standards)
6. [Testing Requirements](#testing-requirements)
7. [Submitting Changes](#submitting-changes)
8. [Review Process](#review-process)

---

## Code of Conduct

### Our Standards

Contributors are expected to:

- Use welcoming and inclusive language
- Respect differing viewpoints and experiences
- Accept constructive criticism gracefully
- Focus on what is best for the community
- Show empathy towards other community members

### Unacceptable Behavior

- Harassment or discriminatory comments
- Trolling or inflammatory remarks
- Personal or political attacks
- Publishing private information without permission
- Unprofessional conduct

---

## Getting Started

### Prerequisites

Before contributing, ensure you have:

- Android Studio Hedgehog (2023.1.1) or later
- JDK 11 or higher
- Android SDK with API levels 26-35
- Git for version control
- Basic understanding of Kotlin and Android development

### Finding Issues to Work On

1. Browse the issue tracker
2. Look for issues labeled "good first issue" or "help wanted"
3. Read existing comments and discussions
4. Ask questions if requirements are unclear

### Claiming an Issue

Before starting work:

1. Comment on the issue expressing interest
2. Wait for maintainer acknowledgment
3. Fork the repository
4. Create a feature branch

---

## Development Setup

### 1. Fork and Clone

```bash
# Fork the repository on GitHub
# Then clone your fork
git clone https://github.com/YOUR_USERNAME/safety-ping_aura.git
cd safety-ping_aura

# Add upstream remote
git remote add upstream https://github.com/phoenixdev-512/safety-ping_aura.git
```

### 2. Configure Git

```bash
git config user.name "Your Name"
git config user.email "your.email@example.com"
```

### 3. Open in Android Studio

1. Open Android Studio
2. Select "Open an Existing Project"
3. Navigate to cloned directory
4. Wait for Gradle sync to complete

### 4. Verify Setup

```bash
# Run tests to verify setup
./gradlew test

# Build debug APK
./gradlew assembleDebug
```

---

## Making Changes

### Branch Naming Convention

Use descriptive branch names:

- `feature/add-geofencing` - New features
- `fix/panic-button-crash` - Bug fixes
- `docs/update-readme` - Documentation
- `refactor/encryption-util` - Code refactoring
- `test/add-viewmodel-tests` - Adding tests

### Creating a Branch

```bash
# Update main branch
git checkout main
git pull upstream main

# Create feature branch
git checkout -b feature/your-feature-name
```

### Making Commits

#### Commit Message Format

```
<type>: <subject>

<body>

<footer>
```

**Types**:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Build process or tooling changes

**Example**:
```
feat: Add geofencing capability

Implement geofencing using Google Play Services Location API.
Users can now set up location-based automatic alerts.

Closes #123
```

#### Commit Best Practices

- Make atomic commits (one logical change per commit)
- Write clear, descriptive commit messages
- Reference issue numbers when applicable
- Keep commits focused and small

---

## Coding Standards

### Kotlin Style Guide

Follow the [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html):

#### Naming

```kotlin
// Classes: PascalCase
class ContactRepository

// Functions: camelCase
fun encryptMessage()

// Properties: camelCase
val encryptionKey: String

// Constants: UPPER_SNAKE_CASE
const val MAX_RETRY_ATTEMPTS = 3

// Private properties: prefix with underscore (optional)
private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
val contacts = _contacts.asStateFlow()
```

#### Code Organization

```kotlin
class ExampleClass {
    // Companion object
    companion object {
        const val TAG = "ExampleClass"
    }
    
    // Properties
    private val repository: Repository
    
    // Initialization blocks
    init {
        // Initialization code
    }
    
    // Public methods
    fun publicMethod() { }
    
    // Private methods
    private fun privateMethod() { }
}
```

#### Function Length

- Keep functions focused and concise
- Maximum 50 lines per function
- Extract complex logic into helper functions
- Use descriptive names

### XML Resources

#### Layout Files

```xml
<!-- Use snake_case for IDs -->
<Button
    android:id="@+id/panic_button"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="@string/panic_button_text" />
```

#### String Resources

```xml
<!-- Use snake_case for names -->
<string name="alert_sent_success">Alert sent successfully</string>
<string name="error_no_contacts">No trusted contacts found</string>
```

### Jetpack Compose

#### Composable Naming

```kotlin
// Composables: PascalCase
@Composable
fun DashboardScreen() { }

// Preview functions: PascalCase with Preview suffix
@Preview
@Composable
fun DashboardScreenPreview() { }
```

#### State Management

```kotlin
// Use remember for UI state
var expanded by remember { mutableStateOf(false) }

// Use ViewModel for business logic state
val uiState by viewModel.uiState.collectAsState()
```

---

## Testing Requirements

### Test Coverage

All code changes must include appropriate tests:

- **Unit Tests**: For ViewModels, repositories, utilities
- **Integration Tests**: For database operations, encryption
- **UI Tests**: For user-facing features

### Writing Tests

#### Unit Test Example

```kotlin
class EncryptionUtilTest {
    @Test
    fun `encrypt and decrypt returns original message`() {
        val original = "Test message"
        val publicKey = generateTestPublicKey()
        val privateKey = generateTestPrivateKey()
        
        val encrypted = EncryptionUtil.encrypt(original, publicKey)
        val decrypted = EncryptionUtil.decrypt(encrypted, privateKey)
        
        assertEquals(original, decrypted)
    }
}
```

#### UI Test Example

```kotlin
class DashboardScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun panicButtonIsDisplayed() {
        composeTestRule.setContent {
            DashboardScreen()
        }
        
        composeTestRule
            .onNodeWithText("HOLD FOR HELP")
            .assertIsDisplayed()
    }
}
```

### Running Tests

```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests EncryptionUtilTest

# Run with coverage
./gradlew testDebugUnitTestCoverage
```

### Test Requirements

- All new features must have tests
- Bug fixes must include regression tests
- Maintain minimum 80% code coverage
- Tests must be deterministic and reliable

---

## Submitting Changes

### Before Submitting

1. **Update from Upstream**
   ```bash
   git checkout main
   git pull upstream main
   git checkout feature/your-feature
   git rebase main
   ```

2. **Run All Checks**
   ```bash
   # Run tests
   ./gradlew test
   
   # Check code style
   ./gradlew ktlintCheck
   
   # Build project
   ./gradlew assembleDebug
   ```

3. **Update Documentation**
   - Update README if needed
   - Add/update code comments
   - Update relevant documentation files

### Creating Pull Request

1. **Push to Your Fork**
   ```bash
   git push origin feature/your-feature
   ```

2. **Open Pull Request**
   - Go to GitHub repository
   - Click "New Pull Request"
   - Select your branch
   - Fill in PR template

3. **PR Description Should Include**
   - Clear description of changes
   - Motivation for changes
   - Screenshots for UI changes
   - Related issue numbers
   - Testing performed

### Pull Request Template

```markdown
## Description
Brief description of changes

## Motivation
Why are these changes needed?

## Changes Made
- Change 1
- Change 2

## Testing
- [ ] Unit tests added/updated
- [ ] UI tests added/updated
- [ ] Manual testing completed

## Screenshots
(if applicable)

## Related Issues
Closes #123
```

---

## Review Process

### What to Expect

1. **Initial Review**: Within 2-3 business days
2. **Feedback**: Maintainers may request changes
3. **Discussion**: Be prepared to discuss design decisions
4. **Approval**: At least one maintainer approval required

### Responding to Feedback

- Address all comments
- Be open to suggestions
- Ask questions if unclear
- Push additional commits for changes
- Mark conversations as resolved when addressed

### Merge Requirements

Before merging, PRs must:

- Pass all automated tests
- Meet code style requirements
- Have maintainer approval
- Be up to date with main branch
- Have clear, descriptive commits

---

## Development Guidelines

### Security Considerations

- Never commit API keys or secrets
- Use Android Keystore for sensitive data
- Validate all user inputs
- Follow OWASP Mobile Security guidelines
- Perform security review for encryption changes

### Performance Guidelines

- Avoid blocking main thread
- Use coroutines for async operations
- Optimize database queries
- Minimize memory allocations
- Profile performance-critical code

### Accessibility

- Provide content descriptions for images
- Ensure sufficient color contrast
- Support TalkBack screen reader
- Make interactive elements touchable (48dp minimum)
- Test with accessibility features enabled

### Privacy

- Minimize data collection
- Encrypt sensitive data
- Follow privacy by design principles
- Document data handling in privacy policy
- Obtain user consent where required

---

## Additional Resources

### Documentation

- [Android Developer Guide](https://developer.android.com/guide)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Jetpack Compose Guide](https://developer.android.com/jetpack/compose)
- [Material Design 3](https://m3.material.io/)

### Tools

- [Android Studio](https://developer.android.com/studio)
- [ktlint](https://ktlint.github.io/) - Kotlin linter
- [detekt](https://detekt.github.io/detekt/) - Code analysis

### Community

- GitHub Issues: Bug reports and feature requests
- GitHub Discussions: General questions and ideas
- Pull Requests: Code contributions

---

## Questions?

If you have questions not covered in this guide:

1. Check existing documentation
2. Search closed issues and PRs
3. Open a new discussion on GitHub
4. Tag maintainers if urgent

---

## License

By contributing to Aura, you agree that your contributions will be licensed under the same license as the project.

---

**Thank you for contributing to Aura!**

Your contributions help make privacy-focused emergency communication accessible to everyone.

---

**Document Version**: 1.0  
**Last Updated**: November 2024
