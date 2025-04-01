import 'package:flutter/material.dart';
import 'home_screen.dart';
import '../main.dart';

class LanguageSelectionScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Select Language"),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          ElevatedButton(
            onPressed: () {
              Locale myLocale = Locale('en', '');
              MyApp.setLocale(context, myLocale);
              Navigator.pushReplacement(
                context,
                MaterialPageRoute(builder: (context) => HomeScreen()),
              );
            },
            child: Text('English'),
          ),
          ElevatedButton(
            onPressed: () {
              Locale myLocale = Locale('ta', '');
              MyApp.setLocale(context, myLocale);
              Navigator.pushReplacement(
                context,
                MaterialPageRoute(builder: (context) => HomeScreen()),
              );
            },
            child: Text('Tamil'),
          ),
          ElevatedButton(
            onPressed: () {
              Locale myLocale = Locale('hi', '');
              MyApp.setLocale(context, myLocale);
              Navigator.pushReplacement(
                context,
                MaterialPageRoute(builder: (context) => HomeScreen()),
              );
            },
            child: Text('Hindi'),
          ),
        ],
      ),
    );
  }
}

