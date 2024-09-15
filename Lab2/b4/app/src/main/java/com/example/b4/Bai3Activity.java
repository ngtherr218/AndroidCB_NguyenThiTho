package com.example.b4;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Bai3Activity extends AppCompatActivity {
    ImageView call;
    private static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3);

        // Gán sự kiện cho ImageView khi bấm vào biểu tượng gọi
        call = findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra quyền gọi điện đã được cấp chưa
                if (ContextCompat.checkSelfPermission(Bai3Activity.this, android.Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Nếu chưa, yêu cầu quyền
                    ActivityCompat.requestPermissions(Bai3Activity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
                } else {
                    // Nếu đã có quyền, thực hiện cuộc gọi
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "650551234"));
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE) {
            // Kiểm tra nếu quyền đã được cấp
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Quyền đã được cấp, thực hiện cuộc gọi
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0336624365"));
                startActivity(intent);
            } else {
                // Quyền bị từ chối
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                    // Người dùng đã chọn "Don't ask again"
                    // Hiển thị thông báo hoặc chuyển họ đến cài đặt ứng dụng
                    showPermissionDeniedDialog();
                } else {
                    // Quyền bị từ chối nhưng không phải là "Don't ask again"
                    // Xử lý theo cách bình thường
                }
            }
        }
    }

    // Hiển thị thông báo và chuyển đến cài đặt ứng dụng
    private void showPermissionDeniedDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Quyền bị từ chối")
                .setMessage("Bạn cần cấp quyền gọi điện trong cài đặt để tiếp tục sử dụng tính năng này.")
                .setPositiveButton("Đi tới Cài đặt", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Mở cài đặt ứng dụng để người dùng cấp quyền thủ công
                        Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Hủy", null)
                .show();
    }
}
