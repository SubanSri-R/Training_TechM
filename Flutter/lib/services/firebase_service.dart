
// import 'package:cloud_firestore/cloud_firestore.dart';

// class FirebaseService {
//   final FirebaseFirestore _db = FirebaseFirestore.instance;

//   // Add a new medicine to Firestore
//   Future<String> addMedicine(Map<String, dynamic> medicineData) async {
//     try {
//       // Add the new document to the 'medicines' collection
//       DocumentReference docRef = await _db.collection('medicines').add(medicineData);

//       // Return the generated document ID
//       return docRef.id;
//     } catch (e) {
//       print("Error adding medicine: $e");
//       throw e; // Rethrow to handle it in the UI
//     }
//   }
//   Future<List<Map<String, dynamic>>> getMedicines() async {
//     try {
//       // Fetch medicines from the 'medicines' collection
//       QuerySnapshot snapshot = await _db.collection('medicines').get();

//       // Convert documents to a list of maps
//       List<Map<String, dynamic>> medicines = snapshot.docs.map((doc) {
//         return {
//           'id': doc.id, // Adding doc ID
//           'username': doc['username'],
//           'medicineName': doc['medicineName'],
//           'days': doc['days'],
//         };
//       }).toList();

//       return medicines;
//     } catch (e) {
//       print("Error fetching medicines: $e");
//       throw e; // Rethrow the error to handle it in the UI
//     }
//   }

//   // Update an existing medicine in Firestore
//   Future<void> updateMedicine(Map<String, dynamic> medicineData) async {
//     try {
//       await _db.collection('medicines').doc(medicineData['id']).update(medicineData);
//     } catch (e) {
//       print("Error updating medicine: $e");
//     }
//   }

//   // Delete a medicine from Firestore
//   Future<void> deleteMedicine(String id) async {
//     try {
//       await _db.collection('medicines').doc(id).delete();
//     } catch (e) {
//       print("Error deleting medicine: $e");
//     }
//   }
// }



import 'package:cloud_firestore/cloud_firestore.dart';


class FirebaseService {
  final FirebaseFirestore _db = FirebaseFirestore.instance;

  // Add a new medicine to Firestore
  Future<String> addMedicine(Map<String, dynamic> medicineData) async {
    try {
      // Add the new document to the 'medicines' collection
      DocumentReference docRef = await _db.collection('medicines').add(medicineData);

      // Return the generated document ID
      return docRef.id;
    } catch (e) {
      print("Error adding medicine: $e");
      throw e; // Rethrow to handle it in the UI
    }
  }

  // Fetch all medicines and calculate remaining days based on the start date
  Future<List<Map<String, dynamic>>> getMedicines() async {
    try {
      // Fetch medicines from the 'medicines' collection
      QuerySnapshot snapshot = await _db.collection('medicines').get();

      List<Map<String, dynamic>> medicines = snapshot.docs.map((doc) {
        DateTime startDate = DateTime.parse(doc['startDate']); // Retrieve startDate
        DateTime currentDate = DateTime.now();
        
        // Calculate the remaining days (difference between the current date and the start date)
        int remainingDays = doc['days'] - currentDate.difference(startDate).inDays;
        if (remainingDays < 0) remainingDays = 0; // Don't allow negative days

        return {
          'id': doc.id, // Adding doc ID
          'username': doc['username'],
          'medicineName': doc['medicineName'],
          'days': remainingDays, // Use calculated remaining days
        };
      }).toList();

      return medicines;
    } catch (e) {
      print("Error fetching medicines: $e");
      throw e; // Rethrow the error to handle it in the UI
    }
  }

  // Update an existing medicine in Firestore
  Future<void> updateMedicine(Map<String, dynamic> medicineData) async {
    try {
      await _db.collection('medicines').doc(medicineData['id']).update(medicineData);
    } catch (e) {
      print("Error updating medicine: $e");
    }
  }

  // Delete a medicine from Firestore
  Future<void> deleteMedicine(String id) async {
    try {
      await _db.collection('medicines').doc(id).delete();
    } catch (e) {
      print("Error deleting medicine: $e");
    }
  }

  // Decrement remaining days for all medicines daily (this can be called by your timer logic)
  Future<void> decrementRemainingDays() async {
    try {
      // Fetch all medicines from the 'medicines' collection
      QuerySnapshot snapshot = await _db.collection('medicines').get();

      for (var doc in snapshot.docs) {
        DateTime startDate = DateTime.parse(doc['startDate']);
        DateTime currentDate = DateTime.now();
        int remainingDays = doc['days'] - currentDate.difference(startDate).inDays;

        if (remainingDays < 0) remainingDays = 0; // Don't allow negative days

        // Update the medicine document with the new remaining days
        await _db.collection('medicines').doc(doc.id).update({
          'days': remainingDays,
        });
      }
    } catch (e) {
      print("Error decrementing remaining days: $e");
    }
  }
}


