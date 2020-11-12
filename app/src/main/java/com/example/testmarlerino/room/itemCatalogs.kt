package com.example.testmarlerino.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class itemCatalogs (@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "id")
                        var id: Long,
                        @ColumnInfo(name = "price")
                        var likes: String,
                        @ColumnInfo(name = "name")
                        var tags: String,
                        @ColumnInfo(name = "url")
                        var url: String,
                    @ColumnInfo(name = "BigUrl")
                    var bigUrl: String
                    )