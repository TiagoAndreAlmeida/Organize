package com.example.organize.activity.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConfig {
    public static FirebaseAuth firebaseAuth;
    public static DatabaseReference firebase;

    public static FirebaseAuth getFirebaseAuthInstance () {
        if(firebaseAuth == null) {
            firebaseAuth = FirebaseAuth.getInstance();
            return firebaseAuth;
        }
        return firebaseAuth;
    }

    public static DatabaseReference getDatabaseReference () {
        if(firebase == null) {
            firebase = FirebaseDatabase.getInstance().getReference();
            return firebase;
        }
        return firebase;
    }
}
