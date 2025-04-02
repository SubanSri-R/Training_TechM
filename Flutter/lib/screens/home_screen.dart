
import 'package:flutter/material.dart';
import 'dart:async'; // For Timer
import '../services/firebase_service.dart';
import '../localization/app_localizations.dart';
import 'package:flutter/services.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final FirebaseService _firebaseService = FirebaseService();
  final TextEditingController _usernameController = TextEditingController();
  final TextEditingController _medicineCountController = TextEditingController();
  List<Map<String, dynamic>> medicines = [];
  List<TextEditingController> _medicineControllers = [];
  List<TextEditingController> _daysControllers = [];
  List<int> _initialDays = [];

  Timer? _timer; // Timer to decrement days every day

  @override
  void initState() {
    super.initState();
    _startTimer(); // Start the timer when the app opens
  }

  // Start a timer to decrement the days every 24 hours
  void _startTimer() {
    _timer = Timer.periodic(Duration(days: 1), (timer) {
      setState(() {
        for (var medicine in medicines) {
          DateTime startDate = DateTime.parse(medicine['startDate']);
          DateTime currentDate = DateTime.now();
          int remainingDays = medicine['days'] - currentDate.difference(startDate).inDays;
            
          // Update the remaining days, making sure it's not negative
          if (remainingDays < 0) remainingDays = 0;

          medicine['days'] = remainingDays;

          // Update Firebase with the new days value
          _firebaseService.updateMedicine(medicine);
        }
      });
    });
  }

  // Stop the timer when the screen is disposed
  @override
  void dispose() {
    _timer?.cancel();
    super.dispose();
  }

  // Add multiple medicines
  void _addMedicines() {
    int medicineCount = int.tryParse(_medicineCountController.text) ?? 0;

    if (medicineCount < 1 || medicineCount > 5) {
      ScaffoldMessenger.of(context).showSnackBar(SnackBar(
          content: Text('Please enter a valid number of medicines (1 to 5)')));
      return;
    }

    setState(() {
      medicines.clear();
      _medicineControllers = List.generate(medicineCount, (_) => TextEditingController());
      _daysControllers = List.generate(medicineCount, (_) => TextEditingController());
      _initialDays = List.generate(medicineCount, (_) => 0);
    });
  }

  // Add a single medicine
  void _addMedicine() {
    for (int i = 0; i < _medicineControllers.length; i++) {
      if (_medicineControllers[i].text.isEmpty || _daysControllers[i].text.isEmpty) {
        ScaffoldMessenger.of(context).showSnackBar(SnackBar(
            content: Text('Please enter a medicine name and days for all medicines')));
        return;
      }

      int days = int.parse(_daysControllers[i].text);
      if (days < 5 || days > 90) {
        ScaffoldMessenger.of(context).showSnackBar(SnackBar(
            content: Text('Please enter a valid number of days (5 to 90)')));
        return;
      }

      DateTime startDate = DateTime.now(); // Capture the current date as the start date.

      setState(() {
        medicines.add({
          'username': _usernameController.text,
          'medicineName': _medicineControllers[i].text,
          'days': days,
          'startDate': startDate.toIso8601String(), // Save start date as ISO string
          'id': '', // Initially empty ID; we will update it later
        });

        // Store the initial days when the medicine is added
        _initialDays.add(days);
      });

      // Add medicine to Firebase
      _firebaseService.addMedicine({
        'username': _usernameController.text,
        'medicineName': _medicineControllers[i].text,
        'days': days,
        'startDate': startDate.toIso8601String(), // Save start date to Firebase
      }).then((docId) {
        // After adding to Firestore, update the medicine with the generated docId
        setState(() {
          medicines[i]['id'] = docId;
        });
      });
    }

    // Clear text controllers after adding medicines
    _medicineControllers.clear();
    _daysControllers.clear();
    _medicineCountController.clear();
  }

  // Show dialog to enter new days manually
  Future<void> _showAddDaysDialog(int index) async {
    TextEditingController _newDaysController = TextEditingController();

    return showDialog<void>(
      context: context,
      barrierDismissible: false, // Dialog can't be dismissed by tapping outside
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Enter New Days for Medicine'),
          content: TextField(
            controller: _newDaysController,
            decoration: InputDecoration(labelText: 'Enter Days'),
            keyboardType: TextInputType.number,
            inputFormatters: [FilteringTextInputFormatter.digitsOnly], // Ensure only numbers
          ),
          actions: <Widget>[
            TextButton(
              child: Text('Cancel'),
              onPressed: () {
                Navigator.of(context).pop(); // Close the dialog
              },
            ),
            TextButton(
              child: Text('Update'),
              onPressed: () {
                // Validate and update the days
                int newDays = int.tryParse(_newDaysController.text) ?? 0;
                if (newDays >= 5 && newDays <= 90) {
                  setState(() {
                    medicines[index]['days'] = newDays;
                    _initialDays[index] = newDays; // Update initial days
                  });

                  // Update medicine in Firebase
                  _firebaseService.updateMedicine(medicines[index]);

                  Navigator.of(context).pop(); // Close the dialog
                } else {
                  ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                      content: Text('Please enter a valid number of days (5 to 90)')));
                }
              },
            ),
          ],
        );
      },
    );
  }

  // Delete a medicine from the list
  void _deleteMedicine(int index) {
    setState(() {
      medicines.removeAt(index);
      _initialDays.removeAt(index); // Remove corresponding initial days
    });

    // Call Firebase to delete the data
    _firebaseService.deleteMedicine(medicines[index]['id']);
  }

  // Calculate the color based on the remaining days percentage
  Color _getCardColor(int remainingDays, int initialDays) {
    double remainingPercentage = (remainingDays / initialDays) * 100;

    if (remainingPercentage > 50) {
      return Colors.green; // More than 50% days remaining -> Green
    } else if (remainingPercentage > 20) {
      return Colors.orange; // 20%-50% days remaining -> Orange
    } else {
      return Colors.red; // Less than 20% days remaining -> Red
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Row(
          children: [
            Image.network('https://th.bing.com/th/id/OIP.SDoWn-i1eOMge-fughIVYAHaFj?w=249&h=187&c=7&r=0&o=5&dpr=1.3&pid=1.7', height: 40), // Logo
            SizedBox(width: 10),
            Text(AppLocalizations.of(context)!.enterMedicine),
          ],
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            // Username input field
            TextField(
              controller: _usernameController,
              decoration: InputDecoration(
                  labelText: AppLocalizations.of(context)!.enterUsername),
            ),
            // Enter number of medicines
            TextField(
              controller: _medicineCountController,
              decoration: InputDecoration(
                  labelText: 'Enter number of medicines (1 to 5)'),
              keyboardType: TextInputType.number,
            ),
            // Button to proceed with adding medicines
            ElevatedButton(
              onPressed: _addMedicines,
              child: Text('Add Medicines'),
            ),
            // Dynamic fields for medicines and days
            if (_medicineControllers.isNotEmpty) ...[
              ...List.generate(_medicineControllers.length, (index) {
                return Column(
                  children: [
                    TextField(
                      controller: _medicineControllers[index],
                      decoration: InputDecoration(
                          labelText: 'Enter Medicine Name ${index + 1}'),
                    ),
                    TextField(
                      controller: _daysControllers[index],
                      decoration: InputDecoration(
                          labelText: 'Enter Days for Medicine ${index + 1}'),
                      keyboardType: TextInputType.number,
                    ),
                  ],
                );
              }),
              ElevatedButton(
                onPressed: _addMedicine,
                child: Text(AppLocalizations.of(context)!.addMedicine),
              ),
            ],
            // Medicine List
            Expanded(
              child: ListView.builder(
                itemCount: medicines.length,
                itemBuilder: (context, index) {
                  final medicine = medicines[index];
                  DateTime startDate = DateTime.parse(medicine['startDate']);
                  DateTime currentDate = DateTime.now();
                  int remainingDays = medicine['days'] - currentDate.difference(startDate).inDays;

                  if (remainingDays < 0) remainingDays = 0;

                  return Card(
                    color: _getCardColor(remainingDays, _initialDays[index]), // Set color based on remaining percentage
                    child: ListTile(
                      title: Text(medicine['username']),
                      subtitle: Text('Days remaining: $remainingDays'),
                      onTap: () {
                        showDialog(
                          context: context,
                          builder: (_) => AlertDialog(
                            title: Text(medicine['medicineName']),
                            content: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text('Medicine: ${medicine['medicineName']}'),
                                Text('Days remaining: $remainingDays'),
                              ],
                            ),
                            actions: [
                              ElevatedButton(
                                onPressed: () => _showAddDaysDialog(index), // Open the dialog to update days
                                child: Text('Update Days'),
                              ),
                              ElevatedButton(
                                onPressed: () => _deleteMedicine(index),
                                child: Text('Delete Medicine'),
                              ),
                            ],
                          ),
                        );
                      },
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
