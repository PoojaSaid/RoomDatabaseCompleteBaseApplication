package com.example.roomdatabaseexample.db;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.roomdatabaseexample.model.Person;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PersonDao_Impl implements PersonDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Person> __insertionAdapterOfPerson;

  private final EntityDeletionOrUpdateAdapter<Person> __deletionAdapterOfPerson;

  public PersonDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPerson = new EntityInsertionAdapter<Person>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Person` (`uid`,`name`,`education`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Person value) {
        stmt.bindLong(1, value.getUid());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getEducation() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEducation());
        }
      }
    };
    this.__deletionAdapterOfPerson = new EntityDeletionOrUpdateAdapter<Person>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Person` WHERE `uid` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Person value) {
        stmt.bindLong(1, value.getUid());
      }
    };
  }

  @Override
  public void addPerson(final Person person) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPerson.insert(person);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(f