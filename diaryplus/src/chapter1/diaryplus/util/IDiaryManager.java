package chapter1.diaryplus.util;

import java.util.ArrayList;

import chapter1.diary.bean.Diary;

public interface IDiaryManager
{
    // 保存日记文件
    // 如果保存成功则返回true, 保存失败则返回false
    public abstract boolean save(ArrayList<Diary> diaries);

    // 读取保存的日记文件
    // 如果日记文件存在且读取成功, 返回日记列表
    // 如果日记文件不存在或读取失败，返回空
public abstract ArrayList<Diary> load();


}
