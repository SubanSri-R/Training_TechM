
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class DatabaseHelper {
  static final DatabaseHelper _instance = DatabaseHelper._internal();
  factory DatabaseHelper() => _instance;
  DatabaseHelper._internal();

  static Database? _database;

  Future<Database> get database async {
    if (_database != null) return _database!;
    _database = await _initDatabase();
    return _database!;
  }

  Future<Database> _initDatabase() async {
    String path = join(await getDatabasesPath(), 'medicine.db');
    return await openDatabase(
      path,
      version: 1,
      onCreate: _onCreate,
    );
  }

  Future<void> _onCreate(Database db, int version) async {
    await db.execute(''' 
      CREATE TABLE medicines (
        id INTEGER PRIMARY KEY,
        username TEXT,
        medicineName TEXT,
        days INTEGER
      )
    ''');
  }

  // Method to insert a medicine into the SQLite database
  Future<void> insertMedicine(Map<String, dynamic> medicine) async {
    final db = await database;
    await db.insert('medicines', medicine);
  }

  // Method to get the list of medicines from SQLite
  Future<List<Map<String, dynamic>>> getMedicines() async {
    final db = await database;
    return await db.query('medicines');
  }

  // Method to delete a medicine from SQLite
  Future<void> deleteMedicine(int id) async {
    final db = await database;
    await db.delete(
      'medicines',
      where: 'id = ?',
      whereArgs: [id],
    );
    print('Medicine deleted from local database');
  }

  // Method to update a medicine's days in SQLite
  Future<void> updateMedicine(Map<String, dynamic> medicineData) async {
    final db = await database;
    await db.update(
      'medicines',
      {'days': medicineData['days']},
      where: 'id = ?',
      whereArgs: [medicineData['id']],
    );
    print('Medicine updated in local database');
  }
}
