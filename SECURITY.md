# Security Policy

## Supported Versions

The following versions of Aura are currently supported with security updates:

| Version | Supported          |
| ------- | ------------------ |
| 1.0.x   | :white_check_mark: |
| < 1.0   | :x:                |

## Security Architecture

Aura is designed with security and privacy as primary concerns:

### Encryption Standards

- **Database Encryption**: AES-256 via SQLCipher
- **Message Encryption**: AEAD (Authenticated Encryption with Associated Data) via Google Tink
- **Key Storage**: Android Keystore with hardware-backed security when available

### Privacy Principles

- Zero cloud dependency
- No data collection or telemetry
- Local-only processing
- Open source for transparency

## Reporting a Vulnerability

We take security vulnerabilities seriously. If you discover a security issue in Aura, please follow responsible disclosure practices.

### How to Report

**DO NOT** create a public GitHub issue for security vulnerabilities.

Instead, please report security issues by:

1. **Email**: Send details to the repository maintainer via GitHub
2. **Include**:
   - Description of the vulnerability
   - Steps to reproduce
   - Potential impact
   - Suggested fix (if available)
   - Your contact information for follow-up

### What to Expect

1. **Acknowledgment**: Within 48 hours of your report
2. **Assessment**: Initial assessment within 5 business days
3. **Updates**: Regular updates on progress every 7 days
4. **Resolution**: Fix deployed as soon as possible based on severity
5. **Credit**: Public acknowledgment in release notes (if desired)

### Severity Levels

**Critical**
- Remote code execution
- Unauthorized access to encrypted data
- Key compromise vulnerabilities
- Response time: 24-48 hours

**High**
- Data leakage
- Authentication bypass
- Privilege escalation
- Response time: 3-5 days

**Medium**
- Information disclosure
- Denial of service
- Cross-site scripting equivalent
- Response time: 7-14 days

**Low**
- Minor information leaks
- Non-exploitable bugs
- Response time: 14-30 days

## Security Best Practices for Users

To maximize security when using Aura:

1. **Device Security**
   - Use strong device lock screen (PIN, pattern, or biometric)
   - Keep Android OS updated
   - Enable device encryption

2. **Application Security**
   - Keep Aura updated to latest version
   - Grant only necessary permissions
   - Verify contact identities during key exchange
   - Enable duress PIN in high-risk situations

3. **Key Exchange**
   - Perform key exchange in person when possible
   - Verify security codes over voice/video call
   - Never share security codes via text or email
   - Re-exchange keys if compromise suspected

4. **Regular Maintenance**
   - Review trusted contacts list monthly
   - Check audit logs for unexpected activity
   - Test emergency features regularly
   - Rotate encryption keys periodically

## Security Features

### Current Implementation

- AES-256 database encryption
- End-to-end message encryption
- Hardware-backed key storage
- Audit logging
- No network communication (SMS only)

### Planned Enhancements

- Automatic key rotation
- Enhanced key attestation
- Secure key backup and recovery
- Additional encryption algorithm options
- Root detection and alerts

## Known Security Considerations

### Design Limitations

1. **SMS as Transport**
   - SMS is not inherently secure
   - Messages are encrypted before sending
   - Metadata (phone numbers, timestamps) visible to carrier

2. **Physical Device Access**
   - Physical access to unlocked device compromises security
   - Use strong device lock screen
   - Consider stealth features for high-risk scenarios

3. **Contact Verification**
   - Security depends on proper key exchange
   - Users must verify contact identities
   - No central authority for identity verification

### Mitigation Strategies

- All messages encrypted end-to-end
- Keys stored in Android Keystore
- Audit logs track all security events
- Duress PIN provides plausible deniability
- Optional stealth mode for high-risk users

## Security Audit History

| Date | Auditor | Scope | Findings | Status |
|------|---------|-------|----------|--------|
| TBD  | TBD     | TBD   | TBD      | Planned|

We welcome security audits from the community. If you perform a security audit, please share your findings responsibly.

## Bug Bounty Program

Currently, Aura does not have a formal bug bounty program. However, we greatly appreciate security researchers who responsibly disclose vulnerabilities.

Recognition for security contributions:
- Public acknowledgment in release notes
- Credit in CHANGELOG.md
- Featured in security advisories

## Security-Related Configuration

### Recommended Settings

For maximum security, configure:

- **Triggers**: Multiple trigger methods for redundancy
- **Encryption**: Enable automatic key rotation
- **Privacy**: Shortest data retention period acceptable
- **Audit**: Enable comprehensive audit logging
- **Authentication**: Enable biometric app lock

### Security Checklist

Before deploying Aura for critical use:

- [ ] Complete key exchange with all contacts
- [ ] Verify all security codes
- [ ] Test emergency triggers
- [ ] Review audit logs
- [ ] Enable duress PIN
- [ ] Configure automatic key rotation
- [ ] Set up data retention policies
- [ ] Test alert sending and receiving
- [ ] Review permissions granted
- [ ] Enable device encryption

## Compliance

Aura is designed to be compliant with:

- General Data Protection Regulation (GDPR) through local-only processing
- Privacy by Design principles
- Industry standard encryption practices
- Open source transparency requirements

## Contact

For security-related questions or concerns:

- Review documentation in `docs/` directory
- Check GitHub issues for known security topics
- Contact maintainers through GitHub

---

**Last Updated**: November 2024  
**Version**: 1.0
