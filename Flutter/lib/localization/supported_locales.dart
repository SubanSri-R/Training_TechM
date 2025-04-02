
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'app_localizations.dart';

List<Locale> supportedLocales = [
  Locale('en', ''),  // English
  Locale('ta', ''),  // Tamil
  Locale('hi', ''),  // Hindi
];

List<LocalizationsDelegate> localizationsDelegates = [
  GlobalMaterialLocalizations.delegate,
  GlobalWidgetsLocalizations.delegate,
  AppLocalizations.delegate, // Custom localization delegate
];
