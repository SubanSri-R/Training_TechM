class Medicine {
  String username;
  String medicineName;
  int days;
  String id;

  Medicine({required this.username, required this.medicineName, required this.days, required this.id});

  factory Medicine.fromMap(Map<String, dynamic> data) {
    return Medicine(
      username: data['username'],
      medicineName: data['medicineName'],
      days: data['days'],
      id: data['id'],
    );
  }

  Map<String, dynamic> toMap() {
    return {
      'username': username,
      'medicineName': medicineName,
      'days': days,
      'id': id,
    };
  }
}
