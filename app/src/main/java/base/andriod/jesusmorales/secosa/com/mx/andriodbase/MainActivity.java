package base.andriod.jesusmorales.secosa.com.mx.andriodbase;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends Activity {

    //static final String FIREBASE_URL = "https://jesusproject-c4312.firebaseio.com/";
    String child = "Prueba";
    EditText textoCaptura;
    Button submitButton;
    DatabaseReference database;
    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoCaptura = (EditText) findViewById(R.id.textoApp);
        submitButton = findViewById(R.id.button2);
        database = FirebaseDatabase.getInstance().getReference();
        database.child(child);
        mAuth = FirebaseAuth.getInstance();
        validate();
    }

    public void enviarTexto(View view) {
        database.setValue(textoCaptura.getText().toString());
        Toast.makeText(MainActivity.this, "Buen trabajo",
                Toast.LENGTH_SHORT).show();
        //Por si las flies
        //database.setValue("Otro texto");

    }

    private void validate(){
        // [START sign_in_with_email]
        //mAuth.signInWithCustomToken("lACCZdGMNKeGAGQRugBB05DGiSn1");
        mAuth.signInAnonymously();
        /*
        mAuth.signInWithEmailAndPassword("jjmoralesm@scotiabank.com.mx", "ScotiaBank1")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                            submitButton.setEnabled(false);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            submitButton.setEnabled(false);

                        }

                        // [START_EXCLUDE]
                        //if (!task.isSuccessful()) {
                         //   submitButton.setEnabled(true);
                        //}

                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
        */
    }

}
