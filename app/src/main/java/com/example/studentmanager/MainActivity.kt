package com.example.studentmanager

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtStudentId: EditText
    private lateinit var btnAdd: Button
    private lateinit var rvStudents: RecyclerView
    private lateinit var adapter: StudentAdapter
    private val studentList = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtName)
        edtStudentId = findViewById(R.id.edtStudentId)
        btnAdd = findViewById(R.id.btnAdd)
        rvStudents = findViewById(R.id.rvStudents)

        adapter = StudentAdapter(studentList) { position ->
            adapter.removeStudent(position)
        }

        rvStudents.layoutManager = LinearLayoutManager(this)
        rvStudents.adapter = adapter

        btnAdd.setOnClickListener {
            val name = edtName.text.toString()
            val mssv = edtStudentId.text.toString()
            if (name.isNotEmpty() && mssv.isNotEmpty()) {
                adapter.addStudentAtTop(Student(name, mssv))
                edtName.text.clear()
                edtStudentId.text.clear()
            }
        }
    }
}
