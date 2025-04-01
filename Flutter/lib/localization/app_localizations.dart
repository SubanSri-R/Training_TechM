
import 'package:flutter/material.dart';

class AppLocalizations {
  static const LocalizationsDelegate<AppLocalizations> delegate = _AppLocalizationsDelegate();
  final Locale locale;

  AppLocalizations(this.locale);

  // Method to access the correct localized strings based on the locale
  static AppLocalizations? of(BuildContext context) {
    return Localizations.of<AppLocalizations>(context, AppLocalizations);
  }

  // Localized strings for different languages
  String get enterUsername {
    switch (locale.languageCode) {
      case 'ta': // Tamil
        return 'பயனர் பெயர் உள்ளிடவும்';
      case 'hi': // Hindi
        return 'उपयोगकर्ता नाम दर्ज करें';
      default: // English (default)
        return 'Enter Username';
    }
  }

  String get enterMedicine {
    switch (locale.languageCode) {
      case 'ta': // Tamil
        return 'மருந்து பெயர் உள்ளிடவும்';
      case 'hi': // Hindi
        return 'दवा का नाम दर्ज करें';
      default: // English (default)
        return 'Enter Medicine';
    }
  }

  String get enterDays {
    switch (locale.languageCode) {
      case 'ta': // Tamil
        return 'நாட்கள் உள்ளிடவும்';
      case 'hi': // Hindi
        return 'दिनों की संख्या दर्ज करें';
      default: // English (default)
        return 'Enter Days';
    }
  }

  String get addMedicine {
    switch (locale.languageCode) {
      case 'ta': // Tamil
        return 'மருந்து சேர்க்கவும்';
      case 'hi': // Hindi
        return 'दवा जोड़ें';
      default: // English (default)
        return 'Add Medicine';
    }
  }

  String get deleteMedicine {
    switch (locale.languageCode) {
      case 'ta': // Tamil
        return 'மருந்து நீக்கவும்';
      case 'hi': // Hindi
        return 'दवा हटाएं';
      default: // English (default)
        return 'Delete Medicine';
    }
  }

  String get addMoreDays {
    switch (locale.languageCode) {
      case 'ta': // Tamil
        return 'மேலும் நாட்கள் சேர்க்கவும்';
      case 'hi': // Hindi
        return 'अधिक दिन जोड़ें';
      default: // English (default)
        return 'Add More Days';
    }
  }

  // You can add more strings here for different parts of your app...
}

class _AppLocalizationsDelegate extends LocalizationsDelegate<AppLocalizations> {
  const _AppLocalizationsDelegate();

  @override
  bool isSupported(Locale locale) {
    // Check if the language is supported
    return ['en', 'ta', 'hi'].contains(locale.languageCode);
  }

  @override
  Future<AppLocalizations> load(Locale locale) async {
    // Load the appropriate localization for the selected locale
    return AppLocalizations(locale);
  }

  @override
  bool shouldReload(covariant LocalizationsDelegate<AppLocalizations> old) {
    return false;
  }
}
