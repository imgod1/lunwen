package com.du.easysignin.sql;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * 学生班级信息表
 * Created by Administrator on 2016/5/9.
 */
@Table(name="classinfo")
public class StuTable {
    //定义学号
    @Column(name="card_number",isId = true)
    private int card_number;

    //定义姓名
    @Column(name="name")
    private String name;

    //定义
}
