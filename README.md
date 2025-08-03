# JMostr - Nostr Client Compatible with Amber for Android

JMostr is an Android client for the Nostr protocol, designed to deliver high performance, security, and full compatibility with Amber.  
Written in Kotlin, it targets the latest Android standards (SDK 34 target, min SDK 26) and follows modern best practices.

---

## Key Features

- **Login with Amber**  
  Supports authentication via NIP-07 event signing using Amber intent (`amber://sign_event`).

- **High-performance WebSocket connection**  
  Keep-alive pooling, automatic ping every 30 seconds, and exponential backoff reconnect.

- **Efficient local caching**  
  Profile metadata cached with Room database, capped at 50 MB to manage resources responsibly.

- **Lazy-loading images and videos**  
  Uses Coil 3.x for efficient and progressive media loading.

- **Customizable relay management**  
  User-editable relay list saved with DataStore for simple and secure persistence.

- **Advanced NIP DM support**  
  - NIP-04 encryption: AES-256-CBC + secp256k1 ECDH  
  - NIP-17 Gift Wrap for metadata-free private messages  
  - On-device encryption/decryption with keys never exposed in plaintext

- **Advanced video streaming**  
  ExoPlayer 2.19-based player supporting HLS/DASH (e.g. zap.stream CDN)  
  Thumbnail preload up to 720p, full resolution playback on demand.

---

## System Requirements

- **Min SDK:** 26 (Android 8.0 Oreo)  
- **Target SDK:** 34 (Android 14)  
- Fully compatible with modern Android devices.

---

## Build & Installation

### Prerequisites

- JDK 17  
- Android SDK with API 34  
- Gradle wrapper included in the project

### Build Instructions

From the project root, run:

\`\`\`bash
./gradlew assembleRelease
\`\`\`

The compiled APK will be located at:

\`\`\`
app/build/outputs/apk/release/app-release.apk
\`\`\`

### APK Signing

To sign the APK with your private key:

1. Create or use an existing keystore  
2. Configure signing data (alias, passwords) in \`gradle.properties\`  
3. Run the signed build:

\`\`\`bash
./gradlew assembleRelease
\`\`\`

---

## Project Structure

- \`app/build.gradle.kts\`: Gradle Kotlin DSL configuration  
- \`app/src/main/java/com/nostr/jmostr/\`: Kotlin source files (MainActivity, RelayManager, DMCrypto, PlayerActivity, etc.)  
- \`app/src/main/res/\`: XML resources (layouts, strings, colors, icons)  
- \`.github/workflows/build.yml\`: GitHub Actions workflow for automated build and release

---

## License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## Contact

For issues or contributions, please open an issue or pull request on the GitHub repository.

---

*Note: This project uses only open-source libraries under MIT or Apache 2.0 licenses.*
