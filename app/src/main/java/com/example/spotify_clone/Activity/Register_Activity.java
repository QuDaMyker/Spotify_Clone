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
import android.view.View;
import android.widget.CompoundButton;

import com.example.spotify_clone.ClassUtils.CommonUtils;
import com.example.spotify_clone.R;
import com.example.spotify_clone.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import java.time.LocalDate;
import java.util.Random;

public class Register_Activity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();


        binding.regBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        binding.regContactSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.regEditFullName.getText();
        binding.regEditEmail.getText();
        binding.regPassword.getText();
        binding.regConfirmPassword.getText();

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
                                    CommonUtils.showNotification(getApplicationContext(),"Đăng kí", "Đăng kí tài khoản thành công");
                                    //createNotif("Đăng kí", "Đăng kí tài khoản thành công");
                                } else {
                                    Exception exception = task.getException();
                                    if (exception instanceof FirebaseAuthException) {
                                        FirebaseAuthException firebaseAuthException = (FirebaseAuthException) exception;
                                        String errorCode = firebaseAuthException.getErrorCode();
                                        if (errorCode.equals("ERROR_EMAIL_ALREADY_IN_USE")) {
                                            // Email đã tồn tại, xử lý lỗi ở đây
                                            CommonUtils.showNotification(getApplicationContext(),"Đăng kí", "Email đã tồn tại. Vui lòng sử dụng email khác.");
                                        } else {
                                            // Xử lý các lỗi khác (nếu có)
                                            CommonUtils.showNotification(getApplicationContext(),"Đăng kí", "Đăng kí tài khoản thất bại: " + errorCode);
                                        }
                                    } else {
                                        // Xử lý các lỗi khác (nếu có)
                                        CommonUtils.showNotification(getApplicationContext(),"Đăng kí", "Đăng kí tài khoản thất bại");
                                    }
                                }


                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                               // createNotif("Đăng kí", "");
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