package com.example.spotify_clone.Activity;

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
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.CompoundButton;

import com.example.spotify_clone.ClassUtils.CommonUtils;
import com.example.spotify_clone.R;
import com.example.spotify_clone.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import java.util.Random;


public class Login_Activity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.signupBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this, Signup_Activity.class));
                finish();
            }
        });

        binding.loginContactSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.loginLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.loginEditUsernameEmail.getText().toString().trim();
                String password = binding.loginPassword.getText().toString().trim();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!password.isEmpty()) {
                        if (auth != null) {
                            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                // Đăng nhập thành công
                                                CommonUtils.showNotification(getApplicationContext(), "Đăng nhập", "Đăng nhập thành công");
                                            } else {
                                                // Xử lý khi đăng nhập thất bại
                                                Exception exception = task.getException();
                                                if (exception instanceof FirebaseAuthInvalidUserException) {
                                                    // Tài khoản không tồn tại
                                                    CommonUtils.showNotification(getApplicationContext(), "Đăng nhập", "Tài khoản không tồn tại");
                                                } else if (exception instanceof FirebaseAuthInvalidCredentialsException) {
                                                    // Sai mật khẩu
                                                    CommonUtils.showNotification(getApplicationContext(), "Đăng nhập", "Sai mật khẩu");
                                                } else {
                                                    // Xử lý các lỗi khác
                                                    CommonUtils.showNotification(getApplicationContext(), "Đăng nhập", "Đăng nhập thất bại");
                                                }
                                            }
                                        }
                                    })
                                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                        @Override
                                        public void onSuccess(AuthResult authResult) {
                                            //createNotif("Đăng nhập", "Đăng nhập thành công");
                                            CommonUtils.showNotification(getApplicationContext(), "Đăng nhập", "Đăng nhập thành công");
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            //createNotif("Đăng nhặp", "Đăng nhập thất bại");
                                        }
                                    });
                        }
                    } else {
                        binding.loginPassword.setError("Password cannot be empty");
                    }
                } else if (email.isEmpty()) {
                    binding.loginEditUsernameEmail.setError("Email cannot be empty");
                } else {
                    binding.loginEditUsernameEmail.setError("Please enter valid email");
                }

            }
        });

        binding.loginLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.loginLoginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.loginLoginApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.loginRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this, Register_Activity.class));
            }
        });


        binding.loginShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.loginPassword.setTransformationMethod(null);
                } else {
                    binding.loginPassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

    }

    public boolean checkEmail(String email) {
        return true;
    }

    public boolean checkEmailPassword(String password) {
        return true;
    }

    private void createNotif(String title, String des) {
        String id = "my_channel_id_01";
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = manager.getNotificationChannel(id);
            if (channel == null) {
                channel = new NotificationChannel(id, "Channel Title", NotificationManager.IMPORTANCE_HIGH);
                //config nofication channel
                channel.setDescription("[Channel description]");
                channel.enableVibration(true);
                channel.setVibrationPattern(new long[]{100, 1000, 200, 340});
                channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                manager.createNotificationChannel(channel);
            }
        }
        Intent notificationIntent = new Intent(this, NoficationActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id)
                .setSmallIcon(R.drawable.img_album_1)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.img_album_1))
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.img_album_1))
                        .bigLargeIcon(null))
                .setContentTitle(title)
                .setContentText(des)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[]{100, 1000, 200, 340})
                .setAutoCancel(false)//true touch on notificaiton menu dismissed, but swipe to dismiss
                .setTicker("Nofiication");
        builder.setContentIntent(contentIntent);
        NotificationManagerCompat m = NotificationManagerCompat.from(this);
        //id to generate new notification in list notifications menu
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // Yêu cầu quyền từ người dùng
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
            return;
        }

        m.notify(new Random().nextInt(), builder.build());

    }
}