package com.example.objectboxdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val noteBox by lazy { ObjectBox.boxStore.boxFor(Note::class.java) }
    private var notes = mutableListOf<Note>()
    private val adapter by lazy { NoteAdapter(notes) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btnAdd.setOnClickListener {
            addNote()
        }
        rvNotes.layoutManager = LinearLayoutManager(this)
        rvNotes.adapter = adapter
        adapter.onItemClickListener = object:NoteAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                removeNote(notes[position])
            }
        }
        updateNotes()
    }

    private fun addNote() {
        val etNoteContent = etNote.text.toString()
        if (etNoteContent.isEmpty()) return
        val note = Note(text = etNoteContent, createAt = Date())
        noteBox.put(note)
        etNote.text.clear()
        updateNotes()
    }

    private fun updateNotes() {
//        notes = noteBox.all
        notes = noteBox.query()
                .order(Note_.text)
                .build()
                .find()
        adapter.setNotes(notes)
    }

    private fun removeNote(note: Note) {
        noteBox.remove(note)
        updateNotes()
    }
}
