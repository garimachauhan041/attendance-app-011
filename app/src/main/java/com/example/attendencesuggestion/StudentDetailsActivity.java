package com.example.attendencesuggestion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentDetailsActivity extends AppCompatActivity {

    // Declare variables
    EditText etName, etCourse, etSemester, etUniversity;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable full screen layout
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_student_details);

        // Initialize views
        etName = findViewById(R.id.etName);
        etCourse = findViewById(R.id.etCourse);
        etSemester = findViewById(R.id.etSemester);
        etUniversity = findViewById(R.id.etUniversity);
        btnContinue = findViewById(R.id.btnContinue);

        // Button click event
        btnContinue.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String course = etCourse.getText().toString().trim();
            String semester = etSemester.getText().toString().trim();
            String university = etUniversity.getText().toString().trim();

            // Validation
            if(name.isEmpty()){
                etName.setError("Enter your name");
                return;
            }

            if(course.isEmpty()){
                etCourse.setError("Enter course");
                return;
            }

            if(semester.isEmpty()){
                etSemester.setError("Enter semester");
                return;
            }

            if(university.isEmpty()){
                etUniversity.setError("Enter university");
                return;
            }

            // Move to next page
            Intent intent = new Intent(
                    StudentDetailsActivity.this,
                    SubjectActivity.class
            );

            // (Optional) send data to next activity
            intent.putExtra("name", name);
            intent.putExtra("course", course);
            intent.putExtra("semester", semester);
            intent.putExtra("university", university);

            startActivity(intent);
        });

        // Fix for edge-to-edge layout (IMPORTANT: match your layout id)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.studentLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}