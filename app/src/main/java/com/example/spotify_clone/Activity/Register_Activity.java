package com.example.spotify_clone.Activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.spotify_clone.ClassUtils.CommonUtils;
import com.example.spotify_clone.OOP.Account;
import com.example.spotify_clone.R;
import com.example.spotify_clone.databinding.ActivityRegisterBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.util.Random;

public class Register_Activity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private ActivityRegisterBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    GoogleSignInClient mGoogleSignInClient;
    ActivityResultLauncher<Intent> signInLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //clearLoginState();
        progressDialog = new ProgressDialog(Register_Activity.this);
        progressDialog.setTitle("Creating account");


        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        signInLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

                            try {
                                GoogleSignInAccount account = task.getResult(ApiException.class);
                                firebaseAuth(account.getIdToken());
                            } catch (ApiException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        binding.regBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
            }
        });

        binding.regContactSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.regLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.regRegFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.regRegGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        binding.regRegApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.regRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkValidData()) {
                    String fullName = binding.regEditFullName.getText().toString().trim();
                    String email = binding.regEditEmail.getText().toString().trim();
                    String password = binding.regPassword.getText().toString().trim();

                    String dateCreatedAccount = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        LocalDate currentDate = LocalDate.now();
                        dateCreatedAccount = currentDate.toString();
                    } else {
                        dateCreatedAccount = "2023-01-01";
                    }
                    String dateRegPremium = null;
                    boolean isPremium = false;


                    if (auth != null) {
                        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    CommonUtils.showNotification(getApplicationContext(), "Đăng kí", "Đăng kí tài khoản thành công");

                                    String dateCreatedAccount = null;
                                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                                        LocalDate currentDate = LocalDate.now();
                                        dateCreatedAccount = currentDate.toString();
                                    } else {
                                        dateCreatedAccount = "2023-01-01";
                                    }
                                    String dateRegPremium = "2003-01-01";
                                    boolean isPremium = false;

                                    FirebaseUser user = auth.getCurrentUser();
                                    Account account = new Account();
                                    account.setID(user.getUid());
                                    account.setFullName(binding.regEditFullName.getText().toString().trim());
                                    account.setEmail(binding.regEditEmail.getText().toString().trim());
                                    account.setPassword(binding.regPassword.getText().toString().trim());
                                    account.setDateCreatedAccount(dateCreatedAccount);
                                    account.setDateRegPremium(dateRegPremium);
                                    account.setPremium(isPremium);
                                    account.setImageProfile("null");

                                    database.getReference().child("List Account").child(user.getUid()).setValue(account);
                                    Intent intent = new Intent(Register_Activity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Exception exception = task.getException();
                                    if (exception instanceof FirebaseAuthException) {
                                        FirebaseAuthException firebaseAuthException = (FirebaseAuthException) exception;
                                        String errorCode = firebaseAuthException.getErrorCode();
                                        if (errorCode.equals("ERROR_EMAIL_ALREADY_IN_USE")) {
                                            // Email đã tồn tại, xử lý lỗi ở đây
                                            CommonUtils.showNotification(getApplicationContext(), "Đăng kí", "Email đã tồn tại. Vui lòng sử dụng email khác.");
                                        } else {
                                            // Xử lý các lỗi khác (nếu có)
                                            CommonUtils.showNotification(getApplicationContext(), "Đăng kí", "Đăng kí tài khoản thất bại: " + errorCode);
                                        }
                                    } else {
                                        // Xử lý các lỗi khác (nếu có)
                                        CommonUtils.showNotification(getApplicationContext(), "Đăng kí", "Đăng kí tài khoản thất bại");
                                    }
                                }


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
                    }
                }
            }
        });

        binding.regShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.regPassword.setTransformationMethod(null);
                    binding.regConfirmPassword.setTransformationMethod(null);
                } else {
                    binding.regPassword.setTransformationMethod(new PasswordTransformationMethod());
                    binding.regConfirmPassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });
    }

    private void signIn() {
        Intent intent = mGoogleSignInClient.getSignInIntent();
        signInLauncher.launch(intent);
    }

    private void firebaseAuth(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isComplete()) {
                            FirebaseUser user = auth.getCurrentUser();

                            CommonUtils.showNotification(Register_Activity.this, "Thong bao", "Thanh cong");
//                            Users users = new Users();
//                            users.setUserID(user.getUid());
//                            users.setName(user.getDisplayName());
//                            users.setProfile(user.getPhotoUrl().toString());
//
//                            database.getReference().child("Users").child(user.getUid()).setValue(users);
//                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                            startActivity(intent);
                        } else {
                            Toast.makeText(Register_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean checkValidData() {
        boolean flag = false;
        if (binding.regEditFullName.getText().toString().trim().isEmpty()) {
            flag = false;
            binding.regEditFullName.setError("Fullname cannot be empty");
        } else {
            flag = true;
        }
        if (!binding.regEditEmail.getText().toString().trim().isEmpty()) {
            if (binding.regEditEmail.getText().toString().contains("@")) {
                flag = true;
            } else {
                flag = false;
                binding.regEditEmail.setError("Invalid Email");
            }
        } else {
            flag = false;
            binding.regEditEmail.setError("Email cannot be empty");
        }
        if (binding.regPassword.getText().toString().trim().isEmpty() && binding.regPassword.getText().toString().trim().length() < 8) {
            flag = false;
            binding.regPassword.setError("Password cannot be empty, Limit length is 8");
        } else {
            flag = true;
        }
        if (binding.regConfirmPassword.getText().toString().trim().isEmpty() && binding.regConfirmPassword.getText().toString().trim().length() < 8) {
            flag = false;
            binding.regConfirmPassword.setError("Confirm Password cannot be empty, Limit length is 8");
        } else {
            flag = true;
            if (!binding.regPassword.getText().toString().trim().isEmpty()) {
                if (binding.regPassword.getText().toString().trim().equals(binding.regConfirmPassword.getText().toString().trim())) {
                    flag = true;
                } else {
                    flag = false;
                    binding.regPassword.setError("Password not matching");
                    binding.regConfirmPassword.setError("Confirm Password not matching");
                }
            }
        }
        return flag;
    }

}