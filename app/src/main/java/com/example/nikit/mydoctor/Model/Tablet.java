package com.example.nikit.mydoctor.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.activeandroid.query.From;

import java.sql.Date;
import java.util.List;

@Table(name = "Tablet")
public class Tablet extends Model{
    @Column
    public String tabletName;

    @Column
    public int count;

    @Column
    public Date time;

    @Column
    public Date timeCheck;

    public Tablet(){
        super();
    }


}