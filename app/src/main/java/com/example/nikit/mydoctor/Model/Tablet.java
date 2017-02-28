package com.example.nikit.mydoctor.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.sql.Date;

@Table(name = "Tablet")
public class Tablet extends Model{
    @Column(name = "tablet_name")
    String tabletName;

    @Column(name = "tablet_count")
    int count;

    @Column(name = "tablet_time")
    Date time;

    @Column(name = "tablet_time_check")
    Date timeCheck;
}