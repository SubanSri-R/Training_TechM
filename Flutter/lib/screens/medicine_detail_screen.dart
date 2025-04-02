
import 'package:flutter/material.dart';
import '../services/firebase_service.dart';

class MedicineDetailScreen extends StatelessWidget {
  final String id;
  final FirebaseService _firebaseService = FirebaseService();

  MedicineDetailScreen({required this.id});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Medicine Details")),
      body: FutureBuilder(
        future: _firebaseService.getMedicines(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          }

          if (snapshot.hasError) {
            return Center(child: Text("Error: ${snapshot.error}"));
          }

          final medicines = snapshot.data as List<Map<String, dynamic>>;
          final medicine = medicines.firstWhere((med) => med['username'] == id);

          return Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              children: [
                Text("Username: ${medicine['username']}"),
                Text("Medicine: ${medicine['medicineName']}"),
                Text("Days Remaining: ${medicine['days']}"),
                // This can be adjusted to change color when days are near 0
                medicine['days'] <= 1
                    ? Text(
                        "Last Day!",
                        style: TextStyle(color: Colors.red, fontSize: 20),
                      )
                    : Container(),
              ],
            ),
          );
        },
      ),
    );
  }
}
