package com.example.organize.activity.config;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseConfig {
    public static FirebaseAuth firebaseAuth;

    public static FirebaseAuth getFirebaseAuthInstance () {
        if(firebaseAuth == null) {
            firebaseAuth = FirebaseAuth.getInstance();
            return firebaseAuth;
        }
        return firebaseAuth;
    }
}
